package com.spascoding.englishstructure.feature_exam.presentation.topic_detail_screen

import com.spascoding.englishstructure.feature_exam.domain.enums.Tens
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.entity.Sentence

data class TopicDetailState(
    val tens: Tens = Tens.PRESENT_SIMPLE,
    val examName: String = "",
    val sentences: List<Sentence> = listOf(),
)
