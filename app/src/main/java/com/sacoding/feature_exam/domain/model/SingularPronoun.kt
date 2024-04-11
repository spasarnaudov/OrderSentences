package com.sacoding.feature_exam.domain.model

class SingularPronoun(
    value: Values
) : Pronoun(value.value) {
    enum class Values(val value: String) {
        I("I"),
        YOU("you"),
        HE("he"),
        SHE("she"),
        IT("it"),
    }
}