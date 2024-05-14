package com.spascoding.englishstructure.feature_exam.domain.use_case

import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetSentenceUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.ImportNotExistedSentencesUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.RemoveExistedSentencesUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.UpdateSentenceUseCase
import javax.inject.Inject

data class CommonUseCases @Inject constructor(
    val getExamPatternsUseCase: GetExamPatternsUseCase,
    val removeExistedSentencesUseCase: RemoveExistedSentencesUseCase,
    val importNotExistedSentencesUseCase: ImportNotExistedSentencesUseCase,
    val updateSentenceUseCase: UpdateSentenceUseCase,
    val getSentenceUseCase: GetSentenceUseCase,
)