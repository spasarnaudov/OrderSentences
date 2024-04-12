package com.sacoding.feature_exam.domain.model.noun

class PluralPronoun(
    private val value: Values,
    private val preposition: String = "",
): Pronoun(value.value, preposition) {
    enum class Values(val value: String) {
        WE("we"),
        YOU("you"),
        THEY("they"),
    }
}

