package com.example.ordersentences.domain.model

class PastPerfectContinuousSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    override fun positive(): String {
        return "$subject had been ${verb.toContinuous()} $objectVal."
    }

    override fun negative(): String {
        return "$subject had not been ${verb.toContinuous()} $objectVal."
    }

    override fun question(): String {
        return "had $subject been ${verb.toContinuous()} $objectVal?"
    }
}