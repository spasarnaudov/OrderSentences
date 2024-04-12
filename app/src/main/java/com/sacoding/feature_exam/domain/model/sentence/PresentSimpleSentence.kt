package com.sacoding.feature_exam.domain.model.sentence

import com.sacoding.feature_exam.data.data_source.Verbs
import com.sacoding.feature_exam.domain.model.verb.Verb
import com.sacoding.feature_exam.domain.model.verb.getSingularPresentTenseForm
import com.sacoding.feature_exam.domain.model.verb.toBe

/**
 * Use for:
 * - habits: "He drinks tea at breakfast.", "She only eats fish.", "They watch television regularly."
 * - repeated actions or events: "We catch the bus every morning.", "It rains every afternoon in the hot season.", "They drive to Monaco every summer."
 * - general truths: "Water freezes at zero degrees.", "The Earth revolves around the Sun.", "Her mother is Peruvian."
 * - instructions or directions: "Open the packet and pour the contents into hot water.", "You take the No.6 bus to Watney and then the No.10 to Bedford."
 * - fixed arrangements: "His mother arrives tomorrow.", "Our holiday starts on the 26th March"
 * - future constructions: "She'll see you before she leaves.", "We'll give it to her when she arrives."
 */

class PresentSimpleSentence(
    private val subject: String,
    private val questionWord: String,
    private val verb: Verb,
    private val objectVal: String,
    private val prepositionalPhrase: String = "",
) : Sentence {

    /**
     * Positive: Subject + base verb (+ "s/es" for third person singular) + object.
     *     "She walks around."
     */
    override fun positive(): String {
        if (verb == Verbs.toBe) {
            return "$subject ${toBe(subject)} $objectVal."
        }
        return "$subject ${verb.getSingularPresentTenseForm(subject)} $objectVal."
    }

    /**
     * Negative: Subject + do/does not + base verb + object.
     * "She does not walk around."
     */
    override fun negative(): String {
        if (verb == Verbs.toBe) {
            return "$subject ${toBe(subject)} not $objectVal."
        }
        return "$subject ${Verbs.`do`.getSingularPresentTenseForm(subject)} not ${verb.baseForm} $objectVal."
    }

    /**
     * Question: Do/Does + subject + base verb + object?
     * "Does she walk around?"
     */
    override fun question(): String {
        if (verb == Verbs.toBe) {
            return buildString {
                if (questionWord.isNotBlank()) {
                    append(questionWord).append(" ")
                }
                append(toBe(subject)).append(" ")
                append(subject).append(" ")
                append(objectVal).append("?")
            }
        }
        return buildString {
            append(Verbs.`do`.getSingularPresentTenseForm(subject)).append(" ")
            append(subject).append(" ")
            append(verb.baseForm).append(" ")
            append(objectVal).append("?")
        }
    }
}