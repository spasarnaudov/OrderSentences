package com.example.ordersentences.domain.model

class FutureSimpleNegativeSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    override fun buildSentence(): String {
        return "$subject will not ${verb.baseForm} $objectVal."
    }
}