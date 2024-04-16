package com.spascoding.feature_exam.presentation

import com.spascoding.feature_exam.data.data_source.StudentBook
import com.spascoding.feature_exam.domain.GameState
import com.spascoding.feature_exam.domain.model.Exam
import com.spascoding.feature_exam.domain.model.verb.Verb

data class ExamState(
    val sentence: String = "",
    val shuffledSentence: String = "",
    val enteredSentence: String = "",
    val verb: Verb? = null,
    val gameState: GameState = GameState.FINISHED,
    val exam: Exam = StudentBook.Beginner.exams[0],
)
