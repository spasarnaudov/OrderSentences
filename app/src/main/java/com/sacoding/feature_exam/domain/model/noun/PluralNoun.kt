package com.sacoding.feature_exam.domain.model.noun

import com.sacoding.feature_exam.domain.Article
import com.sacoding.feature_exam.domain.model.Adjective
import com.sacoding.feature_exam.domain.model.BLANK_ADJECTIVE
import com.sacoding.feature_exam.listVowels

data class PluralNoun(
    private val value: String,
    private val article: Article = Article.NONE,
    private val adjective: Adjective = BLANK_ADJECTIVE,
    private val preposition: String = "",
): CommonNoun(
    value = value.plural(),
    article = article,
    adjective = adjective,
    preposition = preposition,
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