package com.sacoding.feature_exam.domain.model.noun

class SingularPronoun(
    private val value: Values,
    private val preposition: String = "",
) : Pronoun(value.value, preposition) {

    enum class Values(val value: String) {
        I("I"),
        YOU("you"),
        HE("he"),
        SHE("she"),
        IT("it"),
    }

    override fun isThirdPerson(): Boolean {
        return value != Values.I
            && value != Values.YOU
    }

    companion object {
        val I = SingularPronoun(SingularPronoun.Values.I)
        val YOU = SingularPronoun(SingularPronoun.Values.YOU)
        val HE = SingularPronoun(SingularPronoun.Values.HE)
        val SHE = SingularPronoun(SingularPronoun.Values.SHE)
        val IT = SingularPronoun(SingularPronoun.Values.IT)
    }
}