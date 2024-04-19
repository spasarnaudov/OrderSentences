package com.spascoding.feature_exam.presentation.exam_list

import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.Exam

data class ExamListViewModelState(
    val exams: List<Exam> = listOf(),
    val tens: Tens = Tens.PRESENT_SIMPLE,
)