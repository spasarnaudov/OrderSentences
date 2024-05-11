package com.spascoding.englishstructure.feature_exam.domain.use_case.database

import com.spascoding.englishstructure.feature_exam.data.repository.DatabaseRepositoryImpl
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.entity.Sentence
import javax.inject.Inject

class UpdateSentenceUseCase @Inject constructor(
    private val repository: DatabaseRepositoryImpl
) {

    suspend operator fun invoke(sentence: Sentence) {
        return repository.updateSentence(sentence)
    }

}