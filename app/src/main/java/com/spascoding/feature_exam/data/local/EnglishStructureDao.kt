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
    /**
     * import not existing sentences into database
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun importNotExistedSentences(sentences: List<Sentence>)

    /**
     * update sentence during the exercise
     */
    @Update
    suspend fun updateSentence(sentence: Sentence)

    /**
     * get sentence for exercise
     */
    @Query("SELECT * FROM sentences WHERE tens=:tens AND topic=:topic ORDER BY usedCount ASC, mistakeCount DESC LIMIT 1")
    suspend fun getSentence(tens: Int, topic: String): Sentence

    // TENS QUERIES

    @Query("SELECT DISTINCT tens FROM sentences")
    suspend fun getTenses(): List<Int>

    @Query("SELECT SUM(mistakeCount) FROM sentences WHERE tens=:tens ORDER BY userValueTime DESC LIMIT :sentenceCount")
    suspend fun getMistakesCountByTens(tens: Int, sentenceCount: Int): Int
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

    @Query("SELECT SUM(usedCount) FROM sentences WHERE tens=:tens ORDER BY userValueTime DESC LIMIT :sentenceCount")
    suspend fun getUsedCountByTens(tens: Int, sentenceCount: Int): Int
    @Transaction
    suspend fun getUsedCounts(sentenceCount: Int): Map<Int, Int> {
        val usedCounts = mutableMapOf<Int, Int>()
        val tenses = getTenses()
        for (tens in tenses) {
            usedCounts[tens] = getUsedCountByTens(tens, sentenceCount)
        }
        return usedCounts;
    }

    @Query("SELECT COUNT(usedCount) FROM sentences WHERE tens=:tens AND usedCount > 0")
    suspend fun getSentencesCountByTens(tens: Int): Int
    @Transaction
    suspend fun getSentencesCounts(): Map<Int, Int> {
        val sentencesCounts = mutableMapOf<Int, Int>()
        val tenses = getTenses()
        for (tens in tenses) {
            sentencesCounts[tens] = getSentencesCountByTens(tens)
        }
        return sentencesCounts
    }

    // TOPICS QUERIES

    /**
     * Get all sentences for specific tens and topic
     */
    @Query("SELECT * FROM sentences WHERE tens=:tens AND topic=:topic ORDER BY usedCount ASC, mistakeCount DESC")
    suspend fun getSentences(tens: Int, topic: String): List<Sentence>

    @Query("SELECT DISTINCT topic FROM sentences WHERE tens=:tens")
    suspend fun getTopics(tens: Int): List<String>

    @Query("SELECT * FROM sentences WHERE tens=:tens AND topic=:topic AND usedCount > 0 ORDER BY userValueTime DESC LIMIT :sentenceCount")
    suspend fun getUsedSentencesByTensAndTopic(tens: Int, topic: String, sentenceCount: Int): List<Sentence>

    @Query("SELECT SUM(mistakeCount) FROM sentences WHERE tens=:tens AND topic=:topic ORDER BY userValueTime DESC LIMIT :sentenceCount")
    suspend fun getMistakesCountByTens(tens: Int, topic: String, sentenceCount: Int): Int
    @Transaction
    suspend fun getMistakesTopicsCountsByTens(tens: Int, sentenceCount: Int): Map<String, Int> {
        val mistakesCounts = mutableMapOf<String, Int>()
        val topics = getTopics(tens)
        for (topic in topics) {
            mistakesCounts[topic] =
                getMistakesCountByTens(tens, topic, sentenceCount)
        }
        return mistakesCounts
    }

    @Query("SELECT SUM(usedCount) FROM sentences WHERE tens=:tens AND topic=:topic ORDER BY userValueTime DESC LIMIT :sentenceCount")
    suspend fun getUsedCountByTens(tens: Int, topic: String, sentenceCount: Int): Int
    @Transaction
    suspend fun getUsedTopicsCountsByTens(tens: Int, sentenceCount: Int): Map<String, Int> {
        val usedCounts = mutableMapOf<String, Int>()
        val topics = getTopics(tens)
        for (topic in topics) {
            usedCounts[topic] = getUsedCountByTens(tens, topic, sentenceCount)
        }
        return usedCounts;
    }

    @Query("SELECT COUNT(usedCount) FROM sentences WHERE tens=:tens AND topic=:topic AND usedCount > 0")
    suspend fun getUsedSentencesCountByTensAndTopic(tens: Int, topic: String): Int
    @Transaction
    suspend fun getSentencesTopicsCountsByTens(tens: Int, sentenceCount: Int): Map<String, Int> {
        val sentencesCounts = mutableMapOf<String, Int>()
        val topics = getTopics(tens)
        for (topic in topics) {
            sentencesCounts[topic] = getUsedSentencesCountByTensAndTopic(tens, topic)
        }
        return sentencesCounts;
    }
}