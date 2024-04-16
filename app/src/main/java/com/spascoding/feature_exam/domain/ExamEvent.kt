package com.spascoding.feature_exam.domain

import com.spascoding.feature_exam.domain.model.Exam

sealed interface ExamEvent {
    data class EndGame(val answerText: String) : ExamEvent
    data class EnterText(val answerText: String) : ExamEvent
    data class SelectExam(val exam: Exam) : ExamEvent
    data class SelectExamInfo(val exam: Exam) : ExamEvent
    data class SelectLevel(val level: Level) : ExamEvent
}