package com.spascoding.englishstructure.feature_exam.domain.use_case.database

import com.spascoding.englishstructure.feature_exam.data.repository.DatabaseRepositoryImpl
import com.spascoding.englishstructure.feature_exam.domain.enums.Tense
import com.spascoding.englishstructure.feature_exam.domain.model.TopicAccuracyInfo
import javax.inject.Inject

class GetTopicsAccuracyInfoUseCase @Inject constructor(
    private val repository: DatabaseRepositoryImpl
) {

    suspend operator fun invoke(tense: Tense, sentenceCount: Int): List<TopicAccuracyInfo> {
        return repository.getTopicsAccuracyInfo(tense, sentenceCount)
    }

}