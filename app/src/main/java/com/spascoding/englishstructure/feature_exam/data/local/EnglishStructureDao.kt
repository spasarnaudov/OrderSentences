package com.spascoding.englishstructure.feature_exam.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.spascoding.englishstructure.feature_exam.domain.enums.Tense
import com.spascoding.englishstructure.feature_exam.domain.model.TenseAccuracyInfo
import com.spascoding.englishstructure.feature_exam.domain.model.TenseInfo
import com.spascoding.englishstructure.feature_exam.domain.model.TopicAccuracyInfo
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.entity.Sentence
import kotlinx.coroutines.flow.Flow

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
    @Query("SELECT * FROM sentences WHERE tense=:tense AND topic=:topic ORDER BY usedCount ASC, mistakeCount DESC, RANDOM() LIMIT 1")
    suspend fun getSentence(tense: Int, topic: String): Sentence

    // TENSE QUERIES

    @Query(
        "SELECT " +
                "tense, " +
                "CAST(SUM(usedCount - mistakeCount) AS FLOAT) * 100 / SUM(usedCount) AS accuracy," +
                "COUNT(*) AS sentenceCount " +
                "FROM sentences " +
                "WHERE usedCount > 0 " +
                "GROUP BY tense"
    )
    fun getTenseInfo(): Flow<List<TenseInfo>>

    // TOPICS QUERIES

    /**
     * Get all sentences for specific tens and topic
     */
    @Query("SELECT * FROM sentences WHERE tense=:tens AND topic=:topic ORDER BY usedCount ASC, mistakeCount DESC")
    suspend fun getSentences(tens: Int, topic: String): List<Sentence>

    @Query("SELECT DISTINCT topic FROM sentences WHERE tense=:tens")
    suspend fun getTopics(tens: Int): List<String>

    @Query("SELECT * FROM sentences WHERE tense=:tens AND topic=:topic AND usedCount > 0 ORDER BY userValueTime DESC LIMIT :sentenceCount")
    suspend fun getUsedSentencesByTensAndTopic(
        tens: Int,
        topic: String,
        sentenceCount: Int
    ): List<Sentence>

    @Query("SELECT SUM(mistakeCount) FROM (SELECT * FROM sentences WHERE tense=:tense AND topic=:topic ORDER BY userValueTime DESC LIMIT :sentenceCount)")
    suspend fun getMistakesCountByTense(tense: Int, topic: String, sentenceCount: Int): Int

    @Query("SELECT SUM(usedCount) FROM (SELECT * FROM sentences WHERE tense=:tense AND topic=:topic ORDER BY userValueTime DESC LIMIT :sentenceCount)")
    suspend fun getUsedCountByTense(tense: Int, topic: String, sentenceCount: Int): Int

    @Query("SELECT COUNT(usedCount) FROM sentences WHERE tense=:tens AND topic=:topic AND usedCount > 0")
    suspend fun getUsedSentencesCountByTensAndTopic(tens: Int, topic: String): Int

    @Transaction
    suspend fun getTopicsAccuracyInfo(tens: Int, sentenceCount: Int): List<TopicAccuracyInfo> {
        val data = mutableListOf<TopicAccuracyInfo>()

        val topics = getTopics(tens)
        for (topic in topics) {
            val mistakesCount = getMistakesCountByTense(tens, topic, sentenceCount)
            val usedCountByTens = getUsedCountByTense(tens, topic, sentenceCount)
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