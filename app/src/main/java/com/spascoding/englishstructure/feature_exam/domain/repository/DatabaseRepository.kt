package com.spascoding.englishstructure.feature_exam.domain.repository

import com.spascoding.englishstructure.feature_exam.domain.enums.Tense
import com.spascoding.englishstructure.feature_exam.domain.model.TenseInfo
import com.spascoding.englishstructure.feature_exam.domain.model.TopicAccuracyInfo
import com.spascoding.englishstructure.feature_exam.domain.model.TopicInfo
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.entity.Sentence
import kotlinx.coroutines.flow.Flow

interface DatabaseRepository {
    suspend fun importNotExistedSentences(sentences: List<Sentence>)
    suspend fun updateSentence(sentence: Sentence)
    suspend fun getSentence(tense: Tense, examName: String): Sentence
    // TENSES
    fun getTenseInfo(): Flow<List<TenseInfo>>
    // TOPICS
    fun getTopicInfo(tense: Tense): Flow<List<TopicInfo>>
    suspend fun getSentences(tense: Tense, examName: String): List<Sentence>
    suspend fun getTopics(tense: Tense): List<String>
    suspend fun getUsedSentencesByTenseAndTopic(tense: Tense, examName: String, sentenceCount: Int): List<Sentence>
}