package com.spascoding.englishstructure.feature_exam.domain.utils

class Accuracy(
    private val mistakesCount: Int,
    private val usedCount: Int,
) {
    fun calculate(): Int {
        if (usedCount == 0) {
            return 0
        }
        if (mistakesCount == 0) {
            return 100
        }
        val percentage = 100 * (mistakesCount.toFloat() / usedCount)
        return 100 - percentage.toInt()
    }
}