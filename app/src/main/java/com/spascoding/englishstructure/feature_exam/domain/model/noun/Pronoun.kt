package com.spascoding.englishstructure.feature_exam.domain.model.noun

import com.spascoding.englishstructure.feature_exam.domain.enums.Plurality
import com.spascoding.englishstructure.feature_exam.domain.model.Preposition

data class Pronoun(
    private val value: String,
    override val plurality: Plurality = Plurality.SINGULAR,
    override var preposition: Preposition = Preposition.EMPTY,
): Noun(
    countable = true,
    plurality = plurality,
    preposition = preposition,
) {

    override fun build(): String {
        return buildString {
            if (preposition != Preposition.EMPTY) {
                append(preposition.value).append(" ")
            }
            append(value)
        }
    }

    override fun isThirdPerson(): Boolean {
        return this != I
            && this != YOU
            && this != WE
            && this != THEY
    }

    companion object {
        val I = Pronoun("I")
        val YOU = Pronoun("you", Plurality.PLURAL)
        val HE = Pronoun("he")
        val SHE = Pronoun("she")
        val IT = Pronoun("it")

        val WE = Pronoun("we", Plurality.PLURAL)
//        val YOU = Pronoun("you")
        val THEY = Pronoun("they", Plurality.PLURAL)

//        Demonstratives

        val THIS = Pronoun("this")
        val THAT = Pronoun("that")
        val THESE = Pronoun("these", Plurality.PLURAL)
        val THOSE = Pronoun("those", Plurality.PLURAL)

//        Possessive

        val MINE = Pronoun("mine")
        val YOURS = Pronoun("yours", Plurality.PLURAL)
        val HIS = Pronoun("his")
        val HERS = Pronoun("hers")

        val OURS = Pronoun("ours", Plurality.PLURAL)
//        val YOURS = Pronoun("yours")
        val THEIRS = Pronoun("theirs", Plurality.PLURAL)

//        Objects

        val ME = Pronoun("me")
//        val YOU = Pronoun("you")
        val HIM = Pronoun("him")
        val HER = Pronoun("her")
//        val IT = Pronoun("it")

        val US = Pronoun("us", Plurality.PLURAL)
        val THEM = Pronoun("them", Plurality.PLURAL)

//        Reciprocal

        val EACH_OTHER = Pronoun("each other")
        val ONE_ANOTHER = Pronoun("one another")

//        Indefinite

        val ANYBODY = Pronoun("anybody", Plurality.PLURAL)
        val EVERYBODY = Pronoun("everybody", Plurality.PLURAL)
        val NOBODY = Pronoun("nobody")
        val SOMEBODY = Pronoun("somebody")

        val ANYONE = Pronoun("anyone", Plurality.PLURAL)
        val EVERYONE = Pronoun("everyone", Plurality.PLURAL)
        val NO_ONE = Pronoun("no one")
        val SOMEONE = Pronoun("someone")

        val ANYTHING = Pronoun("anything", Plurality.PLURAL)
        val EVERYTHING = Pronoun("everything", Plurality.PLURAL)
        val NOTHING = Pronoun("nothing")
        val SOMETHING = Pronoun("something")
    }
}