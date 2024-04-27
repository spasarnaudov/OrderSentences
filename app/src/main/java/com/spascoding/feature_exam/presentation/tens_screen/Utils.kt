package com.spascoding.feature_exam.presentation.tens_screen

fun calculateAccuracy(
    mistakesCounts: Int = 0,
    useCount: Int = 0,
): Int {
    if (useCount == 0) {
        return 0
    }
    if (mistakesCounts == 0) {
        return 100
    }
    val percentage = 100 * (mistakesCounts.toFloat() / useCount)
    return 100 - percentage.toInt()
}