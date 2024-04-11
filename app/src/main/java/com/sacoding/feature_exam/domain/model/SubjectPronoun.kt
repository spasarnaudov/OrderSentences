package com.sacoding.feature_exam.domain.model

open class SubjectPronoun(
    private val value: String,
    private val preposition: String = "",
): Pronoun(value, preposition)