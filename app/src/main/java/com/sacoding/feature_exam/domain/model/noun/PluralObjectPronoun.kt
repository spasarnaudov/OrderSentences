package com.sacoding.feature_exam.domain.model.noun

class PluralObjectPronoun(
    private val value: String
) : Pronoun(value = value) {

    companion object {
        val US = PluralObjectPronoun("us")
        val YOU = PluralObjectPronoun("you")
        val THEM = PluralObjectPronoun("them")
    }

}