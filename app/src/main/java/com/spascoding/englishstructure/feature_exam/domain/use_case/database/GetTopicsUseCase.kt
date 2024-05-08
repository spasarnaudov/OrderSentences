package com.spascoding.englishstructure.feature_exam.domain.use_case.database

import com.spascoding.englishstructure.feature_exam.data.repository.EnglishStructureDatabaseRepositoryImpl
import com.spascoding.englishstructure.feature_exam.domain.enums.Tense
import javax.inject.Inject

class GetTopicsUseCase @Inject constructor(
    private val repository: EnglishStructureDatabaseRepositoryImpl
) {

    suspend operator fun invoke(tense: Tense): List<String> {
        return repository.getTopics(tense)
    }

}