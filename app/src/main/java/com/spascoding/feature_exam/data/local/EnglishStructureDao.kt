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

    @Query("SELECT DISTINCT examName FROM sentences WHERE tens=:examTens")
    suspend fun getExamNames(examTens: Int): List<String>

    @Query("SELECT * FROM sentences WHERE tens=:examTens AND examName=:examName ORDER BY useCount ASC, mistakeCount DESC LIMIT 1")
    suspend fun getSentence(examTens: Int, examName: String): Sentence

    @Query("SELECT * FROM sentences WHERE tens=:examTens AND examName=:examName")
    suspend fun getSentences(examTens: Int, examName: String): List<Sentence>

    @Transaction
    suspend fun getSentenceAndIncrementUsageCount(tens: Tens, examName: String): Sentence {
        val sentence = getSentence(tens.int, examName)
        val verbWithIncrementedUseCount = sentence.copy(
            useCount = sentence.useCount + 1
        )
        upsertSentence(verbWithIncrementedUseCount)
        return verbWithIncrementedUseCount
    }
}