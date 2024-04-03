package com.example.ordersentences.domain.model

import com.example.ordersentences.domain.Level
import com.example.ordersentences.domain.SentenceType
import com.example.ordersentences.domain.Tens

data class Lessen(
    val name: String,
    val level: Level,
    val sentenceTypes: List<SentenceType>,
    val tenses: List<Tens>,
    val subjects: List<String>,
    val verbs: List<Verb>,
    val prepositions: List<String>,
    val objectVals: List<String>
)