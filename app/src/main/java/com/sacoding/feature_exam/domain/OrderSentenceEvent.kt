package com.sacoding.feature_exam.domain

import com.sacoding.feature_exam.domain.model.Lessen

sealed interface OrderSentenceEvent {
    data object StartGame : OrderSentenceEvent
    data class EndGame(val answerText: String) : OrderSentenceEvent
    data class EnterText(val answerText: String) : OrderSentenceEvent
    data class SelectLesson(val lessen: Lessen) : OrderSentenceEvent
}