package com.sacoding.feature_exam.domain.model.noun

class SingularPossessivePronoun(
    private val value: String
) : Pronoun(value = value) {

    companion object {
        val MINE = SingularPossessivePronoun("mine")
        val YOURS = SingularPossessivePronoun("yours")
        val HIS = SingularPossessivePronoun("his")
        val HERS = SingularPossessivePronoun("hers")
    }

}