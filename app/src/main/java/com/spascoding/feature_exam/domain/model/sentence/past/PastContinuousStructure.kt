package com.spascoding.feature_exam.domain.model.sentence.past

import com.spascoding.feature_exam.data.data_source.sentence_parts.Verbs
import com.spascoding.feature_exam.domain.model.noun.Noun
import com.spascoding.feature_exam.domain.model.sentence.Structure
import com.spascoding.feature_exam.domain.model.verb.Verb
import com.spascoding.feature_exam.domain.model.verb.toBePast

/**
 * - often, to describe the background in a story written in the past tense:
 * "The sun was shining and the birds were singing as the elephant came out of the jungle.
 * The other animals were relaxing in the shade of the trees, but the elephant moved very quickly.
 * She was looking for her baby, and she didn't notice the hunter who was watching her through his binoculars.
 * When the shot rang out, she was running towards the river..."
 * - to describe an unfinished action that was interrupted by another event or action: "I was having a beautiful dream when the alarm clock rang."
 * - to express a change of mind: "I was going to spend the day at the beach but I've decided to get my homework done instead."
 */
class PastContinuousStructure(
    private val subject: Noun,
    private val verb: Verb,
    private val objectVal: String,
): Structure {

    /**
     * Positive: Subject + was/were + verb-ing + object.
     * "She was walking around."
     */
    override fun positive(): String {
        if (verb == Verbs.toBe) {
            return "${subject.build()} ${toBePast(subject.build())} being $objectVal."
        }
        return "${subject.build()} ${toBePast(subject.build())} ${verb.continuous()} $objectVal."
    }

    /**
     * Negative: Subject + was/were not + verb-ing + object.
     * "She was not walking around."
     */
    override fun negative(): String {
        if (verb == Verbs.toBe) {
            return "${subject.build()} ${toBePast(subject.build())} not being $objectVal."
        }
        return "${subject.build()} ${toBePast(subject.build())} not ${verb.continuous()} $objectVal."
    }

    /**
     * Question: Was/Were + subject + verb-ing + object?
     * "Was she walking around?"
     */
    override fun question(): String {
        if (verb == Verbs.toBe) {
            return "${toBePast(subject.build())} ${subject.build()} being $objectVal?"
        }
        return "${toBePast(subject.build())} ${subject.build()} ${verb.continuous()} $objectVal?"
    }
}