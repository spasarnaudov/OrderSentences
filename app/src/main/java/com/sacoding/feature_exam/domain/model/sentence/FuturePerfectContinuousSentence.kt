package com.sacoding.feature_exam.domain.model.sentence

import com.sacoding.feature_exam.domain.model.verb.Verb
import com.sacoding.feature_exam.domain.model.verb.toContinuous

/**
 * The future perfect continuous is composed of two elements
 * the future perfect of the verb "to be" (will have been) + the present participle of the main verb (base + ing)
 */
class FuturePerfectContinuousSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {

    /**
     * Positive: Subject + will have been + verb-ing + object.
     * "She will have been walking around."
     */
    override fun positive(): String {
        return "$subject will have been ${verb.toContinuous()} $objectVal."
    }

    /**
     * Negative: Subject + will not have been + verb-ing + object.
     * "She will not have been walking around."
     */
    override fun negative(): String {
        return "$subject will not have been ${verb.toContinuous()} $objectVal."
    }

    /**
     * Question: Will + subject + have been + verb-ing + object?
     * "Will she have been walking around?"
     */
    override fun question(): String {
        return "will $subject have been ${verb.toContinuous()} $objectVal?"
    }
}