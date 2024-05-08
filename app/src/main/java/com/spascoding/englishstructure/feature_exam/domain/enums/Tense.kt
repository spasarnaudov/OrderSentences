package com.spascoding.englishstructure.feature_exam.domain.enums

import androidx.compose.ui.graphics.Color
import com.spascoding.englishstructure.core.constants.Colors

enum class Tense(val value: String, val int: Int, val color: Color) {
    PAST_SIMPLE("Past simple (A1)", 1, Colors.Blue),
    PAST_CONTINUOUS("Past continuous (A2)", 3, Colors.Blue),
    PAST_PERFECT("Past perfect (B2)", 7, Colors.Blue),
    PAST_PERFECT_CONTINUOUS("Past perfect continuous (C1)", 10, Colors.Blue),

    PRESENT_SIMPLE("Present simple (A1)", 0, Colors.Yellow),
    PRESENT_CONTINUOUS("Present continuous (A2)", 2, Colors.Yellow),
    PRESENT_PERFECT("Present perfect (B1)", 5, Colors.Yellow),
    PRESENT_PERFECT_CONTINUOUS("Present perfect continuous (C1)", 9, Colors.Yellow),

    FUTURE_SIMPLE("Future simple (A2)", 4, Colors.Red),
    FUTURE_CONTINUOUS("Future continuous (B1)", 6, Colors.Red),
    FUTURE_PERFECT("Future perfect (B2)", 8, Colors.Red),
    FUTURE_PERFECT_CONTINUOUS("Future perfect continuous (C2)", 11, Colors.Red);

    companion object {
        fun fromString(name: String): Tense {
            if (PAST_SIMPLE.value == name) { return PAST_SIMPLE }
            if (PAST_CONTINUOUS.value == name) { return PAST_CONTINUOUS }
            if (PAST_PERFECT.value == name) { return PAST_PERFECT }
            if (PAST_PERFECT_CONTINUOUS.value == name) { return PAST_PERFECT_CONTINUOUS }

//            if (PRESENT_SIMPLE.value == name) { return PRESENT_SIMPLE }
            if (PRESENT_CONTINUOUS.value == name) { return PRESENT_CONTINUOUS }
            if (PRESENT_PERFECT.value == name) { return PRESENT_PERFECT }
            if (PRESENT_PERFECT_CONTINUOUS.value == name) { return PRESENT_PERFECT_CONTINUOUS }

            if (FUTURE_SIMPLE.value == name) { return FUTURE_SIMPLE }
            if (FUTURE_CONTINUOUS.value == name) { return FUTURE_CONTINUOUS }
            if (FUTURE_PERFECT.value == name) { return FUTURE_PERFECT }
            if (FUTURE_PERFECT_CONTINUOUS.value == name) { return FUTURE_PERFECT_CONTINUOUS }

            return PRESENT_SIMPLE
        }

        fun fromInt(int: Int): Tense {
            if (PAST_SIMPLE.int == int) { return PAST_SIMPLE }
            if (PAST_CONTINUOUS.int == int) { return PAST_CONTINUOUS }
            if (PAST_PERFECT.int == int) { return PAST_PERFECT }
            if (PAST_PERFECT_CONTINUOUS.int == int) { return PAST_PERFECT_CONTINUOUS }

//            if (PRESENT_SIMPLE.int == int) { return PRESENT_SIMPLE }
            if (PRESENT_CONTINUOUS.int == int) { return PRESENT_CONTINUOUS }
            if (PRESENT_PERFECT.int == int) { return PRESENT_PERFECT }
            if (PRESENT_PERFECT_CONTINUOUS.int == int) { return PRESENT_PERFECT_CONTINUOUS }

            if (FUTURE_SIMPLE.int == int) { return FUTURE_SIMPLE }
            if (FUTURE_CONTINUOUS.int == int) { return FUTURE_CONTINUOUS }
            if (FUTURE_PERFECT.int == int) { return FUTURE_PERFECT }
            if (FUTURE_PERFECT_CONTINUOUS.int == int) { return FUTURE_PERFECT_CONTINUOUS }

            return PRESENT_SIMPLE
        }
    }
}