package com.sacoding.feature_order_sentence.domain

sealed interface OrderSentenceEvent {
    data object StartGame : OrderSentenceEvent
    data class EndGame(val answerText: String) : OrderSentenceEvent
    data class EnterText(val answerText: String) : OrderSentenceEvent
}