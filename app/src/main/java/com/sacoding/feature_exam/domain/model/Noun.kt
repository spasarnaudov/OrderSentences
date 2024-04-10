package com.sacoding.feature_exam.domain.model

abstract class Noun(
    val value: String,
) {
    abstract fun getArticle(definiteArticle: Boolean = false): String
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

fun List<String>.addPossessiveAdjective(adjectives: List<String>): List<String> {
    val list = mutableListOf<String>()
    for (item in this) {
        for (adjective in adjectives) {
            list.add("$adjective $item")
        }
    }
    return list
}
