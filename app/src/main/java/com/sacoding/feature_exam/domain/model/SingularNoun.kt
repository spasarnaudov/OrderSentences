package com.sacoding.feature_exam.domain.model

class SingularNoun(
    value: String
): Noun(
    value = value
) {
    override fun getArticle(definiteArticle: Boolean): String {
        return if (definiteArticle) {
            return "the"
        } else if (listVowels.contains(value.lowercase()[0].toString())) {
            return "an"
        } else {
            return "a"
        }
    }
}