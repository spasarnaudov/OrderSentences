package com.example.ordersentences.domain.model

import com.example.ordersentences.data.data_source.Dictionary

class PresentContinuousSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    override fun positive(): String {
        return "$subject ${toBe(subject)} ${verb.toContinuous()} $objectVal."
    }

    override fun negative(): String {
        return "$subject ${toBe(subject)} not ${verb.toContinuous()} $objectVal."
    }

    override fun question(): String {
        return "${toBe(subject)} $subject ${verb.toContinuous()} $objectVal?"
    }
}