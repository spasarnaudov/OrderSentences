package com.example.ordersentences.domain.model

import com.example.ordersentences.domain.use_case.GetInfinitiveVerb

class PresentContinuousNegativeSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    private val verbDo = Verb("do", "did", "done")

    override fun buildSentence(): String {
        return "$subject ${GetInfinitiveVerb(subject, verbDo.baseForm)} not ${verb.baseForm}ing $objectVal."
    }
}