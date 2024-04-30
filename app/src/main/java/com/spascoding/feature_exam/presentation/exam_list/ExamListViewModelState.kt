package com.spascoding.feature_exam.presentation.exam_list

import com.spascoding.feature_exam.domain.enums.Tens

data class ExamListViewModelState(
    val exams: List<String> = listOf(),
    val tens: Tens = Tens.PRESENT_SIMPLE,
    val mistakesCounts: Map<String, Int> = mutableMapOf(),
    val usedCounts: Map<String, Int> = mutableMapOf(),
    val sentencesCounts: Map<String, Int> = mutableMapOf(),
)