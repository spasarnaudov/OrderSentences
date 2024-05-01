package com.spascoding.feature_exam.domain.use_case

import com.spascoding.feature_exam.domain.use_case.database.GetSentenceUseCase
import com.spascoding.feature_exam.domain.use_case.database.ImportNotExistedSentencesUseCase
import com.spascoding.feature_exam.domain.use_case.database.UpdateSentenceUseCase
import javax.inject.Inject

data class CommonUseCases @Inject constructor(
    val getExamPatternsUseCase: GetExamPatternsUseCase,
    val importNotExistedSentencesUseCase: ImportNotExistedSentencesUseCase,
    val updateSentenceUseCase: UpdateSentenceUseCase,
    val getSentenceUseCase: GetSentenceUseCase,
)