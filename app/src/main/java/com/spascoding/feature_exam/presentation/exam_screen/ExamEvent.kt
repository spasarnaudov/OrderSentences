package com.spascoding.feature_exam.presentation.exam_screen

sealed interface ExamEvent {
    data class CheckExam(val answerText: String) : ExamEvent
    data class EnterText(val answerText: String) : ExamEvent
}