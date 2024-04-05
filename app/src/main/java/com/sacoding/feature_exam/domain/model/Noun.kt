package com.sacoding.feature_exam.domain.model

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

val listVowels = listOf(
    "a", "e", "i", "o", "u", "y"
)
