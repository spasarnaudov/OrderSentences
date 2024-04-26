package com.spascoding.feature_exam.domain.use_case

import com.spascoding.feature_exam.domain.use_case.database.GetExamNamesUseCase
import com.spascoding.feature_exam.domain.use_case.database.GetSentenceUseCase
import com.spascoding.feature_exam.domain.use_case.database.GetSentencesUseCase
import com.spascoding.feature_exam.domain.use_case.database.ImportNotExistedSentencesUseCase
import com.spascoding.feature_exam.domain.use_case.database.UpdateSentenceUseCase
import javax.inject.Inject

data class ExamUseCases @Inject constructor(
    val getExamPatternsUseCase: GetExamPatternsUseCase,
    val getExamNamesUseCase: GetExamNamesUseCase,
    val getSentencesUseCase: GetSentencesUseCase,
    val getSentenceUseCase: GetSentenceUseCase,
    val updateSentenceUseCase: UpdateSentenceUseCase,
    val importNotExistedSentencesUseCase: ImportNotExistedSentencesUseCase,
)