package com.spascoding.englishstructure.feature_exam.domain.model

import com.spascoding.englishstructure.feature_exam.domain.enums.Tens
import com.spascoding.englishstructure.feature_exam.domain.utils.Accuracy

val SuccessTensAccuracyInfo = TensAccuracyInfo(
    tens = Tens.PRESENT_SIMPLE,
    mistakesCount = 20,
    usedCount = 100,
    sentencesCount = 5,
)

data class TensAccuracyInfo(
    val tens: Tens,
    val mistakesCount: Int,
    val usedCount: Int,
    val sentencesCount: Int,
) {
    fun accuracy(): Int {
        return Accuracy(mistakesCount, usedCount).calculate()
    }

    operator fun compareTo(tensAccuracyInfo: TensAccuracyInfo): Int {
        return accuracy() - tensAccuracyInfo.accuracy()
    }
}

fun List<TensAccuracyInfo>.getElementByTens(tens: Tens): TensAccuracyInfo? {
    for (item in this) {
        if (item.tens == tens) {
            return item
        }
    }
    return null
}