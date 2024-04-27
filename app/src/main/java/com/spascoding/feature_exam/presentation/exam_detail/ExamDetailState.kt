package com.spascoding.feature_exam.presentation.exam_detail

import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.sentence.entity.Sentence

data class ExamDetailState(
    val tens: Tens = Tens.PRESENT_SIMPLE,
    val examName: String = "",
    val sentences: List<Sentence> = listOf(),
)
