package com.spascoding.feature_exam.domain.model.sentence.past

import com.spascoding.feature_exam.data.data_source.Verbs
import com.spascoding.feature_exam.domain.model.noun.Noun
import com.spascoding.feature_exam.domain.model.sentence.Sentence
import com.spascoding.feature_exam.domain.model.verb.Verb
import com.spascoding.feature_exam.domain.model.verb.toBePast

/**
 * The simple past tense, sometimes called the preterite, is used to talk about a completed action in a time before now.
 * The simple past is the basic form of past tense in English.
 * The time of the action can be in the recent past or the distant past and action duration is not important.
 */
class PastSimpleSentence(
    private val subject: Noun,
    private val verb: Verb,
    private val objectVal: String,
): Sentence {

    /**
     * Positive: Subject + past form of the verb + object.
     * "She walked around."
     */
    override fun positive(): String {
        if (verb == Verbs.toBe) {
            return "${subject.build()} ${toBePast(subject.build())} $objectVal."
        }
        return "$subject ${verb.pastTense} $objectVal."
    }

    /**
     * Negative: Subject + did not + base verb + object.
     * "She did not walk around."
     */
    override fun negative(): String {
        if (verb == Verbs.toBe) {
            return "${subject.build()} ${toBePast(subject.build())} not $objectVal."
        }
        return "${subject.build()} did not ${verb.baseForm} $objectVal."
    }

    /**
     * Question: Did + subject + base verb + object?
     * "Did she walk around?"
     */
    override fun question(): String {
        if (verb == Verbs.toBe) {
            return "${toBePast(subject.build())} $subject $objectVal?"
        }
        return "did ${subject.build()} ${verb.baseForm} $objectVal?"
    }
}