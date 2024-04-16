package com.spascoding.feature_exam.domain.model.sentence.future

import com.spascoding.feature_exam.domain.model.noun.Noun
import com.spascoding.feature_exam.domain.model.sentence.Sentence
import com.spascoding.feature_exam.domain.model.verb.Verb

/**
 * The future perfect continuous is composed of two elements
 * the future perfect of the verb "to be" (will have been) + the present participle of the main verb (base + ing)
 */
class FuturePerfectContinuousSentence(
    private val subject: Noun,
    private val verb: Verb,
    private val objectVal: String,
): Sentence {

    /**
     * Positive: Subject + will have been + verb-ing + object.
     * "She will have been walking around."
     */
    override fun positive(): String {
        return "${subject.build()} will have been ${verb.continuous()} $objectVal."
    }

    /**
     * Negative: Subject + will not have been + verb-ing + object.
     * "She will not have been walking around."
     */
    override fun negative(): String {
        return "${subject.build()} will not have been ${verb.continuous()} $objectVal."
    }

    /**
     * Question: Will + subject + have been + verb-ing + object?
     * "Will she have been walking around?"
     */
    override fun question(): String {
        return "will ${subject.build()} have been ${verb.continuous()} $objectVal?"
    }
}