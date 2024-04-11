package com.sacoding.feature_exam.domain.model

open class MultiSubjectPronoun(
    private val subjectPronouns: List<Pronoun>,
): Pronoun(toSubjectPronounValue(subjectPronouns))

fun toSubjectPronounValue(pronouns: List<Pronoun>): String {
    return buildString {
        pronouns.forEachIndexed() { i, pronoun ->
            append(pronoun.value)
            if (i == pronouns.size - 2) {
                append(" and ")
            } else if (i < pronouns.size - 2) {
                append(", ")
            }
        }
    }
}