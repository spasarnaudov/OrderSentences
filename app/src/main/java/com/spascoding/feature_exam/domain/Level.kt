package com.spascoding.feature_exam.domain

import com.spascoding.core.presentation.SegmentedButtonItem

enum class Level(val text: String, val code: String) {
    BEGINNER("Beginner", "A1"),
    ELEMENTARY("Elementary", "A2"),
    INTERMEDIATE("Intermediate", "B1"),
    UPPER_INTERMEDIATE("Upper intermediate", "B2"),
    ADVANCED("Advance", "C1"),
    PROFICIENT("Proficient", "C2"),
}

fun toSegmentedItem(level: Level): SegmentedButtonItem<Level> {
    return SegmentedButtonItem(level.code, level)
}