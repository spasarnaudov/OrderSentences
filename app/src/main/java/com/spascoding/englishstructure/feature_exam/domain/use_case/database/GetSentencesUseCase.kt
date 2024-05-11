package com.spascoding.englishstructure.feature_exam.domain.use_case.database

import com.spascoding.englishstructure.feature_exam.data.repository.DatabaseRepositoryImpl
import com.spascoding.englishstructure.feature_exam.domain.enums.Tense
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.entity.Sentence
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSentencesUseCase @Inject constructor(
    private val repository: DatabaseRepositoryImpl
) {

    operator fun invoke(tense: Tense, examName: String): Flow<List<Sentence>> {
        return repository.getSentences(tense, examName)
    }

}