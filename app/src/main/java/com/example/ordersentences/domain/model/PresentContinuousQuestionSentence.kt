package com.example.ordersentences.domain.model

import com.example.ordersentences.data.data_source.Dictionary

class PresentContinuousQuestionSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    override fun buildSentence(): String {
        return "${Dictionary.doVerb.getInfinitiveForSubject(subject)} $subject ${verb.baseForm}ing $objectVal?"
    }
}