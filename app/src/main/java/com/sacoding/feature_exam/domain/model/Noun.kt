package com.sacoding.feature_exam.domain.model

data class Noun(
    val singular: String,
    val plural: String = singular.plural(),
)

fun Noun.addArticle(definiteArticle: Boolean = false): Noun {
    return if (definiteArticle) {
        copy(
            singular = "the $singular",
            plural = "the $plural"
        )
    } else if (listVowels.contains(singular.lowercase()[0].toString())) {
        copy(singular = "an $singular")
    } else {
        copy(singular = "a $singular")
    }
}

fun String.plural(): String {
    val lastLetter = lowercase()[length-1]
    val penultimate = lowercase()[length-2]
    if (lastLetter == 'y' && !listVowels.contains(penultimate.toString())) {
        return replaceAfterLast("y", "ies")
    }
    return "${this}s"
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
