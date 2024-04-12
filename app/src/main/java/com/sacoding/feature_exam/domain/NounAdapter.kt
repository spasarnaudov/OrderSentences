package com.sacoding.feature_exam.domain

import com.sacoding.feature_exam.domain.model.noun.Noun

data class NounAdapter(private val nouns: List<Noun>) {

    constructor(noun: Noun) : this(listOf(noun))

    fun build(): List<String> {
        return nouns.map { noun ->
            noun.build()
        }
    }
}