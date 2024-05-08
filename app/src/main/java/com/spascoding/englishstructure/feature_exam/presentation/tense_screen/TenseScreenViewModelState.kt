package com.spascoding.englishstructure.feature_exam.presentation.tense_screen

import com.spascoding.englishstructure.feature_exam.domain.model.TenseAccuracyInfo

data class TenseScreenViewModelState(
    val tensesAccuracyInfo: List<TenseAccuracyInfo> = listOf(),
)