package com.spascoding.englishstructure.feature_exam.presentation.exam_screen

import com.spascoding.englishstructure.feature_exam.domain.enums.Tense
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.entity.Sentence

data class ExamViewModelState(
    val tense: Tense = Tense.PRESENT_SIMPLE,
    val topic: String = "",
    val originalSentence: String = "",
    val shuffledSentence: String = "",
    val userSentence: String = "",
    val sentence: Sentence? = null,
)