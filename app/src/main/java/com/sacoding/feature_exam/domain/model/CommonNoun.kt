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

fun String.addArticle(): String {
    return if (listVowels.contains(this.lowercase()[0].toString())) {
        "an $this"
    } else {
        "a $this"
    }
}

fun List<String>.addArticle(): List<String> {
    val list = mutableListOf<String>()
    for (item in this) {
        list.add(item.addArticle())
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
