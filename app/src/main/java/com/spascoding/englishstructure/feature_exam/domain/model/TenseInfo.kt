package com.spascoding.englishstructure.feature_exam.domain.model

import com.spascoding.englishstructure.feature_exam.domain.enums.Tense

data class TenseInfo(
    val tense: Int = 0,
    val accuracy: Int = 0,
    val sentenceCount: Int = 0,
)

fun List<TenseInfo>.contains(tense: Tense): Boolean {
    for (tenseInfo in this) {
        if (tenseInfo.tense == tense.int) {
            return true
        }
    }
    return false
}

fun List<TenseInfo>.getTenseInfo(tense: Tense): TenseInfo {
    for (tenseInfo in this) {
        if (tenseInfo.tense == tense.int) {
            return tenseInfo
        }
    }
    return TenseInfo()
}
