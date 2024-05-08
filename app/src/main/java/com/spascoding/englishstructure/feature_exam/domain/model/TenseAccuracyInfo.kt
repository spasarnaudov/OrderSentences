package com.spascoding.englishstructure.feature_exam.domain.model

import com.spascoding.englishstructure.feature_exam.domain.enums.Tense
import com.spascoding.englishstructure.feature_exam.domain.utils.Accuracy

data class TenseAccuracyInfo(
    val tense: Tense,
    val mistakesCount: Int,
    val usedCount: Int,
    val sentencesCount: Int,
    val topicsAccuracyInfo: List<TopicAccuracyInfo>,
) {
    fun accuracy(): Int {
        return Accuracy(mistakesCount, usedCount).calculate()
    }

    operator fun compareTo(tenseAccuracyInfo: TenseAccuracyInfo): Int {
        return accuracy() - tenseAccuracyInfo.accuracy()
    }
}

fun List<TenseAccuracyInfo>.getElementByTense(tense: Tense): TenseAccuracyInfo? {
    for (item in this) {
        if (item.tense == tense) {
            return item
        }
    }
    return null
}