package com.example.ordersentences.domain.model

import com.example.ordersentences.data.data_source.Dictionary

class PresentSimpleQuestionSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    override fun buildSentence(): String {
        return "${Dictionary.doVerb.toInfinitive(subject)} $subject ${verb.baseForm} $objectVal?"
    }
}