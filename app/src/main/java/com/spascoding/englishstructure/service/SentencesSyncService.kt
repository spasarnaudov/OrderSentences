package com.spascoding.englishstructure.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.spascoding.englishstructure.feature_exam.domain.use_case.DatabaseSyncUseCases
import com.spascoding.englishstructure.feature_exam.domain.utils.SentencesGenerator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SentencesSyncService : Service() {

    private val TAG = "SentencesSyncService"

    @Inject
    lateinit var databaseSyncUseCases: DatabaseSyncUseCases

    @OptIn(DelicateCoroutinesApi::class)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        GlobalScope.launch(Dispatchers.IO) {
            syncDatabaseWithSentences()
            stopSelf()
        }

        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private suspend fun syncDatabaseWithSentences() {
        //Generate sentences
        val examPatterns = databaseSyncUseCases.getExamPatternsUseCase.invoke()
        val generatedSentences = SentencesGenerator(examPatterns).generate()
        Log.d(TAG, "${generatedSentences.count()} sentences ware generated")

        val duplicatedSentences = generatedSentences.groupingBy { it }.eachCount().filter { it.value > 1 }
        for ((sentence, count) in duplicatedSentences) {
            Log.d(TAG, "${sentence.value} met $count times")
        }

        //Read database sentences
        val allDatabaseSentences = databaseSyncUseCases.getAllSentencesUseCase.invoke()
        Log.d(TAG, "${allDatabaseSentences.count()} were read from database")

        //Remove sentences that not exists in repository
        val sentencesThatNotExistInDatabase = allDatabaseSentences.toMutableList()
        val generatedSentencesValues = generatedSentences.map { it.value }
        sentencesThatNotExistInDatabase.removeAll { generatedSentencesValues.contains(it.value) }
        databaseSyncUseCases.removeExistedSentencesUseCase.invoke(sentencesThatNotExistInDatabase)
        Log.d(TAG, "${sentencesThatNotExistInDatabase.count()} sentences were removed from database")

        //Import all repository sentences
        databaseSyncUseCases.importNotExistedSentencesUseCase.invoke(generatedSentences)
        Log.d(TAG, "${generatedSentences.count()} sentences ware imported to database")

        //Read database sentences
        val allUpdatedDatabaseSentences = databaseSyncUseCases.getAllSentencesUseCase.invoke()
        Log.d(TAG, "${allUpdatedDatabaseSentences.count()} were read from database")
    }
}