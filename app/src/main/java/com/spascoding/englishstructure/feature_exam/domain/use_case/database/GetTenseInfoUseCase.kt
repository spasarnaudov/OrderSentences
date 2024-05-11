package com.spascoding.englishstructure.feature_exam.domain.use_case.database

import com.spascoding.englishstructure.feature_exam.data.repository.DatabaseRepositoryImpl
import com.spascoding.englishstructure.feature_exam.domain.model.TenseInfo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTenseInfoUseCase @Inject constructor(
    private val repository: DatabaseRepositoryImpl
) {

    operator fun invoke(): Flow<List<TenseInfo>> {
        return repository.getTenseInfo()
    }

}