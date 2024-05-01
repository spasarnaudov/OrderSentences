package com.spascoding.feature_exam.domain.use_case.database

import com.spascoding.feature_exam.data.repository.EnglishStructureDatabaseRepositoryImpl
import com.spascoding.feature_exam.domain.model.TensAccuracyInfo
import javax.inject.Inject

class GetTensesAccuracyInfoUseCase @Inject constructor(
    private val repository: EnglishStructureDatabaseRepositoryImpl
) {

    suspend operator fun invoke(sentenceCount: Int): List<TensAccuracyInfo> {
        return repository.getTensesAccuracyInfo(sentenceCount)
    }

}