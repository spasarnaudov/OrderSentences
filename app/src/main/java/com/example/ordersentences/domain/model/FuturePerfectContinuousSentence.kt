package com.example.ordersentences.domain.model

class FuturePerfectContinuousSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    override fun positive(): String {
        return "$subject will have been ${verb.toContinuous()} $objectVal."
    }

    override fun negative(): String {
        return "$subject will not have been ${verb.toContinuous()} $objectVal."
    }

    override fun question(): String {
        return "will $subject have been ${verb.toContinuous()} $objectVal?"
    }
}