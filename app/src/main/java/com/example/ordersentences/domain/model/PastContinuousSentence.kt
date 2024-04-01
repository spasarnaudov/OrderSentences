package com.example.ordersentences.domain.model

class PastContinuousSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    override fun positive(): String {
        return "$subject ${toBePast(subject)} ${verb.toContinuous()} $objectVal."
    }

    override fun negative(): String {
        return "$subject ${toBePast(subject)} not ${verb.toContinuous()} $objectVal."
    }

    override fun question(): String {
        return "${toBePast(subject)} $subject ${verb.toContinuous()} $objectVal?"
    }
}