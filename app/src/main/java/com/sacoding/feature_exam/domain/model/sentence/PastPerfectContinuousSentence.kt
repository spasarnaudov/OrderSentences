package com.sacoding.feature_exam.domain.model.sentence

import com.sacoding.feature_exam.domain.model.noun.Noun
import com.sacoding.feature_exam.domain.model.verb.Verb
import com.sacoding.feature_exam.domain.model.verb.toContinuous

/**
 *The past perfect continuous corresponds to the present perfect continuous, but with reference to a time earlier than 'before now'.
 * As with the present perfect continuous, we are more interested in the process.
 */
class PastPerfectContinuousSentence(
    private val subject: Noun,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {

    /**
     * Positive: Subject + had been + verb-ing + object.
     * "She had been walking around."
     */
    override fun positive(): String {
        return "${subject.build()} had been ${verb.toContinuous()} $objectVal."
    }

    /**
     * Negative: Subject + had not been + verb-ing + object.
     * "She had not been walking around."
     */
    override fun negative(): String {
        return "${subject.build()} had not been ${verb.toContinuous()} $objectVal."
    }

    /**
     * Question: Had + subject + been + verb-ing + object?
     * "Had she been walking around?"
     */
    override fun question(): String {
        return "had ${subject.build()} been ${verb.toContinuous()} $objectVal?"
    }
}