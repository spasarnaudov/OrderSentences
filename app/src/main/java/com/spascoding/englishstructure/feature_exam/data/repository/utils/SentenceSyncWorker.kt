package com.spascoding.englishstructure.feature_exam.data.repository.utils

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.spascoding.englishstructure.feature_exam.domain.use_case.DatabaseSyncUseCases
import com.spascoding.englishstructure.feature_exam.domain.utils.SentencesGenerator
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@HiltWorker
class SentenceSyncWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val databaseSyncUseCases: DatabaseSyncUseCases,
) : CoroutineWorker(context, workerParams) {

    private val TAG = "SentenceSyncWorker"

    companion object {
        fun sync(context: Context) {
            val workRequest = OneTimeWorkRequestBuilder<SentenceSyncWorker>().build()
            WorkManager.getInstance(context).enqueue(workRequest)
        }
    }

    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO) {
            syncDatabaseWithSentences()
            Result.success()
        }
    }

    private suspend fun syncDatabaseWithSentences() {
        //Generate sentences
        val examPatterns = databaseSyncUseCases.getExamPatternsUseCase.invoke()
        val generatedSentences = SentencesGenerator(examPatterns).generate()
        Log.d(TAG, "${generatedSentences.count()} sentences ware generated")

        val duplicatedSentences =
            generatedSentences.groupingBy { it }.eachCount().filter { it.value > 1 }
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
        Log.d(
            TAG,
            "${sentencesThatNotExistInDatabase.count()} sentences were removed from database"
        )

        //Import all repository sentences
        databaseSyncUseCases.importNotExistedSentencesUseCase.invoke(generatedSentences)
        Log.d(TAG, "${generatedSentences.count()} sentences ware imported to database")

        //Read database sentences
        val allUpdatedDatabaseSentences = databaseSyncUseCases.getAllSentencesUseCase.invoke()
        Log.d(TAG, "${allUpdatedDatabaseSentences.count()} were read from database")
    }
}