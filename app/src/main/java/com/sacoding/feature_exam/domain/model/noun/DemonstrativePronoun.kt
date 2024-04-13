package com.sacoding.feature_exam.domain.model.noun

class DemonstrativePronoun(
    private val value: String
): Pronoun(value = value) {

    companion object {
        val THIS = DemonstrativePronoun("this")     //singular pronoun to talk about people or things near us
        val THAT = DemonstrativePronoun("that")     //singular pronoun to talk about things that are not near us
        val THESE = DemonstrativePronoun("these")   //plural pronoun to talk about people or things near us
        val THOSE = DemonstrativePronoun("those")   //plural pronoun to talk about things that are not near us
    }

}