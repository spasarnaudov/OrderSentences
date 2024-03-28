package com.example.ordersentences.domain.model

class PresentSimpleNegativeSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    override fun buildSentence(): String {
        return "$subject ${Verbs.verbDo.getInfinitiveForSubject(subject)} not ${verb.baseForm} $objectVal."
    }
}