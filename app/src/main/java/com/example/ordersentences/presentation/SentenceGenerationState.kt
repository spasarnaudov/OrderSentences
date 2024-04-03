package com.example.ordersentences.presentation

import com.example.ordersentences.domain.GameState
import com.example.ordersentences.domain.model.Verb

data class SentenceGenerationState(
    val sentence: String = "",
    val shuffledSentence: String = "",
    val enteredSentence: String = "",
    val verb: Verb? = null,
    val gameState: GameState = GameState.FINISHED,
)
