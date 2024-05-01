package com.spascoding.feature_exam.presentation.tens_screen

import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.TensAccuracyInfo

data class TensScreenViewModelState(
    val tens: Tens = Tens.PRESENT_SIMPLE,
    val tensesAccuracyInfo: List<TensAccuracyInfo> = listOf(),
)