package com.spascoding.feature_exam.domain.use_case.database

import com.spascoding.feature_exam.data.repository.EnglishStructureDatabaseRepositoryImpl
import com.spascoding.feature_exam.domain.model.sentence.entity.Sentence
import javax.inject.Inject

class ImportNotExistedSentencesUseCase @Inject constructor(
    private val repository: EnglishStructureDatabaseRepositoryImpl
) {

    suspend operator fun invoke(sentences: List<Sentence>) {
        return repository.importNotExistedSentences(sentences)
    }

}