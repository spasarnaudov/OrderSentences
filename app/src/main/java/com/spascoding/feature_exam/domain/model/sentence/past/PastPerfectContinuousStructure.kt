package com.spascoding.feature_exam.domain.model.sentence.past

import com.spascoding.feature_exam.data.data_source.Verbs
import com.spascoding.feature_exam.domain.model.noun.Noun
import com.spascoding.feature_exam.domain.model.sentence.Structure
import com.spascoding.feature_exam.domain.model.verb.Verb

/**
 *The past perfect continuous corresponds to the present perfect continuous, but with reference to a time earlier than 'before now'.
 * As with the present perfect continuous, we are more interested in the process.
 */
class PastPerfectContinuousStructure(
    private val subject: Noun,
    private val verb: Verb,
    private val objectVal: String,
): Structure {

    /**
     * Positive: Subject + had been + verb-ing + object.
     * "She had been walking around."
     */
    override fun positive(): String {
        if (verb == Verbs.toBe) {
            return "${subject.build()} had been being $objectVal."
        }
        return "${subject.build()} had been ${verb.continuous()} $objectVal."
    }

    /**
     * Negative: Subject + had not been + verb-ing + object.
     * "She had not been walking around."
     */
    override fun negative(): String {
        if (verb == Verbs.toBe) {
            return "${subject.build()} had not been being $objectVal."
        }
        return "${subject.build()} had not been ${verb.continuous()} $objectVal."
    }

    /**
     * Question: Had + subject + been + verb-ing + object?
     * "Had she been walking around?"
     */
    override fun question(): String {
        if (verb == Verbs.toBe) {
            return "had ${subject.build()} been being $objectVal?"
        }
        return "had ${subject.build()} been ${verb.continuous()} $objectVal?"
    }
}