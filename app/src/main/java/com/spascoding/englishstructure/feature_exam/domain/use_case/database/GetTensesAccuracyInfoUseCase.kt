package com.spascoding.englishstructure.feature_exam.domain.use_case.database

import com.spascoding.englishstructure.feature_exam.data.repository.EnglishStructureDatabaseRepositoryImpl
import com.spascoding.englishstructure.feature_exam.domain.model.TenseAccuracyInfo
import javax.inject.Inject

class GetTensesAccuracyInfoUseCase @Inject constructor(
    private val repository: EnglishStructureDatabaseRepositoryImpl
) {

    suspend operator fun invoke(sentenceCount: Int): List<TenseAccuracyInfo> {
        return repository.getTensesAccuracyInfo(sentenceCount)
    }

}