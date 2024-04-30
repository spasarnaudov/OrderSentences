package com.spascoding.feature_exam.domain.repository

import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.sentence.entity.Sentence

interface EnglishStructureDatabaseRepository {
    suspend fun updateSentence(sentence: Sentence)
    suspend fun importNotExistedSentences(sentences: List<Sentence>)
    suspend fun getExamNames(tens: Tens): List<String>
    suspend fun getSentences(tens: Tens, examName: String): List<Sentence>
    suspend fun getSentencesCounts(): Map<Int, Int>
    suspend fun getSentence(tens: Tens, examName: String): Sentence
    suspend fun getMistakesCounts(sentenceCount: Int): Map<Int, Int>
    suspend fun getUsedCounts(sentenceCount: Int): Map<Int, Int>
    suspend fun getUserSentences(tens: Tens, examName: String, sentenceCount: Int): List<Sentence>
}