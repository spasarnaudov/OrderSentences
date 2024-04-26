package com.spascoding.feature_exam.presentation.tens_screen

import com.spascoding.feature_exam.domain.enums.Tens

data class TensScreenViewModelState(
    val tens: Tens = Tens.PRESENT_SIMPLE,
)