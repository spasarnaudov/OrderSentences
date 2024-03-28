package com.example.ordersentences.domain.model

import com.example.ordersentences.domain.Verbs

class PresentSimpleQuestionSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    override fun buildSentence(): String {
        return "${Verbs.doVerb.getInfinitiveForSubject(subject)} $subject ${verb.baseForm} $objectVal?"
    }
}