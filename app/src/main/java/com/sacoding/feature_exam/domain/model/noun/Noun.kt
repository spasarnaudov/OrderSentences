package com.sacoding.feature_exam.domain.model.noun

abstract class Noun {

    abstract fun build(): String

    open fun isThirdPerson(): Boolean {
        return true
    }

}