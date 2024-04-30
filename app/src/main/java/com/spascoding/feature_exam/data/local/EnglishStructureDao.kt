package com.spascoding.feature_exam.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.spascoding.feature_exam.domain.model.sentence.entity.Sentence

@Dao
interface EnglishStructureDao {
    @Update
    suspend fun updateSentence(sentence: Sentence)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun importNotExistedSentences(sentences: List<Sentence>)

    @Query("SELECT DISTINCT examName FROM sentences WHERE tens=:examTens")
    suspend fun getExamNames(examTens: Int): List<String>

    @Query("SELECT * FROM sentences WHERE tens=:examTens AND examName=:examName ORDER BY useCount ASC, mistakeCount DESC LIMIT 1")
    suspend fun getSentence(examTens: Int, examName: String): Sentence

    @Query("SELECT * FROM sentences WHERE tens=:examTens AND examName=:examName ORDER BY useCount ASC, mistakeCount DESC")
    suspend fun getSentences(examTens: Int, examName: String): List<Sentence>

    @Query("SELECT COUNT(useCount) FROM sentences WHERE tens=:examTens AND useCount > 0")
    suspend fun getSentencesCount(examTens: Int): Int

    @Query("SELECT DISTINCT tens FROM sentences")
    suspend fun getTenses(): List<Int>

    @Query("SELECT SUM(mistakeCount) FROM sentences WHERE tens=:examTens ORDER BY userValueTime DESC LIMIT :sentenceCount")
    suspend fun getMistakesCount(examTens: Int, sentenceCount: Int): Int

    @Query("SELECT SUM(useCount) FROM sentences WHERE tens=:examTens ORDER BY userValueTime DESC LIMIT :sentenceCount")
    suspend fun getUseCount(examTens: Int, sentenceCount: Int): Int

    @Transaction
    suspend fun getSentencesCounts(): Map<Int, Int> {
        val sentencesCounts = mutableMapOf<Int, Int>()
        val tenses = getTenses()
        for (tens in tenses) {
            sentencesCounts[tens] = getSentencesCount(tens)
        }
        return sentencesCounts
    }

    @Transaction
    suspend fun getMistakesCounts(sentenceCount: Int): Map<Int, Int> {
        val mistakesCounts = mutableMapOf<Int, Int>()
        val tenses = getTenses()
        for (tens in tenses) {
            mistakesCounts[tens] = getMistakesCount(tens, sentenceCount)
        }
        return mistakesCounts
    }

    @Transaction
    suspend fun getUseCounts(sentenceCount: Int): Map<Int, Int> {
        val useCounts = mutableMapOf<Int, Int>()
        val tenses = getTenses()
        for (tens in tenses) {
            useCounts[tens] = getUseCount(tens, sentenceCount)
        }
        return useCounts;
    }

    @Query("SELECT * FROM sentences WHERE tens=:examTens AND examName=:examName AND useCount > 0 ORDER BY userValueTime DESC LIMIT :sentenceCount")
    suspend fun getUserSentences(examTens: Int, examName: String, sentenceCount: Int): List<Sentence>
}