package com.example.ordersentences.domain.model

import com.example.ordersentences.domain.SentenceType
import com.example.ordersentences.domain.Tens

data class Lessen(
    val sentenceType: SentenceType,
    val tens: Tens,
    val subjects: List<String>,
    val verbs: List<Verb>,
    val objectVals: List<String>
)