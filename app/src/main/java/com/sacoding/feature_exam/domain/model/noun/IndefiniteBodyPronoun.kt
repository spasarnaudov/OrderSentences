package com.sacoding.feature_exam.domain.model.noun

class IndefiniteBodyPronoun(
    private val value: String
) : Pronoun(value = value) {
    companion object {
        val ANYBODY = IndefiniteBodyPronoun("anybody")
        val EVERYBODY = IndefiniteBodyPronoun("everybody")
        val NOBODY = IndefiniteBodyPronoun("nobody")
        val SOMEBODY = IndefiniteBodyPronoun("somebody")
    }
}