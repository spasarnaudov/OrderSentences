package com.sacoding.feature_exam.domain.model

import com.sacoding.feature_exam.domain.Article

class SingularNoun(
    value: String
): CommonNoun(
    value = value
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
}