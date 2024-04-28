package com.spascoding.feature_exam.domain.model

import com.spascoding.feature_exam.domain.model.noun.Noun
import com.spascoding.feature_exam.domain.model.verb.Verb

data class ExamPattern(
    val name: String,
    val subjects: List<Noun>,
    val verbs: List<Verb>,
    val objects: List<String>
)