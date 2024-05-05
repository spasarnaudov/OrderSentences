package com.spascoding.englishstructure.feature_exam.presentation.tens_screen

import com.spascoding.englishstructure.feature_exam.domain.model.TensAccuracyInfo

data class TensScreenViewModelState(
    val tensesAccuracyInfo: List<TensAccuracyInfo> = listOf(),
)