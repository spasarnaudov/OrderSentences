package com.spascoding.feature_exam.presentation.exam_detail

import com.spascoding.feature_exam.domain.model.sentence.entity.Sentence

data class ExamDetailState(
    val examName: String = "",
    val sentences: List<Sentence> = listOf(),
)
