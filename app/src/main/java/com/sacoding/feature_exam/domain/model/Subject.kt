package com.sacoding.feature_exam.domain.model

data class Subject(
    private val noun: Noun,
) {
    fun build(): String {
        return noun.build()
    }
}