package com.sacoding.feature_order_sentence.domain.model

import com.sacoding.feature_order_sentence.domain.Level
import com.sacoding.feature_order_sentence.domain.SentenceType
import com.sacoding.feature_order_sentence.domain.Tens

data class Lessen(
    val name: String,
    val level: Level,
    val sentenceTypes: List<SentenceType>,
    val tenses: List<Tens>,
    val subjects: List<String>,
    val verbs: List<Verb>,
    val prepositions: List<String> = listOf(),
    val objectVals: List<String>
)