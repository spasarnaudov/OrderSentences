package com.spascoding.feature_exam.domain.model

import com.spascoding.feature_exam.domain.enums.Tens

data class TensAccuracyInfo(
    val tens: Tens,
    val mistakesCount: Int,
    val usedCount: Int,
    val sentencesCount: Int,
)

fun List<TensAccuracyInfo>.getElementByTens(tens: Tens): TensAccuracyInfo? {
    for (item in this) {
        if (item.tens == tens) {
            return item
        }
    }
    return null
}