package com.spascoding.englishstructure.feature_exam.presentation.topics_screen

import com.spascoding.englishstructure.feature_exam.domain.enums.Tens

data class TopicsViewModelState(
    val topics: List<String> = listOf(),
    val tens: Tens = Tens.PRESENT_SIMPLE,
    val mistakesCounts: Map<String, Int> = mutableMapOf(),
    val usedCounts: Map<String, Int> = mutableMapOf(),
    val sentencesCounts: Map<String, Int> = mutableMapOf(),
)