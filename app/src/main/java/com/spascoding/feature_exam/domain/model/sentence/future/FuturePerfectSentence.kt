package com.spascoding.feature_exam.domain.model.sentence.future

import com.spascoding.feature_exam.domain.model.noun.Noun
import com.spascoding.feature_exam.domain.model.sentence.Sentence
import com.spascoding.feature_exam.domain.model.verb.Verb

/**
 * The future perfect is composed of two elements
 * the simple future of the verb "to have" (will have) + the past participle of the main verb
 */
class FuturePerfectSentence(
    private val subject: Noun,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {

    /**
     * Positive: Subject + will have + past participle + object.
     * "She will have walked around."
     */
    override fun positive(): String {
        return "${subject.build()} will have ${verb.pastParticiple} $objectVal."
    }

    /**
     * Negative: Subject + will not have + past participle + object.
     * "She will not have walked around."
     */
    override fun negative(): String {
        return "${subject.build()} will not have ${verb.pastParticiple} $objectVal."
    }

    /**
     * Question: Will + subject + have + past participle + object?
     * "Will she have walked around?"
     */
    override fun question(): String {
        return "will ${subject.build()} have ${verb.pastParticiple} $objectVal?"
    }
}