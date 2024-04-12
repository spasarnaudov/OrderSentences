package com.sacoding.feature_exam.domain.model.sentence

import com.sacoding.feature_exam.domain.model.noun.Noun
import com.sacoding.feature_exam.domain.model.verb.Verb
import com.sacoding.feature_exam.domain.model.verb.toBePast
import com.sacoding.feature_exam.domain.model.verb.toContinuous

/**
 * - often, to describe the background in a story written in the past tense:
 * "The sun was shining and the birds were singing as the elephant came out of the jungle.
 * The other animals were relaxing in the shade of the trees, but the elephant moved very quickly.
 * She was looking for her baby, and she didn't notice the hunter who was watching her through his binoculars.
 * When the shot rang out, she was running towards the river..."
 * - to describe an unfinished action that was interrupted by another event or action: "I was having a beautiful dream when the alarm clock rang."
 * - to express a change of mind: "I was going to spend the day at the beach but I've decided to get my homework done instead."
 */
class PastContinuousSentence(
    private val subject: Noun,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {

    /**
     * Positive: Subject + was/were + verb-ing + object.
     * "She was walking around."
     */
    override fun positive(): String {
        return "${subject.build()} ${toBePast(subject.build())} ${verb.toContinuous()} $objectVal."
    }

    /**
     * Negative: Subject + was/were not + verb-ing + object.
     * "She was not walking around."
     */
    override fun negative(): String {
        return "${subject.build()} ${toBePast(subject.build())} not ${verb.toContinuous()} $objectVal."
    }

    /**
     * Question: Was/Were + subject + verb-ing + object?
     * "Was she walking around?"
     */
    override fun question(): String {
        return "${toBePast(subject.build())} ${subject.build()} ${verb.toContinuous()} $objectVal?"
    }
}