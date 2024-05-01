package com.spascoding.feature_exam.domain.utils

import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.TensAccuracyInfo
import com.spascoding.feature_exam.domain.model.getElementByTens

class TensLocker {
    companion object {
        fun isTensUnlocked(currentTens: Tens, tensesAccuracyInfo: List<TensAccuracyInfo>): Boolean {
            if (Tens.PRESENT_SIMPLE == currentTens) {
                return true
            }
            for (tens in Tens.entries) {
                if (tens.int < currentTens.int) {
                    if (getProgress(tens, tensesAccuracyInfo) < 80) {
                        return false
                    }
                }
            }
            return true
        }

        fun getProgress(tens: Tens, tensesAccuracyInfo: List<TensAccuracyInfo>): Int {
            val tensAccuracyInfo = tensesAccuracyInfo.getElementByTens(tens)
            if (tensAccuracyInfo != null) {
                return calculateAccuracy(
                    tensAccuracyInfo.mistakesCount,
                    tensAccuracyInfo.usedCount
                )
            }
            return 0
        }

        fun calculateAccuracy(
            mistakesCounts: Int,
            usedCount: Int,
        ): Int {
            if (usedCount == 0) {
                return 0
            }
            if (mistakesCounts == 0) {
                return 100
            }
            val percentage = 100 * (mistakesCounts.toFloat() / usedCount)
            return 100 - percentage.toInt()
        }
    }
}