package com.example.ordersentences.domain.model

class FuturePerfectSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    override fun positive(): String {
        return "$subject will have ${verb.pastParticiple} $objectVal."
    }

    override fun negative(): String {
        return "$subject will not have ${verb.pastParticiple} $objectVal."
    }

    override fun question(): String {
        return "will $subject have ${verb.pastParticiple} $objectVal?"
    }
}