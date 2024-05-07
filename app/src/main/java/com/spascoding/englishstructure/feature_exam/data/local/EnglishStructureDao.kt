package com.spascoding.englishstructure.feature_exam.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.spascoding.englishstructure.feature_exam.domain.enums.Tens
import com.spascoding.englishstructure.feature_exam.domain.model.TensAccuracyInfo
import com.spascoding.englishstructure.feature_exam.domain.model.TopicAccuracyInfo
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.entity.Sentence

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

    @Query("SELECT SUM(mistakeCount) FROM (SELECT * FROM sentences WHERE tens=:tens ORDER BY userValueTime DESC LIMIT :sentenceCount)")
    suspend fun getMistakesCountByTens(tens: Int, sentenceCount: Int): Int

    @Query("SELECT SUM(usedCount) FROM (SELECT * FROM sentences WHERE tens=:tens ORDER BY userValueTime DESC LIMIT :sentenceCount)")
    suspend fun getUsedCountByTens(tens: Int, sentenceCount: Int): Int

    @Query("SELECT COUNT(usedCount) FROM sentences WHERE tens=:tens AND usedCount > 0")
    suspend fun getSentencesCountByTens(tens: Int): Int

    @Transaction
    suspend fun getTensesAccuracyInfo(sentenceCount: Int): List<TensAccuracyInfo> {
        val data = mutableListOf<TensAccuracyInfo>()

        val tenses = getTenses()
        for (tens in tenses) {
            val mistakesCount = getMistakesCountByTens(tens, sentenceCount)
            val usedCountByTens = getUsedCountByTens(tens, sentenceCount)
            val sentencesCount = getSentencesCountByTens(tens)
            val topicsAccuracyInfo = getTopicsAccuracyInfo(tens, sentenceCount)
            data.add(
                TensAccuracyInfo(
                    tens = Tens.fromInt(tens),
                    mistakesCount = mistakesCount,
                    usedCount = usedCountByTens,
                    sentencesCount = sentencesCount,
                    topicsAccuracyInfo = topicsAccuracyInfo,
                )
            )
        }

        return data
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
    suspend fun getUsedSentencesByTensAndTopic(
        tens: Int,
        topic: String,
        sentenceCount: Int
    ): List<Sentence>

    @Query("SELECT SUM(mistakeCount) FROM sentences WHERE tens=:tens AND topic=:topic ORDER BY userValueTime DESC LIMIT :sentenceCount")
    suspend fun getMistakesCountByTens(tens: Int, topic: String, sentenceCount: Int): Int

    @Query("SELECT SUM(usedCount) FROM sentences WHERE tens=:tens AND topic=:topic ORDER BY userValueTime DESC LIMIT :sentenceCount")
    suspend fun getUsedCountByTens(tens: Int, topic: String, sentenceCount: Int): Int

    @Query("SELECT COUNT(usedCount) FROM sentences WHERE tens=:tens AND topic=:topic AND usedCount > 0")
    suspend fun getUsedSentencesCountByTensAndTopic(tens: Int, topic: String): Int

    @Transaction
    suspend fun getTopicsAccuracyInfo(tens: Int, sentenceCount: Int): List<TopicAccuracyInfo> {
        val data = mutableListOf<TopicAccuracyInfo>()

        val topics = getTopics(tens)
        for (topic in topics) {
            val mistakesCount = getMistakesCountByTens(tens, topic, sentenceCount)
            val usedCountByTens = getUsedCountByTens(tens, topic, sentenceCount)
            val sentencesCount = getUsedSentencesCountByTensAndTopic(tens, topic)
            data.add(
                TopicAccuracyInfo(
                    topic = topic,
                    mistakesCount = mistakesCount,
                    usedCount = usedCountByTens,
                    sentencesCount = sentencesCount,
                )
            )
        }

        return data
    }
}