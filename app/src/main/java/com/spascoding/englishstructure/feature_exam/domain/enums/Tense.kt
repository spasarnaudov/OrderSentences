package com.spascoding.englishstructure.feature_exam.domain.enums

import androidx.compose.ui.graphics.Color
import com.spascoding.englishstructure.core.constants.Colors

enum class Tense(val value: String, val int: Int, val color: Color) {
    PAST_SIMPLE("past simple", 1, Colors.Blue),                                 //(A1)
    PAST_CONTINUOUS("past continuous", 3, Colors.Blue),                         //(A2)
    PAST_PERFECT("past perfect", 7, Colors.Blue),                               //(B2)
    PAST_PERFECT_CONTINUOUS("Past perfect continuous", 10, Colors.Blue),        //(C1)

    PRESENT_SIMPLE("present simple", 0, Colors.Yellow),                         //(A1)
    PRESENT_CONTINUOUS("present continuous", 2, Colors.Yellow),                 //(A2)
    PRESENT_PERFECT("present perfect", 5, Colors.Yellow),                       //(B1)
    PRESENT_PERFECT_CONTINUOUS("present perfect continuous", 9, Colors.Yellow), //(C1)

    FUTURE_SIMPLE("future simple", 4, Colors.Red),                              //(A2)
    FUTURE_CONTINUOUS("future continuous", 6, Colors.Red),                      //(B1)
    FUTURE_PERFECT("future perfect", 8, Colors.Red),                            //(B2)
    FUTURE_PERFECT_CONTINUOUS("future perfect continuous", 11, Colors.Red);     //(C2)

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

fun Tense.getPreviewsTense(): Tense {
    var previewTense = Tense.PAST_SIMPLE
    for (currentTense in Tense.entries.sortedBy { it.int }) {
        if (currentTense == this) {
            break
        }
        previewTense = currentTense
    }
    return previewTense
}