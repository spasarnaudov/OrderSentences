package com.spascoding.feature_exam.presentation.tens_screen

import com.spascoding.feature_exam.domain.enums.Tens

sealed interface TensScreenEventEvent {
    data class SelectTens(val tens: Tens) : TensScreenEventEvent
}