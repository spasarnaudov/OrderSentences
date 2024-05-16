package com.spascoding.englishstructure.feature_exam.domain.enums

enum class Tense(val value: String, val int: Int) {
    PAST_SIMPLE("past simple", 1),                                  //(A1)
    PAST_CONTINUOUS("past continuous", 3),                          //(A2)
    PAST_PERFECT("past perfect", 7),                                //(B2)
    PAST_PERFECT_CONTINUOUS("Past perfect continuous", 10),         //(C1)

    PRESENT_SIMPLE("present simple", 0),                            //(A1)
    PRESENT_CONTINUOUS("present continuous", 2),                    //(A2)
    PRESENT_PERFECT("present perfect", 5),                          //(B1)
    PRESENT_PERFECT_CONTINUOUS("present perfect continuous", 9),    //(C1)

    FUTURE_SIMPLE("future simple", 4),                              //(A2)
    FUTURE_CONTINUOUS("future continuous", 6),                      //(B1)
    FUTURE_PERFECT("future perfect", 8),                            //(B2)
    FUTURE_PERFECT_CONTINUOUS("future perfect continuous", 11);     //(C2)

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