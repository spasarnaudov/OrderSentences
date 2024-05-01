package com.spascoding.feature_exam.data.repository

import com.spascoding.feature_exam.data.local.EnglishStructureDao
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.sentence.entity.Sentence
import com.spascoding.feature_exam.domain.repository.EnglishStructureDatabaseRepository
import javax.inject.Inject

class EnglishStructureDatabaseRepositoryImpl @Inject constructor(
    private val dao: EnglishStructureDao
): EnglishStructureDatabaseRepository {
    override suspend fun importNotExistedSentences(sentences: List<Sentence>) {
        dao.importNotExistedSentences(sentences)
    }

    override suspend fun updateSentence(sentence: Sentence) {
        dao.updateSentence(sentence)
    }

    override suspend fun getSentence(tens: Tens, topic: String): Sentence {
        return dao.getSentence(tens.int, topic)
    }

    // TENSES

    override suspend fun getMistakesCounts(sentenceCount: Int): Map<Int, Int> {
        return dao.getMistakesCounts(sentenceCount)
    }

    override suspend fun getUsedCounts(sentenceCount: Int): Map<Int, Int> {
        return dao.getUsedCounts(sentenceCount)
    }

    override suspend fun getSentencesCounts(): Map<Int, Int> {
        return dao.getSentencesCounts()
    }

    // TOPICS

    override suspend fun getSentences(tens: Tens, topic: String): List<Sentence> {
        return dao.getSentences(tens.int, topic)
    }

    override suspend fun getTopics(tens: Tens): List<String> {
        return dao.getTopics(tens.int)
    }

    override suspend fun getUsedSentencesByTensAndTopic(tens: Tens, topic: String, sentenceCount: Int): List<Sentence> {
        return dao.getUsedSentencesByTensAndTopic(tens.int, topic, sentenceCount)
    }

    override suspend fun getMistakesTopicsCountsByTens(
        tens: Tens,
        sentenceCount: Int
    ): Map<String, Int> {
        return dao.getMistakesTopicsCountsByTens(tens.int, sentenceCount)
    }

    override suspend fun getUsedTopicsCountsByTens(
        tens: Tens,
        sentenceCount: Int
    ): Map<String, Int> {
        return dao.getUsedTopicsCountsByTens(tens.int, sentenceCount)
    }

    override suspend fun getSentencesTopicsCountsByTens(tens: Tens, sentenceCount: Int): Map<String, Int> {
        return dao.getSentencesTopicsCountsByTens(tens.int, sentenceCount)
    }
}