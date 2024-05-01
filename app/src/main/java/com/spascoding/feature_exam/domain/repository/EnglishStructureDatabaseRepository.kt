package com.spascoding.feature_exam.domain.repository

import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.sentence.entity.Sentence

interface EnglishStructureDatabaseRepository {
    suspend fun importNotExistedSentences(sentences: List<Sentence>)
    suspend fun updateSentence(sentence: Sentence)
    suspend fun getSentence(tens: Tens, examName: String): Sentence
    // TENSES
    suspend fun getMistakesCounts(sentenceCount: Int): Map<Int, Int>
    suspend fun getUsedCounts(sentenceCount: Int): Map<Int, Int>
    suspend fun getSentencesCounts(): Map<Int, Int>
    // TOPICS
    suspend fun getSentences(tens: Tens, examName: String): List<Sentence>
    suspend fun getTopics(tens: Tens): List<String>
    suspend fun getUsedSentencesByTensAndTopic(tens: Tens, examName: String, sentenceCount: Int): List<Sentence>
    suspend fun getMistakesTopicsCountsByTens(tens: Tens, sentenceCount: Int): Map<String, Int>
    suspend fun getUsedTopicsCountsByTens(tens: Tens, sentenceCount: Int): Map<String, Int>
    suspend fun getSentencesTopicsCountsByTens(tens: Tens, sentenceCount: Int): Map<String, Int>
}