package com.sacoding.feature_exam.domain.model.noun

open class SubjectPronoun(
    private val value: String,
    private val preposition: String = "",
): Pronoun(value, preposition)