package com.spascoding.englishstructure.feature_exam.domain.use_case.database

import com.spascoding.englishstructure.feature_exam.data.repository.DatabaseRepositoryImpl
import com.spascoding.englishstructure.feature_exam.domain.enums.Tense
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTopicsUseCase @Inject constructor(
    private val repository: DatabaseRepositoryImpl
) {

    operator fun invoke(tense: Tense): Flow<List<String>> {
        return repository.getTopics(tense)
    }

}