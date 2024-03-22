package com.example.ordersentences.domain

sealed interface OrderSentenceEvent {
    data object StartGame : OrderSentenceEvent
    data class EndGame(val answerText: String) : OrderSentenceEvent
}