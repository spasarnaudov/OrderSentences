package com.spascoding.feature_exam.domain

enum class Tens(val value: String, val int: Int) {
    PAST_SIMPLE("Past simple", 0),
    PAST_CONTINUOUS("Past continuous", 1),
    PAST_PERFECT("Past perfect", 2),
    PAST_PERFECT_CONTINUOUS("Past perfect continuous", 3),

    PRESENT_SIMPLE("Present simple", 4),
    PRESENT_CONTINUOUS("Present continuous", 5),
    PRESENT_PERFECT("Present perfect", 6),
    PRESENT_PERFECT_CONTINUOUS("Present perfect continuous", 7),

    FUTURE_SIMPLE("Future simple", 8),
    FUTURE_CONTINUOUS("Future continuous", 9),
    FUTURE_PERFECT("Future perfect", 10),
    FUTURE_PERFECT_CONTINUOUS("Future perfect continuous", 11);

    companion object {
        fun fromString(name: String): Tens {
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

        fun fromInt(int: Int): Tens {
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