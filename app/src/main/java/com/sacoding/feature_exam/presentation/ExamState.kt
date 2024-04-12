package com.sacoding.feature_exam.presentation

import com.sacoding.feature_exam.data.data_source.StudentBook
import com.sacoding.feature_exam.domain.GameState
import com.sacoding.feature_exam.domain.Level
import com.sacoding.feature_exam.domain.model.Exam
import com.sacoding.feature_exam.domain.model.verb.Verb

data class ExamState(
    val sentence: String = "",
    val shuffledSentence: String = "",
    val enteredSentence: String = "",
    val verb: Verb? = null,
    val gameState: GameState = GameState.FINISHED,
    val exam: Exam = StudentBook.Beginner.exams[0],
    val level: Level = Level.BEGINNER
)
