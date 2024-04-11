package com.sacoding.feature_exam.domain.model

import com.sacoding.feature_exam.domain.Article

class PluralNoun(
    private val article: Article = Article.NONE,
    private val adjective: Adjective = BLANK_ADJECTIVE,
    private val value: String
): CommonNoun(
    article = article,
    adjective = adjective,
    value = value.plural()
) {
    override fun getArticle(article: Article): String {
        return if (article == Article.DEFINITE) {
            "the"
        } else {
            ""
        }
    }
}

//TODO this function don't cover all cases
fun String.plural(): String {
    val lastLetter = lowercase()[length-1]
    val penultimate = lowercase()[length-2]
    if (lastLetter == 'y' && !listVowels.contains(penultimate.toString())) {
        return replaceAfterLast("y", "ies")
    }
    return "${this}s"
}