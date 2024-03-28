package com.example.ordersentences.domain.model

class PresentSimpleQuestionSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    override fun buildSentence(): String {
        return "${Verbs.verbDo.getInfinitiveForSubject(subject)} $subject ${verb.baseForm} $objectVal?"
    }
}