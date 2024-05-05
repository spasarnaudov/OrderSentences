package com.spascoding.englishstructure.feature_exam.domain.model

import com.spascoding.englishstructure.feature_exam.domain.enums.Tens
import com.spascoding.englishstructure.feature_exam.domain.model.noun.Noun
import com.spascoding.englishstructure.feature_exam.domain.model.verb.Verb

data class ExamPattern(
    val name: String,
    val tenses: List<Tens> = Tens.entries,
    val subjects: List<Noun>,
    val verbs: List<Verb>,
    val objects: List<String>
)