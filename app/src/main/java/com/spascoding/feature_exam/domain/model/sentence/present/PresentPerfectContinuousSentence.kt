package com.spascoding.feature_exam.domain.model.sentence.present

import com.spascoding.feature_exam.data.data_source.Verbs
import com.spascoding.feature_exam.domain.model.noun.Noun
import com.spascoding.feature_exam.domain.model.sentence.Sentence
import com.spascoding.feature_exam.domain.model.verb.Verb
import com.spascoding.feature_exam.domain.model.verb.adaptToSubject
import com.spascoding.feature_exam.domain.model.verb.toContinuous

/**
 * - Actions that started in the past and continue in the present:
 * "She has been waiting for you all day (= and she's still waiting now).",
 * "I've been working on this report since eight o'clock this morning (= and I still haven't finished it).",
 * "They have been travelling since last October (= and they're not home yet)."
 * - Actions that have just finished, but we are interested in the results:
 * "She has been cooking since last night (= and the food on the table looks delicious).",
 * "It's been raining (= and the streets are still wet).",
 * "Someone's been eating my chips (= half of them have gone)."
 */

class PresentPerfectContinuousSentence(
    private val subject: Noun,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {

    /**
     * Positive: Subject + has/have been + verb-ing + object.
     * "She has been walking around."
     */
    override fun positive(): String {
        return "${subject.build()} ${Verbs.have.adaptToSubject(subject)} been ${verb.toContinuous()} $objectVal."
    }

    /**
     * Negative: Subject + has/have not been + verb-ing + object.
     * "She has not been walking around."
     */
    override fun negative(): String {
        return "${subject.build()} ${Verbs.have.adaptToSubject(subject)} not been ${verb.toContinuous()} $objectVal."
    }

    /**
     * Question: Has/Have + subject + been + verb-ing + object?
     * "Has she been walking around?"
     */
    override fun question(): String {
        return "${Verbs.have.adaptToSubject(subject)} ${subject.build()} been ${verb.toContinuous()} $objectVal?"
    }
}