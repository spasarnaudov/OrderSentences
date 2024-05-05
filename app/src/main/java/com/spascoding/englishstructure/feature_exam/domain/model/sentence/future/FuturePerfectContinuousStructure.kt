package com.spascoding.englishstructure.feature_exam.domain.model.sentence.future

import com.spascoding.englishstructure.feature_exam.data.data_source.sentence_parts.Verbs
import com.spascoding.englishstructure.feature_exam.domain.model.noun.Noun
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.Structure
import com.spascoding.englishstructure.feature_exam.domain.model.verb.Verb

/**
 * The future perfect continuous is composed of two elements
 * the future perfect of the verb "to be" (will have been) + the present participle of the main verb (base + ing)
 */
class FuturePerfectContinuousStructure(
    private val subject: Noun,
    private val verb: Verb,
    private val objectVal: String,
): Structure {

    /**
     * Positive: Subject + will have been + verb-ing + object.
     * "She will have been walking around."
     */
    override fun positive(): String {
        if (verb == Verbs.toBe) {
            return "${subject.build()} will been being $objectVal."
        }
        return "${subject.build()} will have been ${verb.continuous()} $objectVal."
    }

    /**
     * Negative: Subject + will not have been + verb-ing + object.
     * "She will not have been walking around."
     */
    override fun negative(): String {
        if (verb == Verbs.toBe) {
            return "${subject.build()} will not been being $objectVal."
        }
        return "${subject.build()} will not have been ${verb.continuous()} $objectVal."
    }

    /**
     * Question: Will + subject + have been + verb-ing + object?
     * "Will she have been walking around?"
     */
    override fun question(): String {
        if (verb == Verbs.toBe) {
            return "will ${subject.build()} been being $objectVal?"
        }
        return "will ${subject.build()} have been ${verb.continuous()} $objectVal?"
    }
}