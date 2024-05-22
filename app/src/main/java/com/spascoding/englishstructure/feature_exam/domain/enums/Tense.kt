package com.spascoding.englishstructure.feature_exam.domain.enums

import androidx.compose.ui.graphics.Color
import com.spascoding.englishstructure.core.constants.Colors

enum class Tense(val value: String, val int: Int, val color: Color) {
    PAST_SIMPLE("past simple", 1, Colors.PAST),                                     //(A1)
    PAST_CONTINUOUS("past continuous", 3, Colors.PAST),                             //(A2)
    PAST_PERFECT("past perfect", 7, Colors.PAST),                                   //(B2)
    PAST_PERFECT_CONTINUOUS("Past perfect continuous", 10, Colors.PAST),            //(C1)

    PRESENT_SIMPLE("present simple", 0, Colors.PRESENT),                            //(A1)
    PRESENT_CONTINUOUS("present continuous", 2, Colors.PRESENT),                    //(A2)
    PRESENT_PERFECT("present perfect", 5, Colors.PRESENT),                          //(B1)
    PRESENT_PERFECT_CONTINUOUS("present perfect continuous", 9, Colors.PRESENT),    //(C1)

    FUTURE_SIMPLE("future simple", 4, Colors.FUTURE),                               //(A2)
    FUTURE_CONTINUOUS("future continuous", 6, Colors.FUTURE),                       //(B1)
    FUTURE_PERFECT("future perfect", 8, Colors.FUTURE),                             //(B2)
    FUTURE_PERFECT_CONTINUOUS("future perfect continuous", 11, Colors.FUTURE);      //(C2)

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