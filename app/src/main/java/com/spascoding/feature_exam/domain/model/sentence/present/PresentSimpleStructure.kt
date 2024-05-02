package com.spascoding.feature_exam.domain.model.sentence.present

import com.spascoding.feature_exam.data.data_source.sentence_parts.Verbs
import com.spascoding.feature_exam.domain.model.noun.Noun
import com.spascoding.feature_exam.domain.model.sentence.Structure
import com.spascoding.feature_exam.domain.model.verb.Verb
import com.spascoding.feature_exam.domain.model.verb.toBe

/**
 * Use for:
 * - habits: "He drinks tea at breakfast.", "She only eats fish.", "They watch television regularly."
 * - repeated actions or events: "We catch the bus every morning.", "It rains every afternoon in the hot season.", "They drive to Monaco every summer."
 * - general truths: "Water freezes at zero degrees.", "The Earth revolves around the Sun.", "Her mother is Peruvian."
 * - instructions or directions: "Open the packet and pour the contents into hot water.", "You take the No.6 bus to Watney and then the No.10 to Bedford."
 * - fixed arrangements: "His mother arrives tomorrow.", "Our holiday starts on the 26th March"
 * - future constructions: "She'll see you before she leaves.", "We'll give it to her when she arrives."
 */

class PresentSimpleStructure(
    private val subject: Noun,
    private val verb: Verb,
    private val objectVal: String,
) : Structure {

    /**
     * Positive: Subject + base verb (+ "s/es" for third person singular) + object.
     *     "She walks around."
     */
    override fun positive(): String {
        if (verb == Verbs.toBe) {
            return "${subject.build()} ${toBe(subject.build())} $objectVal."
        }
        return "${subject.build()} ${verb.subjectBaseForm(subject)} $objectVal."
    }

    /**
     * Negative: Subject + do/does not + base verb + object.
     * "She does not walk around."
     */
    override fun negative(): String {
        if (verb == Verbs.toBe) {
            return "${subject.build()} ${toBe(subject.build())} not $objectVal."
        }
        return "${subject.build()} ${Verbs.`do`.subjectBaseForm(subject)} not ${verb.baseForm} $objectVal."
    }

    /**
     * Question: Do/Does + subject + base verb + object?
     * "Does she walk around?"
     */
    override fun question(): String {
        if (verb == Verbs.toBe) {
            return "${toBe(subject.build())} ${subject.build()} $objectVal?"
        }
        return "${Verbs.`do`.subjectBaseForm(subject)} ${subject.build()} ${verb.baseForm} $objectVal?"
    }
}