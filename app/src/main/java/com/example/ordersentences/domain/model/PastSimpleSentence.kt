package com.example.ordersentences.domain.model

class PastSimpleSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    override fun positive(): String {
        return "$subject ${verb.pastTense} $objectVal."
    }

    override fun negative(): String {
        return "$subject did not ${verb.baseForm} $objectVal."
    }

    override fun question(): String {
        return "did $subject ${verb.baseForm} $objectVal?"
    }
}