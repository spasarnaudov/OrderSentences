package com.sacoding.feature_exam.domain.model

data class Subject(
    private val article: String = "",
    private val adjective: String = "",
    private val noun: String,
) {
    fun build(): String {
        return buildString {
            if (article.isNotBlank()) {
                append(article).append(" ")
            }
            if (adjective.isNotBlank()) {
                append(adjective).append(" ")
            }
            append(noun)
        }
    }
}