package com.spascoding.feature_exam.domain.use_case

import com.spascoding.feature_exam.domain.use_case.database.GetSentencesUseCase
import com.spascoding.feature_exam.domain.use_case.database.UpsertSentencesUseCase
import javax.inject.Inject

data class ExamUseCases @Inject constructor(
    val getExamUseCase: GetExamUseCase,
    val getSentencesUseCase: GetSentencesUseCase,
    val getUpsertSentencesUseCase: UpsertSentencesUseCase,
)