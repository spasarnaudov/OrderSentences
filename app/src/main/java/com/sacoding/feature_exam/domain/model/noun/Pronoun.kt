package com.sacoding.feature_exam.domain.model.noun

open class Pronoun(
    val value: String,
    private val preposition: String = "",
): Noun() {

    override fun build(): String {
        return buildString {
            if (preposition.isNotBlank()) {
                append(preposition).append(" ")
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
        val YOU = Pronoun("you")
        val HE = Pronoun("he")
        val SHE = Pronoun("she")
        val IT = Pronoun("it")

        val WE = Pronoun("we")
//        val YOU = Pronoun("you")
        val THEY = Pronoun("they")

//        Demonstratives

        val THIS = Pronoun("this")
        val THAT = Pronoun("that")
        val THESE = Pronoun("these")
        val THOSE = Pronoun("those")

//        Possessive

        val MINE = Pronoun("mine")
        val YOURS = Pronoun("yours")
        val HIS = Pronoun("his")
        val HERS = Pronoun("hers")

        val OURS = Pronoun("ours")
//        val YOURS = Pronoun("yours")
        val THEIRS = Pronoun("theirs")

//        Objects

        val ME = Pronoun("me")
//        val YOU = Pronoun("you")
        val HIM = Pronoun("him")
        val HER = Pronoun("her")
//        val IT = Pronoun("it")

        val US = Pronoun("us")
        val THEM = Pronoun("them")

//        Reciprocal

        val EACH_OTHER = Pronoun("each other")
        val ONE_ANOTHER = Pronoun("one another")

//        Indefinite

        val ANYBODY = Pronoun("anybody")
        val EVERYBODY = Pronoun("everybody")
        val NOBODY = Pronoun("nobody")
        val SOMEBODY = Pronoun("somebody")

        val ANYONE = Pronoun("anyone")
        val EVERYONE = Pronoun("everyone")
        val NO_ONE = Pronoun("no one")
        val SOMEONE = Pronoun("someone")

        val ANYTHING = Pronoun("anything")
        val EVERYTHING = Pronoun("everything")
        val NOTHING = Pronoun("nothing")
        val SOMETHING = Pronoun("something")
    }
}