package com.spascoding.feature_exam.domain.use_case

import javax.inject.Inject

data class ExamUseCases @Inject constructor(
    val getExamUseCase: GetExamUseCase,
)