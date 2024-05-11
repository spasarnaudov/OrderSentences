package com.spascoding.englishstructure.feature_exam.presentation.topics_screen

import com.spascoding.englishstructure.feature_exam.domain.enums.Tense

data class TopicsViewModelState(
    val tense: Tense = Tense.PRESENT_SIMPLE,
)