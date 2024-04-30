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

    @Query("SELECT * FROM sentences WHERE tens=:examTens AND examName=:examName ORDER BY usedCount ASC, mistakeCount DESC LIMIT 1")
    suspend fun getSentence(examTens: Int, examName: String): Sentence

    @Query("SELECT * FROM sentences WHERE tens=:examTens AND examName=:examName ORDER BY usedCount ASC, mistakeCount DESC")
    suspend fun getSentences(examTens: Int, examName: String): List<Sentence>

    //tens screen queries

    @Query("SELECT DISTINCT tens FROM sentences")
    suspend fun getTenses(): List<Int>

    @Query("SELECT SUM(mistakeCount) FROM sentences WHERE tens=:examTens ORDER BY userValueTime DESC LIMIT :sentenceCount")
    suspend fun getMistakesCountByTens(examTens: Int, sentenceCount: Int): Int

    @Query("SELECT SUM(usedCount) FROM sentences WHERE tens=:examTens ORDER BY userValueTime DESC LIMIT :sentenceCount")
    suspend fun getUsedCountByTens(examTens: Int, sentenceCount: Int): Int

    @Query("SELECT COUNT(usedCount) FROM sentences WHERE tens=:examTens AND usedCount > 0")
    suspend fun getSentencesCountByTens(examTens: Int): Int

    @Transaction
    suspend fun getSentencesCounts(): Map<Int, Int> {
        val sentencesCounts = mutableMapOf<Int, Int>()
        val tenses = getTenses()
        for (tens in tenses) {
            sentencesCounts[tens] = getSentencesCountByTens(tens)
        }
        return sentencesCounts
    }

    @Transaction
    suspend fun getMistakesCounts(sentenceCount: Int): Map<Int, Int> {
        val mistakesCounts = mutableMapOf<Int, Int>()
        val tenses = getTenses()
        for (tens in tenses) {
            mistakesCounts[tens] =
                getMistakesCountByTens(tens, sentenceCount)
        }
        return mistakesCounts
    }

    @Transaction
    suspend fun getUsedCounts(sentenceCount: Int): Map<Int, Int> {
        val usedCounts = mutableMapOf<Int, Int>()
        val tenses = getTenses()
        for (tens in tenses) {
            usedCounts[tens] = getUsedCountByTens(tens, sentenceCount)
        }
        return usedCounts;
    }

    // exam list queries

    @Query("SELECT DISTINCT examName FROM sentences WHERE tens=:examTens")
    suspend fun getExamNames(examTens: Int): List<String>

    @Query("SELECT * FROM sentences WHERE tens=:examTens AND examName=:examName AND usedCount > 0 ORDER BY userValueTime DESC LIMIT :sentenceCount")
    suspend fun getUsedSentences(examTens: Int, examName: String, sentenceCount: Int): List<Sentence>

    @Query("SELECT SUM(mistakeCount) FROM sentences WHERE tens=:examTens AND examName=:examName ORDER BY userValueTime DESC LIMIT :sentenceCount")
    suspend fun getMistakesCountByTens(examTens: Int, examName: String, sentenceCount: Int): Int

    @Query("SELECT SUM(usedCount) FROM sentences WHERE tens=:examTens AND examName=:examName ORDER BY userValueTime DESC LIMIT :sentenceCount")
    suspend fun getUsedCountByTens(examTens: Int, examName: String, sentenceCount: Int): Int

    @Query("SELECT COUNT(usedCount) FROM sentences WHERE tens=:examTens AND examName=:examName AND usedCount > 0")
    suspend fun getSentencesCountByTensAndExamName(examTens: Int, examName: String): Int

    @Transaction
    suspend fun getMistakesCountsByTens(tens: Int, sentenceCount: Int): Map<String, Int> {
        val mistakesCounts = mutableMapOf<String, Int>()
        val examNames = getExamNames(tens)
        for (examName in examNames) {
            mistakesCounts[examName] =
                getMistakesCountByTens(tens, examName, sentenceCount)
        }
        return mistakesCounts
    }

    @Transaction
    suspend fun getUsedCountsByTens(tens: Int, sentenceCount: Int): Map<String, Int> {
        val usedCounts = mutableMapOf<String, Int>()
        val examNames = getExamNames(tens)
        for (examName in examNames) {
            usedCounts[examName] = getUsedCountByTens(tens, examName, sentenceCount)
        }
        return usedCounts;
    }

    @Transaction
    suspend fun getSentencesCountsByTens(tens: Int, sentenceCount: Int): Map<String, Int> {
        val sentencesCounts = mutableMapOf<String, Int>()
        val examNames = getExamNames(tens)
        for (examName in examNames) {
            sentencesCounts[examName] = getSentencesCountByTensAndExamName(tens, examName)
        }
        return sentencesCounts;
    }
}