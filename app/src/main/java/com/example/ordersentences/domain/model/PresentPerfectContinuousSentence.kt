package com.example.ordersentences.domain.model

class PresentPerfectContinuousSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    override fun positive(): String {
        return "$subject ${toBePast(subject)} been ${verb.pastParticiple} $objectVal."
    }

    override fun negative(): String {
        return "$subject ${toBePast(subject)} not been ${verb.baseForm} $objectVal."
    }

    override fun question(): String {
        return "${toBePast(subject)} $subject been ${verb.baseForm} $objectVal?"
    }
}