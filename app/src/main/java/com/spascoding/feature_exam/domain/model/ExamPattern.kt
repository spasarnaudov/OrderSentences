package com.spascoding.feature_exam.domain.model

import com.spascoding.feature_exam.domain.enums.SentenceType
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.noun.Noun
import com.spascoding.feature_exam.domain.model.verb.Verb
import com.spascoding.feature_exam.domain.utils.GenerateSentence

data class ExamPattern(
    val subjects: List<Noun>,
    val verbs: List<Verb>,
    val objects: List<String>
)