package com.spascoding.feature_exam.presentation.exam_screen

import com.spascoding.feature_exam.data.data_source.StudentBook
import com.spascoding.feature_exam.domain.enums.ExamState
import com.spascoding.feature_exam.domain.model.Exam

data class ExamViewModelState(
    val sentence: String = "",
    val shuffledSentence: String = "",
    val enteredSentence: String = "",
    val gameState: ExamState = ExamState.FINISHED,
    val exam: Exam = StudentBook.Beginner.exams[0],
)