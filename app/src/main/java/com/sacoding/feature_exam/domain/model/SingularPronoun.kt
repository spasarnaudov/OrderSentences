package com.sacoding.feature_exam.domain.model

class SingularPronoun(
    private val value: Values,
    private val preposition: String = "",
) : Pronoun(value.value, preposition) {
    enum class Values(val value: String) {
        I("I"),
        YOU("you"),
        HE("he"),
        SHE("she"),
        IT("it"),
    }
}