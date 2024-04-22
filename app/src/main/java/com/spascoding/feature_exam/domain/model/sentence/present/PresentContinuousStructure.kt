package com.spascoding.feature_exam.domain.model.sentence.present

import com.spascoding.feature_exam.data.data_source.Verbs
import com.spascoding.feature_exam.domain.model.noun.Noun
import com.spascoding.feature_exam.domain.model.sentence.Structure
import com.spascoding.feature_exam.domain.model.verb.Verb
import com.spascoding.feature_exam.domain.model.verb.toBe

/**
 * Used:
 * - to describe an action that is going on at this moment: "You are using the Internet.", "You are studying English grammar."
 * - to describe an action that is going on during this period of time or a trend: "Are you still working for the same company?", "More and more people are becoming vegetarian."
 * - to describe an action or event in the future, which has already been planned or prepared: "We're going on holiday tomorrow.", "I'm meeting my boyfriend tonight. Are they visiting you next winter?"
 * - to describe a temporary event or situation: "He usually plays the drums, but he's playing bass guitar tonight.", "The weather forecast was good, but it's raining at the moment."
 * - with "always, forever, constantly", to describe and emphasise a continuing series of repeated actions: "Harry and Sally are always arguing!", "You're constantly complaining about your mother-in-law!"
 */

class PresentContinuousStructure(
    private val subject: Noun,
    private val verb: Verb,
    private val objectVal: String,
): Structure {

    /**
     * Positive: Subject + am/is/are + verb-ing + object.
     * "She is walking around."
     */
    override fun positive(): String {
        if (verb == Verbs.toBe) {
            return "${subject.build()} ${toBe(subject.build())} being $objectVal."
        }
        return "${subject.build()} ${toBe(subject.build())} ${verb.continuous()} $objectVal."
    }

    /**
     * Negative: Subject + am/is/are not + verb-ing + subject.
     * "She is not walking around."
     */
    override fun negative(): String {
        if (verb == Verbs.toBe) {
            return "${subject.build()} ${toBe(subject.build())} not being $objectVal."
        }
        return "${subject.build()} ${toBe(subject.build())} not ${verb.continuous()} $objectVal."
    }

    /**
     * Question: Am/Is/Are + subject + verb-ing + object?
     * "Is she walking around?"
     */
    override fun question(): String {
        if (verb == Verbs.toBe) {
            return "${toBe(subject.build())} ${subject.build()} being $objectVal?"
        }
        return "${toBe(subject.build())} ${subject.build()} ${verb.continuous()} $objectVal?"
    }

    //TODO
    //Verbs that are not usually used in the continuous form
    //The verbs in the list below are normally used in the simple form because they refer to states, rather than actions or processes.
}