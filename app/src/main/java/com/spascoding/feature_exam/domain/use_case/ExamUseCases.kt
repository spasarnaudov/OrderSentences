package com.spascoding.feature_exam.domain.use_case

import com.spascoding.feature_exam.domain.use_case.database.GetExamNamesUseCase
import com.spascoding.feature_exam.domain.use_case.database.GetSentenceUseCase
import com.spascoding.feature_exam.domain.use_case.database.GetSentencesUseCase
import com.spascoding.feature_exam.domain.use_case.database.UpsertSentencesToDatabaseUseCase
import javax.inject.Inject

data class ExamUseCases @Inject constructor(
    val getExamPatternsUseCase: GetExamPatternsUseCase,
    val getExamNamesUseCase: GetExamNamesUseCase,
    val getSentencesUseCase: GetSentencesUseCase,
    val getSentenceUseCase: GetSentenceUseCase,
    val upsertSentencesToDatabaseUseCase: UpsertSentencesToDatabaseUseCase,
)