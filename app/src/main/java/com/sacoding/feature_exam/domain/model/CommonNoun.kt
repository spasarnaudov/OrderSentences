package com.sacoding.feature_exam.domain.model

import com.sacoding.feature_exam.domain.Article

abstract class CommonNoun(
    private val article: Article = Article.NONE,
    private val adjective: Adjective = BLANK_ADJECTIVE,
    private val value: String,
): Noun() {
    abstract fun getArticle(article: Article = Article.NONE): String

    override fun build(): String {
        return buildString {
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

val listVowels = listOf(
    "a", "e", "i", "o", "u", "y"
)

fun List<String>.plural(): List<String> {
    val list = mutableListOf<String>()
    for (item in this) {
        list.add(item.plural())
    }
    return list
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

fun List<String>.addPossessiveAdjective(adjectives: List<Adjective>): List<String> {
    val list = mutableListOf<String>()
    for (item in this) {
        for (adjective in adjectives) {
            list.add("${adjective.build()} $item")
        }
    }
    return list
}
