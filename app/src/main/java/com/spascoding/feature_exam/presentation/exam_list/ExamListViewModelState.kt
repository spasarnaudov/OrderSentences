package com.spascoding.feature_exam.presentation.exam_list

import com.spascoding.feature_exam.domain.enums.Tens

data class ExamListViewModelState(
    val exams: List<String> = listOf(),
    val tens: Tens = Tens.PRESENT_SIMPLE,
    val mistakesCounts: Map<Int, Int> = mutableMapOf(),
    val useCountUseCase: Map<Int, Int> = mutableMapOf(),
    val sentencesCounts: Map<Int, Int> = mutableMapOf(),
)