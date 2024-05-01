package com.spascoding.feature_exam.domain.use_case

import com.spascoding.feature_exam.domain.use_case.database.GetMistakesCountsUseCase
import com.spascoding.feature_exam.domain.use_case.database.GetSentencesCountUseCase
import com.spascoding.feature_exam.domain.use_case.database.GetUsedCountUseCase
import javax.inject.Inject

data class TensUseCases @Inject constructor(
    val getMistakesCountsUseCase: GetMistakesCountsUseCase,
    val getUsedCountUseCase: GetUsedCountUseCase,
    val getSentencesCountsUseCase: GetSentencesCountUseCase,
)