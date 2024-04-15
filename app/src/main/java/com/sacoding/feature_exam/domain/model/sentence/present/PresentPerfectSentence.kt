package com.sacoding.feature_exam.domain.model.sentence.present

import com.sacoding.feature_exam.data.data_source.Verbs
import com.sacoding.feature_exam.domain.model.noun.Noun
import com.sacoding.feature_exam.domain.model.sentence.Sentence
import com.sacoding.feature_exam.domain.model.verb.Verb
import com.sacoding.feature_exam.domain.model.verb.adaptToSubject

/**
 * - Actions started in the past and continuing in the present:
 * "They haven't lived here for years.",
 * "She has worked in the bank for five years.", "We have had the same car for ten years.",
 * "Have you played the piano since you were a child?"
 * - When the time period referred to has not finished: "I have worked hard this week.",
 * "It has rained a lot this year.",
 * "We haven't seen her today."
 * - Actions repeated in an unspecified period between the past and now:
 * "They have seen that film six times", "It has happened several times already.",
 * "She has visited them frequently.", "We have eaten at that restaurant many times."
 * - Actions completed in the very recent past (+just): "Have you just finished work?",
 * "I have just eaten.", "We have just seen her.", "Has he just left?"
 * - When the precise time of the action is not important or not known: "Someone has eaten my soup!",
 * "Have you seen 'Gone with the Wind'?", "She's studied Japanese, Russian, and English."
 */
class PresentPerfectSentence(
    private val subject: Noun,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
) : Sentence {

    /**
     * Positive: Subject + has/have + past participle + object.
     * "She has walked around."
     */
    override fun positive(): String {
        return "${subject.build()} ${Verbs.have.adaptToSubject(subject)} ${verb.pastParticiple} $objectVal."
    }

    /**
     * Negative: Subject + has/have not + past participle + object.
     * "She has not walked around."
     */
    override fun negative(): String {
        return "${subject.build()} ${Verbs.have.adaptToSubject(subject)} not ${verb.pastParticiple} $objectVal."
    }

    /**
     * Question: Has/Have + subject + past participle + object?
     * "Has she walked around?"
     */
    override fun question(): String {
        return "${Verbs.have.adaptToSubject(subject)} ${subject.build()} ${verb.pastParticiple} $objectVal?"
    }
}