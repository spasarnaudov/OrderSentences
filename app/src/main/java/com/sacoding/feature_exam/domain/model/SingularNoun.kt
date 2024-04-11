package com.sacoding.feature_exam.domain.model

import com.sacoding.feature_exam.domain.Article

data class SingularNoun(
    private val article: Article = Article.NONE,
    private val adjective: Adjective = BLANK_ADJECTIVE,
    private val value: String
): CommonNoun(
    article = article,
    adjective = adjective,
    value = value
) {
    override fun getArticle(article: Article): String {
        return if (article == Article.NONE) {
            ""
        } else if (article == Article.DEFINITE) {
            "the"
        } else if (listVowels.contains(value.lowercase()[0].toString())) {
            "an"
        } else {
            "a"
        }
    }

    fun toPlural(): PluralNoun {
        return PluralNoun(article, adjective, value)
    }
}

fun List<SingularNoun>.plural(): List<PluralNoun> {
    val list = mutableListOf<PluralNoun>()
    for (item in this) {
        list.add(item.toPlural())
    }
    return list
}