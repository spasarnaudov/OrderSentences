package com.example.ordersentences.domain.model

class FutureSimpleSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    override fun positive(): String {
        return "$subject will ${verb.baseForm} $objectVal."
    }

    override fun negative(): String {
        return "$subject will not ${verb.baseForm} $objectVal."
    }

    override fun question(): String {
        return "will $subject ${verb.baseForm} $objectVal?"
    }
}