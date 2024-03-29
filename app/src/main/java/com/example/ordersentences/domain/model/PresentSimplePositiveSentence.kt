package com.example.ordersentences.domain.model

import com.example.ordersentences.data.data_source.Dictionary

class PresentSimplePositiveSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    override fun buildSentence(): String {
        return "$subject ${Dictionary.doVerb.getInfinitiveForSubject(subject)} $objectVal."
    }
}