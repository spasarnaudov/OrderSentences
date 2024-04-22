package com.spascoding.feature_exam.domain.model.sentence.past

import com.spascoding.feature_exam.data.data_source.Verbs
import com.spascoding.feature_exam.domain.model.noun.Noun
import com.spascoding.feature_exam.domain.model.sentence.Structure
import com.spascoding.feature_exam.domain.model.verb.Verb

/**
 * The past perfect refers to a time earlier than before now.
 * It is used to make it clear that one event happened before another in the past.
 * It does not matter which event is mentioned first - the tense makes it clear which one happened first.
 */
class PastPerfectStructure(
    private val subject: Noun,
    private val verb: Verb,
    private val objectVal: String,
): Structure {

    /**
     * Positive: Subject + had + past participle + object.
     * "She had walked around."
     */
    override fun positive(): String {
        if (verb == Verbs.toBe) {
            return "${subject.build()} had been $objectVal."
        }
        return "${subject.build()} had ${verb.pastParticiple} $objectVal."
    }

    /**
     * Negative: Subject + had not + past participle + object.
     * "She had not walked + around."
     */
    override fun negative(): String {
        if (verb == Verbs.toBe) {
            return "${subject.build()} had not been $objectVal."
        }
        return "${subject.build()} had not ${verb.pastParticiple} $objectVal."
    }

    /**
     * Question: Had + subject + past participle + object?
     * "Had she walked around?"
     */
    override fun question(): String {
        if (verb == Verbs.toBe) {
            return "had ${subject.build()} been $objectVal?"
        }
        return "had ${subject.build()} ${verb.pastParticiple} $objectVal?"
    }
}