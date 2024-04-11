package com.sacoding.feature_exam.domain.model

open class Pronoun(
    open val value: String,
): Noun() {
    override fun build(): String {
        return value
    }
}