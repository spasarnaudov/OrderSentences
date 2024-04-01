package com.example.ordersentences.domain.model

import com.example.ordersentences.data.data_source.Dictionary

class PresentSimpleSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {
    override fun positive(): String {
        return "$subject ${verb.getSingularPresentTenseForm(subject)} $objectVal."
    }

    override fun negative(): String {
        return "$subject ${Dictionary.doVerb.getSingularPresentTenseForm(subject)} not ${verb.baseForm} $objectVal."
    }

    override fun question(): String {
        return "${Dictionary.doVerb.getSingularPresentTenseForm(subject)} $subject ${verb.baseForm} $objectVal?"
    }
}