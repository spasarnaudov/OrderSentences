package com.example.ordersentences.presentation

import com.example.ordersentences.domain.model.GameState
import com.example.ordersentences.domain.model.Sentence
import com.example.ordersentences.domain.model.Verb

data class SentenceGenerationState(
    val sentence: Sentence? = null,
    val shuffledSentence: String = "",
    val enteredSentence: String = "",
    val verb: Verb? = null,
    val gameState: GameState = GameState.FINISHED,
)
