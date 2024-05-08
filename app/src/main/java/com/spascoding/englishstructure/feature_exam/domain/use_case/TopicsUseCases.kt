package com.spascoding.englishstructure.feature_exam.domain.use_case

import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetTopicsUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetSentencesUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetTopicsAccuracyInfoUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetUsedSentencesByTenseAndTopicUseCase
import javax.inject.Inject

data class TopicsUseCases @Inject constructor(
    val getSentencesUseCase: GetSentencesUseCase,
    val getTopicsUseCase: GetTopicsUseCase,
    val getUsedSentencesByTenseAndTopicUseCase: GetUsedSentencesByTenseAndTopicUseCase,
    val getTopicsAccuracyInfoUseCase: GetTopicsAccuracyInfoUseCase,
)