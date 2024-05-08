package com.spascoding.englishstructure.feature_exam.presentation.tense_screen

import com.spascoding.englishstructure.feature_exam.domain.enums.Tense

sealed interface TenseScreenEventEvent {
    data class SelectTense(val tense: Tense) : TenseScreenEventEvent
}