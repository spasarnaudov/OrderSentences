package com.spascoding.feature_exam.domain.repository

import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.sentence.entity.Sentence

interface EnglishStructureDatabaseRepository {
    suspend fun upsertSentence(sentence: Sentence)
    suspend fun upsertSentences(sentences: List<Sentence>)
    suspend fun getSentence(tens: Tens): Sentence
    suspend fun getSentences(tens: Tens): List<Sentence>
    suspend fun getSentenceAndIncrementUsageCount(tens: Tens): Sentence
}