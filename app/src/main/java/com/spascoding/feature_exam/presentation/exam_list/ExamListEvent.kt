package com.spascoding.feature_exam.presentation.exam_list

import com.spascoding.feature_exam.domain.enums.Tens

sealed interface ExamListEvent {
    data class SelectExam(val examName: String) : ExamListEvent
    data class SelectExamInfo(val examName: String) : ExamListEvent
    data class SelectTens(val tens: Tens) : ExamListEvent
}