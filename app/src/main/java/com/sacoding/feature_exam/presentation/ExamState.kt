package com.sacoding.feature_exam.presentation

import com.sacoding.feature_exam.data.data_source.StudentBook
import com.sacoding.feature_exam.domain.GameState
import com.sacoding.feature_exam.domain.model.Lessen
import com.sacoding.feature_exam.domain.model.Verb

data class ExamState(
    val sentence: String = "",
    val shuffledSentence: String = "",
    val enteredSentence: String = "",
    val verb: Verb? = null,
    val gameState: GameState = GameState.FINISHED,
    val lessen: Lessen = StudentBook.presentSimpleLessens[0]
)
