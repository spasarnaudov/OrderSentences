package com.spascoding.feature_exam.domain.use_case.database

import com.spascoding.feature_exam.data.repository.EnglishStructureDatabaseRepositoryImpl
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.sentence.entity.Sentence
import javax.inject.Inject

class GetUsedSentenceUseCase @Inject constructor(
    private val repository: EnglishStructureDatabaseRepositoryImpl
) {

    suspend operator fun invoke(tens: Tens, examName: String, sentenceCount: Int): List<Sentence> {
        return repository.getUsedSentences(tens, examName, sentenceCount)
    }

}