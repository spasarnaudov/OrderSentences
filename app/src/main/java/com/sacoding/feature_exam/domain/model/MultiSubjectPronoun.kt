package com.sacoding.feature_exam.domain.model

open class MultiSubjectPronoun(
    private val subjectPronouns: List<Noun>,
): Pronoun(toSubjectPronounValue(subjectPronouns))

fun toSubjectPronounValue(pronouns: List<Noun>): String {
    return buildString {
        pronouns.forEachIndexed() { i, noun ->
            append(noun.build())
            if (i == pronouns.size - 2) {
                append(" and ")
            } else if (i < pronouns.size - 2) {
                append(", ")
            }
        }
    }
}