package com.sacoding.feature_exam.domain.model

import com.sacoding.feature_exam.data.data_source.Verbs

/**
 * The simple past tense, sometimes called the preterite, is used to talk about a completed action in a time before now.
 * The simple past is the basic form of past tense in English.
 * The time of the action can be in the recent past or the distant past and action duration is not important.
 */
class PastSimpleSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {

    /**
     * Positive: Subject + past form of the verb + object.
     * "She walked around."
     */
    override fun positive(): String {
        if (verb == Verbs.toBe) {
            return "$subject ${toBePast(subject)} $objectVal."
        }
        return "$subject ${verb.pastTense} $objectVal."
    }

    /**
     * Negative: Subject + did not + base verb + object.
     * "She did not walk around."
     */
    override fun negative(): String {
        if (verb == Verbs.toBe) {
            return "$subject ${toBePast(subject)} not $objectVal."
        }
        return "$subject did not ${verb.baseForm} $objectVal."
    }

    /**
     * Question: Did + subject + base verb + object?
     * "Did she walk around?"
     */
    override fun question(): String {
        if (verb == Verbs.toBe) {
            return "${toBePast(subject)} $subject $objectVal?"
        }
        return "did $subject ${verb.baseForm} $objectVal?"
    }
}