package com.sacoding.feature_order_sentence.presentation

import com.sacoding.feature_order_sentence.domain.GameState
import com.sacoding.feature_order_sentence.domain.model.Verb

data class SentenceGenerationState(
    val sentence: String = "",
    val shuffledSentence: String = "",
    val enteredSentence: String = "",
    val verb: Verb? = null,
    val gameState: GameState = GameState.FINISHED,
)
