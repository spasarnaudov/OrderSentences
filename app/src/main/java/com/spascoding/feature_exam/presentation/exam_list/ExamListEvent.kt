package com.spascoding.feature_exam.presentation.exam_list

import com.spascoding.feature_exam.domain.Tens
import com.spascoding.feature_exam.domain.model.Exam

sealed interface ExamListEvent {
    data class SelectExam(val exam: Exam) : ExamListEvent
    data class SelectExamInfo(val exam: Exam) : ExamListEvent
    data class SelectTens(val tens: Tens) : ExamListEvent
}