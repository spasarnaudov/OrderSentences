package com.sacoding.feature_order_sentence.domain.model

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
        return "$subject ${verb.pastTense} $objectVal."
    }

    /**
     * Negative: Subject + did not + base verb + object.
     * "She did not walk around."
     */
    override fun negative(): String {
        return "$subject did not ${verb.baseForm} $objectVal."
    }

    /**
     * Question: Did + subject + base verb + object?
     * "Did she walk around?"
     */
    override fun question(): String {
        return "did $subject ${verb.baseForm} $objectVal?"
    }
}