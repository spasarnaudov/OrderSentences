package com.sacoding.feature_exam.domain.model.sentence

import com.sacoding.feature_exam.domain.model.verb.Verb

/**
 * - To predict a future event: "It will rain tomorrow."
 * - With I or We, to express a spontaneous decision: "I'll pay for the tickets by credit card."
 * - To express willingness: "I'll do the washing-up.", "He'll carry your bag for you."
 * - In the negative form, to express unwillingness: "The baby won't eat his soup.", "I won't leave until I've seen the manager!"
 * - With I in the interrogative form using "shall", to make an offer: "Shall I open the window?"
 * - With we in the interrogative form using "shall", to make a suggestion: "Shall we go to the cinema tonight?"
 * - With I in the interrogative form using "shall", to ask for advice or instructions: "What shall I tell the boss about this money?"
 * - With you, to give orders: "You will do exactly as I say."
 * - With you in the interrogative form, to give an invitation: "Will you come to the dance with me?", "Will you marry me?"
 *
 * Note: In modern English will is preferred to shall. Shall is mainly used with I and we to make an offer or suggestion,
 * or to ask for advice (see examples above). With the other persons (you, he, she, they) shall is only used in literary or poetic situations:
 * "With rings on her fingers and bells on her toes, She shall have music wherever she goes."
 */
class FutureSimpleSentence(
    private val subject: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
): Sentence {

    /**
     * Positive: Subject + will + base verb + object.
     * "She will walk around."
     */
    override fun positive(): String {
        return "$subject will ${verb.baseForm} $objectVal."
    }

    /**
     * Negative: Subject + will not + base verb + object.
     * "She will not walk around."
     */
    override fun negative(): String {
        return "$subject will not ${verb.baseForm} $objectVal."
    }

    /**
     * Question: Will + subject + base verb + object?
     * "Will she walk around?"
     */
    override fun question(): String {
        return "will $subject ${verb.baseForm} $objectVal?"
    }
}