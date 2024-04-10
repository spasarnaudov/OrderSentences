package com.sacoding.feature_exam.domain.model

class PluralNoun(
    singular: String
): Noun(
    value = singular.plural()
) {
    override fun getArticle(definiteArticle: Boolean): String {
        return if (definiteArticle) {
            return "the"
        } else {
            return ""
        }
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