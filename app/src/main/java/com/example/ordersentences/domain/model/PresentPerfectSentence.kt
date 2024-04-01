package com.example.ordersentences.domain.model

class PresentPerfectSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    override fun positive(): String {
        return "$subject ${toBePast(subject)} ${verb.pastParticiple} $objectVal."
    }

    override fun negative(): String {
        return "$subject ${toBePast(subject)} not ${verb.baseForm} $objectVal."
    }

    override fun question(): String {
        return "${toBePast(subject)} $subject ${verb.baseForm} $objectVal?"
    }
}