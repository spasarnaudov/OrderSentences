package com.sacoding.feature_exam.domain.model.noun

class PluralPronoun(
    private val value: Values,
    private val preposition: String = "",
): Pronoun(value.value, preposition) {
    enum class Values(val value: String) {
        WE("we"),
        YOU("you"),
        THEY("they"),
    }

    override fun isThirdPerson(): Boolean {
        return false
    }

    companion object {
        val WE = PluralPronoun(PluralPronoun.Values.WE)
        val YOU = PluralPronoun(PluralPronoun.Values.YOU)
        val THEY = PluralPronoun(PluralPronoun.Values.THEY)
    }
}

