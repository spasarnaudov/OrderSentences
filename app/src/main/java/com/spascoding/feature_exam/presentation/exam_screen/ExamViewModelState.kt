package com.spascoding.feature_exam.presentation.exam_screen

import com.spascoding.feature_exam.data.data_source.StudentBook
import com.spascoding.feature_exam.domain.enums.ExamState
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.ExamPattern
import com.spascoding.feature_exam.domain.model.sentence.entity.Sentence

data class ExamViewModelState(
    val tens: Tens = Tens.PRESENT_SIMPLE,
    val examName: String = "",
    val sentence: String = "",
    val shuffledSentence: String = "",
    val enteredSentence: String = "",
    val gameState: ExamState = ExamState.FINISHED,
    val exam: ExamPattern = StudentBook.examPatterns()[0],
    val sentences: List<Sentence> = listOf(),
)