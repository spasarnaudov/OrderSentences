package com.sacoding.feature_exam.domain

import com.sacoding.feature_exam.domain.model.Lessen

sealed interface ExamEvent {
    data object StartGame : ExamEvent
    data class EndGame(val answerText: String) : ExamEvent
    data class EnterText(val answerText: String) : ExamEvent
    data class SelectLesson(val lessen: Lessen) : ExamEvent
}