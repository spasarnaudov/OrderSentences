package com.spascoding.feature_exam.domain.model.sentence.past

import com.spascoding.feature_exam.domain.model.noun.Noun
import com.spascoding.feature_exam.domain.model.sentence.Sentence
import com.spascoding.feature_exam.domain.model.verb.Verb

/**
 * The past perfect refers to a time earlier than before now.
 * It is used to make it clear that one event happened before another in the past.
 * It does not matter which event is mentioned first - the tense makes it clear which one happened first.
 */
class PastPerfectSentence(
    private val subject: Noun,
    private val verb: Verb,
    private val objectVal: String,
): Sentence {

    /**
     * Positive: Subject + had + past participle + object.
     * "She had walked around."
     */
    override fun positive(): String {
        return "${subject.build()} had ${verb.pastParticiple} $objectVal."
    }

    /**
     * Negative: Subject + had not + past participle + object.
     * "She had not walked + around."
     */
    override fun negative(): String {
        return "${subject.build()} had not ${verb.pastParticiple} $objectVal."
    }

    /**
     * Question: Had + subject + past participle + object?
     * "Had she walked around?"
     */
    override fun question(): String {
        return "had ${subject.build()} ${verb.pastParticiple} $objectVal?"
    }
}