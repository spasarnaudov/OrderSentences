package com.sacoding.feature_exam.domain.model

class PluralPronoun(
    value: Values
): Pronoun(value.value) {
    enum class Values(val value: String) {
        WE("we"),
        YOU("you"),
        THEY("they"),
    }
}

