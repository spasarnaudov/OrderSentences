package com.sacoding.feature_exam.domain.model.noun

class PluralPossessivePronoun(
    private val value: String
) : Pronoun(value = value) {

    companion object {
        val OURS = PluralPossessivePronoun("ours")
        val YOURS = PluralPossessivePronoun("yours")
        val THEIRS = PluralPossessivePronoun("theirs")
    }

}