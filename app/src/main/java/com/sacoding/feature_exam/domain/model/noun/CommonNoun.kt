package com.sacoding.feature_exam.domain.model.noun

import com.sacoding.feature_exam.domain.Article
import com.sacoding.feature_exam.domain.model.Adjective
import com.sacoding.feature_exam.domain.model.BLANK_ADJECTIVE

abstract class CommonNoun(
    private val value: String,
    private val article: Article = Article.NONE,
    private val adjective: Adjective = BLANK_ADJECTIVE,
    private val preposition: String = "",
): Noun() {
    abstract fun getArticle(article: Article = Article.NONE): String

    override fun build(): String {
        return buildString {
            if (preposition.isNotBlank()) {
                append(preposition).append(" ")
            }
            if (article != Article.NONE) {
                val articleVal = getArticle(article)
                if (articleVal.isNotBlank()) {
                    append(articleVal).append(" ")
                }
            }
            if (adjective.isNotBlank()) {
                append(adjective.build()).append(" ")
            }
            append(value)
        }
    }
}

fun List<CommonNoun>.addArticle(article: Article): List<CommonNoun> {
    val list = mutableListOf<CommonNoun>()
    for (item in this) {
        if (item is SingularNoun) {
            list.add(item.copy(article = article))
        } else if (item is PluralNoun) {
            list.add(item.copy(article = article))
        }
    }
    return list
}

fun List<CommonNoun>.addPossessiveAdjective(adjectives: List<Adjective>): List<CommonNoun> {
    val list = mutableListOf<CommonNoun>()
    for (item in this) {
        for (adjective in adjectives) {
            if (item is SingularNoun) {
                list.add(item.copy(adjective = adjective))
            } else if (item is PluralNoun) {
                list.add(item.copy(adjective = adjective))
            }
        }
    }
    return list
}
