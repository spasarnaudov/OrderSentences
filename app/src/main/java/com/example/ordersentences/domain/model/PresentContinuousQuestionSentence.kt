package com.example.ordersentences.domain.model

class PresentContinuousQuestionSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    override fun buildSentence(): String {
        return "${Verbs.verbDo.getInfinitiveForSubject(subject)} $subject ${verb.baseForm}ing $objectVal?"
    }
}