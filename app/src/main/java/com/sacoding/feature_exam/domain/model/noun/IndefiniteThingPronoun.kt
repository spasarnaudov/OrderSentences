package com.sacoding.feature_exam.domain.model.noun

class IndefiniteThingPronoun(
    private val value: String
) : Pronoun(value = value) {
    companion object {
        val ANYTHING = IndefiniteThingPronoun("anything")
        val EVERYTHING = IndefiniteThingPronoun("everything")
        val NOTHING = IndefiniteThingPronoun("nothing")
        val SOMETHING = IndefiniteThingPronoun("something")
    }
}