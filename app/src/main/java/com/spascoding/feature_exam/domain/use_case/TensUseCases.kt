package com.spascoding.feature_exam.domain.use_case

import com.spascoding.feature_exam.domain.use_case.database.GetTensesAccuracyInfoUseCase
import javax.inject.Inject

data class TensUseCases @Inject constructor(
    val getTensesAccuracyInfoUseCase: GetTensesAccuracyInfoUseCase,
)