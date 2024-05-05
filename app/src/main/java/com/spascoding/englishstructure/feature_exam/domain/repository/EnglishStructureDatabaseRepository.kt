package com.spascoding.englishstructure.feature_exam.domain.repository

import com.spascoding.englishstructure.feature_exam.domain.enums.Tens
import com.spascoding.englishstructure.feature_exam.domain.model.TensAccuracyInfo
import com.spascoding.englishstructure.feature_exam.domain.model.TopicAccuracyInfo
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.entity.Sentence

interface EnglishStructureDatabaseRepository {
    suspend fun importNotExistedSentences(sentences: List<Sentence>)
    suspend fun updateSentence(sentence: Sentence)
    suspend fun getSentence(tens: Tens, examName: String): Sentence
    // TENSES
    suspend fun getTensesAccuracyInfo(sentenceCount: Int): List<TensAccuracyInfo>
    // TOPICS
    suspend fun getSentences(tens: Tens, examName: String): List<Sentence>
    suspend fun getTopics(tens: Tens): List<String>
    suspend fun getUsedSentencesByTensAndTopic(tens: Tens, examName: String, sentenceCount: Int): List<Sentence>
    suspend fun getTopicsAccuracyInfo(tens: Tens, sentenceCount: Int): List<TopicAccuracyInfo>
}