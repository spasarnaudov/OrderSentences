package com.spascoding.feature_exam.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.sentence.entity.Sentence

@Dao
interface EnglishStructureDao {
    @Upsert
    suspend fun upsertSentence(sentence: Sentence)

    @Upsert
    suspend fun upsertSentences(sentences: List<Sentence>)

    @Query("SELECT * FROM sentences WHERE tens=:examTens LIMIT 1")
    fun getSentence(examTens: Int): Sentence

    @Query("SELECT * FROM sentences WHERE tens=:examTens")
    suspend fun getSentences(examTens: Int): List<Sentence>

    @Transaction
    suspend fun getSentenceAndIncrementUsageCount(tens: Tens): Sentence {
        val sentence = getSentence(tens.int)
        val verbWithIncrementedUseCount = sentence.copy(
            useCount = sentence.useCount + 1
        )
        upsertSentence(verbWithIncrementedUseCount)
        return verbWithIncrementedUseCount
    }
}