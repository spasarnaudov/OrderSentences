package com.sacoding.feature_exam.domain.model.noun

import com.sacoding.feature_exam.domain.Plurality

abstract class Noun(
    open val countable: Boolean,
    open val plurality: Plurality,
) {

    abstract fun build(): String

    open fun isThirdPerson(): Boolean {
        return true
    }

}