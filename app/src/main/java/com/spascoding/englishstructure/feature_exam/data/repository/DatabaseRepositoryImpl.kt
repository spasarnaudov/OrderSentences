package com.spascoding.englishstructure.feature_exam.data.repository

import com.spascoding.englishstructure.feature_exam.data.local.EnglishStructureDao
import com.spascoding.englishstructure.feature_exam.domain.enums.Tense
import com.spascoding.englishstructure.feature_exam.domain.model.TenseInfo
import com.spascoding.englishstructure.feature_exam.domain.model.TopicAccuracyInfo
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.entity.Sentence
import com.spascoding.englishstructure.feature_exam.domain.repository.DatabaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(
    private val dao: EnglishStructureDao
): DatabaseRepository {
    override suspend fun importNotExistedSentences(sentences: List<Sentence>) {
        dao.importNotExistedSentences(sentences)
    }

    override suspend fun updateSentence(sentence: Sentence) {
        dao.updateSentence(sentence)
    }

    override suspend fun getSentence(tense: Tense, topic: String): Sentence {
        return dao.getSentence(tense.int, topic)
    }

    // TENSES

    override fun getTenseInfo(): Flow<List<TenseInfo>> {
        return dao.getTenseInfo()
    }

    // TOPICS

    override suspend fun getSentences(tense: Tense, topic: String): List<Sentence> {
        return dao.getSentences(tense.int, topic)
    }

    override suspend fun getTopics(tense: Tense): List<String> {
        return dao.getTopics(tense.int)
    }

    override suspend fun getUsedSentencesByTenseAndTopic(tense: Tense, topic: String, sentenceCount: Int): List<Sentence> {
        return dao.getUsedSentencesByTensAndTopic(tense.int, topic, sentenceCount)
    }

    override suspend fun getTopicsAccuracyInfo(tense: Tense, sentenceCount: Int): List<TopicAccuracyInfo> {
        return dao.getTopicsAccuracyInfo(tense.int, sentenceCount)
    }
}