package com.example.ordersentences.domain.model

import com.example.ordersentences.domain.use_case.GetInfinitiveVerb

class PresentSimplePositiveSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    override fun buildSentence(): String {
        return "$subject ${GetInfinitiveVerb(subject, verb.baseForm)} $objectVal."
    }
}