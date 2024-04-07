package com.sacoding.feature_exam.domain

import com.sacoding.core.presentation.SegmentedButtonItem

enum class Level(val text: String, val code: String) {
    BEGINNER("Beginner", "A0"),
    ELEMENTARY("Elementary", "A1"),
    PRE_ELEMENTARY("Pre-elementary", "A2"),
    INTERMEDIATE("Intermediate", "B1"),
    UPPER_INTERMEDIATE("Upper intermediate", "B2"),
    ADVANCED("Advance", "C1"),
    PROFICIENT("Proficient", "C2"),
}

fun toSegmentedItem(level: Level): SegmentedButtonItem<Level> {
    return SegmentedButtonItem(level.code, level)
}