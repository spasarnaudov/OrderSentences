package com.spascoding.feature_exam.data.repository

import com.spascoding.feature_exam.data.local.EnglishStructureDao
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.sentence.entity.Sentence
import com.spascoding.feature_exam.domain.repository.EnglishStructureDatabaseRepository
import javax.inject.Inject

class EnglishStructureDatabaseRepositoryImpl @Inject constructor(
    private val dao: EnglishStructureDao
): EnglishStructureDatabaseRepository {
    override suspend fun updateSentence(sentence: Sentence) {
        dao.updateSentence(sentence)
    }

    override suspend fun importNotExistedSentences(sentences: List<Sentence>) {
        dao.importNotExistedSentences(sentences)
    }

    override suspend fun getExamNames(tens: Tens): List<String> {
        return dao.getExamNames(tens.int)
    }

    override suspend fun getSentences(tens: Tens, examName: String): List<Sentence> {
        return dao.getSentences(tens.int, examName)
    }

    override suspend fun getSentencesCounts(): Map<Int, Int> {
        return dao.getSentencesCounts()
    }

    override suspend fun getSentence(tens: Tens, examName: String): Sentence {
        return dao.getSentence(tens.int, examName)
    }

    override suspend fun getMistakesCounts(sentenceCount: Int): Map<Int, Int> {
        return dao.getMistakesCounts(sentenceCount)
    }

    override suspend fun getUseCounts(sentenceCount: Int): Map<Int, Int> {
        return dao.getUseCounts(sentenceCount)
    }

    override suspend fun getUserSentences(tens: Tens, examName: String, sentenceCount: Int): List<Sentence> {
        return dao.getUserSentences(tens.int, examName, sentenceCount)
    }
}