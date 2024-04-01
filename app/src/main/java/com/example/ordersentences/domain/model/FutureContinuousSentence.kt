package com.example.ordersentences.domain.model

class FutureContinuousSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    override fun positive(): String {
        return "$subject will be ${verb.toContinuous()} $objectVal."
    }

    override fun negative(): String {
        return "$subject will not be ${verb.toContinuous()} $objectVal."
    }

    override fun question(): String {
        return "will $subject be ${verb.toContinuous()} $objectVal?"
    }
}