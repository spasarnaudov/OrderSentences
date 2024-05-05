package com.spascoding.englishstructure.feature_exam.domain.use_case

import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetTopicsUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetMistakesTopicsCountsByTensUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetSentencesUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetSentencesTopicsCountsByTensUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetUsedTopicsCountsByTensUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetUsedSentencesByTensAndTopicUseCase
import javax.inject.Inject

data class TopicsUseCases @Inject constructor(
    val getSentencesUseCase: GetSentencesUseCase,
    val getTopicsUseCase: GetTopicsUseCase,
    val getUsedSentencesByTensAndTopicUseCase: GetUsedSentencesByTensAndTopicUseCase,
    val getMistakesTopicsCountsByTensUseCase: GetMistakesTopicsCountsByTensUseCase,
    val getUsedTopicsCountsByTensUseCase: GetUsedTopicsCountsByTensUseCase,
    val getSentencesTopicsCountsByTensUseCase: GetSentencesTopicsCountsByTensUseCase,
)