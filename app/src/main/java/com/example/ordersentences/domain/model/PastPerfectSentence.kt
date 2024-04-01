package com.example.ordersentences.domain.model

class PastPerfectSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    override fun positive(): String {
        return "$subject had ${verb.pastParticiple} $objectVal."
    }

    override fun negative(): String {
        return "$subject had not ${verb.pastParticiple} $objectVal."
    }

    override fun question(): String {
        return "had $subject ${verb.pastParticiple} $objectVal?"
    }
}