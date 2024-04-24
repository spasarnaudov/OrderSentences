package com.spascoding.feature_exam.presentation.exam_list

import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.ExamPattern

sealed interface ExamListEvent {
    data class SelectExam(val exam: ExamPattern) : ExamListEvent
    data class SelectExamInfo(val exam: ExamPattern) : ExamListEvent
    data class SelectTens(val tens: Tens) : ExamListEvent
}