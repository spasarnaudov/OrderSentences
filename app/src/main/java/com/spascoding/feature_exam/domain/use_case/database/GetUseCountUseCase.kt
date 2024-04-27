package com.spascoding.feature_exam.domain.use_case.database

import com.spascoding.feature_exam.data.repository.EnglishStructureDatabaseRepositoryImpl
import javax.inject.Inject

class GetUseCountUseCase @Inject constructor(
    private val repository: EnglishStructureDatabaseRepositoryImpl
) {

    suspend operator fun invoke(sentenceCount: Int): Map<Int, Int> {
        return repository.getUseCounts(sentenceCount)
    }

}