package com.spascoding.feature_exam.presentation.exam_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.sentence.entity.Sentence

data class ExamViewModelState(
    val tens: Tens = Tens.PRESENT_SIMPLE,
    val examName: String = "",
    val sentence: String = "",
    val shuffledSentence: String = "",
    val enteredSentence: String = "",
    var answerText: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue(text = "", selection = TextRange(0))),
    val sentences: List<Sentence> = listOf(),
    val history: List<Sentence> = listOf(),
)