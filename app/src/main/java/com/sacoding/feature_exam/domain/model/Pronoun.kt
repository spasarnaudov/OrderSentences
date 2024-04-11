package com.sacoding.feature_exam.domain.model

open class Pronoun(
    private val value: String,
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
}