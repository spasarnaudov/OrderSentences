package com.example.ordersentences.domain.model

import com.example.ordersentences.domain.Verbs

class PresentContinuousNegativeSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    override fun buildSentence(): String {
        return "$subject ${Verbs.doVerb.getInfinitiveForSubject(subject)} not ${verb.baseForm}ing $objectVal."
    }
}