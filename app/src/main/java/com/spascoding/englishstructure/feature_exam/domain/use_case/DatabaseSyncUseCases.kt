package com.spascoding.englishstructure.feature_exam.domain.use_case

import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetAllSentencesUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.ImportNotExistedSentencesUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.RemoveExistedSentencesUseCase
import javax.inject.Inject

data class DatabaseSyncUseCases
@Inject
constructor(
    val getExamPatternsUseCase: GetExamPatternsUseCase,
    val removeExistedSentencesUseCase: RemoveExistedSentencesUseCase,
    val importNotExistedSentencesUseCase: ImportNotExistedSentencesUseCase,
    val getAllSentencesUseCase: GetAllSentencesUseCase,
)