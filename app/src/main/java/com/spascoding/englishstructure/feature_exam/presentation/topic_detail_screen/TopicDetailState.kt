package com.spascoding.englishstructure.feature_exam.presentation.topic_detail_screen

import com.spascoding.englishstructure.feature_exam.domain.enums.Tense

data class TopicDetailState(
    val tense: Tense = Tense.PRESENT_SIMPLE,
    val topic: String = "",
)
