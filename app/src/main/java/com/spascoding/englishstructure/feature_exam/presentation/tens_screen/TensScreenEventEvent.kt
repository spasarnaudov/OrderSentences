package com.spascoding.englishstructure.feature_exam.presentation.tens_screen

import com.spascoding.englishstructure.feature_exam.domain.enums.Tens

sealed interface TensScreenEventEvent {
    data class SelectTens(val tens: Tens) : TensScreenEventEvent
}