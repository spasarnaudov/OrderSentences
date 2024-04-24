package com.spascoding.feature_exam.data.repository

import com.spascoding.feature_exam.data.local.EnglishStructureDao
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.sentence.entity.Sentence
import com.spascoding.feature_exam.domain.repository.EnglishStructureDatabaseRepository
import javax.inject.Inject

class EnglishStructureDatabaseRepositoryImpl @Inject constructor(
    private val dao: EnglishStructureDao
): EnglishStructureDatabaseRepository {
    override suspend fun upsertSentence(sentence: Sentence) {
        dao.upsertSentence(sentence)
    }

    override suspend fun upsertSentences(sentences: List<Sentence>) {
        dao.upsertSentences(sentences)
    }

    override suspend fun getExamNames(tens: Tens): List<String> {
        return dao.getExamNames(tens.int)
    }

    override suspend fun getSentence(tens: Tens): Sentence {
        return dao.getSentence(tens.int)
    }

    override suspend fun getSentences(tens: Tens, examName: String): List<Sentence> {
        return dao.getSentences(tens.int, examName)
    }

    override suspend fun getSentenceAndIncrementUsageCount(tens: Tens): Sentence {
        return dao.getSentenceAndIncrementUsageCount(tens)
    }
}