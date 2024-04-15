package com.sacoding.feature_exam.domain.model.sentence.future

import com.sacoding.feature_exam.domain.model.noun.Noun
import com.sacoding.feature_exam.domain.model.sentence.Sentence
import com.sacoding.feature_exam.domain.model.verb.Verb
import com.sacoding.feature_exam.domain.model.verb.toContinuous

/**
 * The future continuous is made up of two elements:
 * the simple future of the verb "to be" + the present participle (base+ing)
 */
class FutureContinuousSentence(
    private val subject: Noun,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
) : Sentence {

    /**
     * Positive: Subject + will be + verb-ing object.
     * "She will be walking around."
     */
    override fun positive(): String {
        return "${subject.build()} will be ${verb.toContinuous()} $objectVal."
    }

    /**
     * Negative: Subject + will not be + verb-ing + object.
     * "She will not be walking around."
     */
    override fun negative(): String {
        return "${subject.build()} will not be ${verb.toContinuous()} $objectVal."
    }

    /**
     * Question: Will + subject + be + verb-ing + object?
     * "Will she be walking around?"
     */
    override fun question(): String {
        return "will ${subject.build()} be ${verb.toContinuous()} $objectVal?"
    }
}