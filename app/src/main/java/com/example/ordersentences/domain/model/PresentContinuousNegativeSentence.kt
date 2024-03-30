package com.example.ordersentences.domain.model

import com.example.ordersentences.data.data_source.Dictionary

class PresentContinuousNegativeSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    override fun buildSentence(): String {
        return "$subject ${Dictionary.doVerb.toInfinitive(subject)} not ${verb.toPresentContinuous()} $objectVal."
    }
}