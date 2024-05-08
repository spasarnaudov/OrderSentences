package com.spascoding.englishstructure.feature_exam.presentation.topics_screen

import com.spascoding.englishstructure.feature_exam.domain.enums.Tense
import com.spascoding.englishstructure.feature_exam.domain.model.TopicAccuracyInfo

data class TopicsViewModelState(
    val topics: List<String> = listOf(),
    val tense: Tense = Tense.PRESENT_SIMPLE,
    val topicsAccuracyInfo: List<TopicAccuracyInfo> = listOf(),
)