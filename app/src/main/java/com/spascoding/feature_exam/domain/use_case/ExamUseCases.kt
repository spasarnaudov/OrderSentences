package com.spascoding.feature_exam.domain.use_case

import com.spascoding.feature_exam.domain.use_case.database.GetExamNamesUseCase
import com.spascoding.feature_exam.domain.use_case.database.GetSentenceUseCase
import com.spascoding.feature_exam.domain.use_case.database.GetSentencesUseCase
import com.spascoding.feature_exam.domain.use_case.database.GetMistakesCountsUseCase
import com.spascoding.feature_exam.domain.use_case.database.GetSentencesCountUseCase
import com.spascoding.feature_exam.domain.use_case.database.ImportNotExistedSentencesUseCase
import com.spascoding.feature_exam.domain.use_case.database.UpdateSentenceUseCase
import com.spascoding.feature_exam.domain.use_case.database.GetUsedCountUseCase
import com.spascoding.feature_exam.domain.use_case.database.GetUserSentenceUseCase
import javax.inject.Inject

data class ExamUseCases @Inject constructor(
    val getExamPatternsUseCase: GetExamPatternsUseCase,
    val getExamNamesUseCase: GetExamNamesUseCase,
    val getSentencesUseCase: GetSentencesUseCase,
    val getSentencesCountsUseCase: GetSentencesCountUseCase,
    val getSentenceUseCase: GetSentenceUseCase,
    val getMistakesCountsUseCase: GetMistakesCountsUseCase,
    val getUsedCountUseCase: GetUsedCountUseCase,
    val updateSentenceUseCase: UpdateSentenceUseCase,
    val importNotExistedSentencesUseCase: ImportNotExistedSentencesUseCase,
    val getUserSentenceUseCase: GetUserSentenceUseCase,
)