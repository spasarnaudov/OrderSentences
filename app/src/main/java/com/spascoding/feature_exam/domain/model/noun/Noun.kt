package com.spascoding.feature_exam.domain.model.noun

import com.spascoding.feature_exam.domain.enums.Plurality
import com.spascoding.feature_exam.domain.model.Preposition

abstract class Noun(
    open val countable: Boolean,
    open val plurality: Plurality,
    open var preposition: Preposition,
) {

    abstract fun build(): String

    open fun isThirdPerson(): Boolean {
        return true
    }

}

fun List<Noun>.addPreposition(preposition: Preposition): List<Noun> {
    for (item in this) {
        item.preposition = preposition
    }
    return this
}

fun List<Noun>.build(): List<String> {
    return this.map { noun ->
        noun.build()
    }
}