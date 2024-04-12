package com.sacoding.feature_exam.domain.model.noun

import com.sacoding.feature_exam.domain.Article
import com.sacoding.feature_exam.domain.model.Adjective
import com.sacoding.feature_exam.domain.model.BLANK_ADJECTIVE

data class SingularNoun(
    private val value: String,
    private val article: Article = Article.NONE,
    private val adjective: Adjective = BLANK_ADJECTIVE,
    private val preposition: String = "",
): CommonNoun(
    value = value,
    article = article,
    adjective = adjective,
    preposition = preposition,
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
        return PluralNoun(value, article, adjective, preposition)
    }
}

fun List<SingularNoun>.plural(): List<PluralNoun> {
    val list = mutableListOf<PluralNoun>()
    for (item in this) {
        list.add(item.toPlural())
    }
    return list
}