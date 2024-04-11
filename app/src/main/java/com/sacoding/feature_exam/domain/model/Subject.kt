package com.sacoding.feature_exam.domain.model

import com.sacoding.feature_exam.domain.Article

data class Subject(
    private val article: Article = Article.NONE,
    private val adjective: Adjective = BLANK_ADJECTIVE,
    private val noun: Noun,
) {
    fun build(): String {
        return buildString {
            if (article != Article.NONE) {
                val articleVal = noun.getArticle(article)
                if (articleVal.isNotBlank()) {
                    append(articleVal).append(" ")
                }
            }
            if (adjective.isNotBlank()) {
                append(adjective.build()).append(" ")
            }
            append(noun.value)
        }
    }
}