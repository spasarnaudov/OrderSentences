package com.sacoding.feature_exam.domain.model.noun

class IndefiniteOnePronoun(
    private val value: String
) : Pronoun(value = value) {
    companion object {
        val ANYONE = IndefiniteOnePronoun("anyone")
        val EVERYONE = IndefiniteOnePronoun("everyone")
        val NO_ONE = IndefiniteOnePronoun("no one")
        val SOMEONE = IndefiniteOnePronoun("someone")
    }
}