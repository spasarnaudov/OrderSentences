package com.spascoding.englishstructure.feature_exam.presentation.exam_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import com.spascoding.englishstructure.feature_exam.domain.enums.Tense
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.entity.Sentence

data class ExamViewModelState(
    val tense: Tense = Tense.PRESENT_SIMPLE,
    val topic: String = "",
    val sentence: String = "",
    val shuffledSentence: String = "",
    val enteredSentence: String = "",
    var answerText: String = "",
    val sentences: List<Sentence> = listOf(),
)