package com.spascoding.feature_exam.presentation.tens_screen

import com.spascoding.feature_exam.domain.model.TensAccuracyInfo

data class TensScreenViewModelState(
    val tensesAccuracyInfo: List<TensAccuracyInfo> = listOf(),
)