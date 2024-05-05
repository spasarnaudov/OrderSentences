package com.spascoding.englishstructure.feature_exam.domain.use_case.database

import com.spascoding.englishstructure.feature_exam.data.repository.EnglishStructureDatabaseRepositoryImpl
import com.spascoding.englishstructure.feature_exam.domain.enums.Tens
import javax.inject.Inject

class GetMistakesTopicsCountsByTensUseCase @Inject constructor(
    private val repository: EnglishStructureDatabaseRepositoryImpl
) {

    suspend operator fun invoke(
        tens: Tens,
        sentenceCount: Int
    ): Map<String, Int> {
        return repository.getMistakesTopicsCountsByTens(tens, sentenceCount)
    }

}