package com.sacoding.feature_exam.domain.model.noun

class SingularObjectPronoun(
    private val value: String
) : Pronoun(value = value) {

    companion object {
        val ME = SingularObjectPronoun("me")
        val YOU = SingularObjectPronoun("you")
        val HIM = SingularObjectPronoun("him")
        val HER = SingularObjectPronoun("her")
        val IT = SingularObjectPronoun("it")
    }

}