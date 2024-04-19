package com.spascoding.feature_exam.presentation.exam_screen

import com.spascoding.feature_exam.domain.model.Exam

sealed interface ExamEvent {
    data class EndExam(val answerText: String) : ExamEvent
    data class EnterText(val answerText: String) : ExamEvent
    data class NewExam(val exam: Exam) : ExamEvent
}