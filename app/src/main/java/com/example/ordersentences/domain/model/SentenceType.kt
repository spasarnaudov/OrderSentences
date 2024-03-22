package com.example.ordersentences.domain.model

enum class SentenceType {
    PASS_POSITIVE,
    PASS_NEGATIVE,
    PASS_QUESTION,

    PRESENT_POSITIVE,
    PRESENT_NEGATIVE,
    PRESENT_QUESTION,

    PRESENT_CONTINUOUS_POSITIVE,
    PRESENT_CONTINUOUS_NEGATIVE,
    PRESENT_CONTINUOUS_QUESTION,

    FUTURE_POSITIVE,
    FUTURE_NEGATIVE,
    FUTURE_QUESTION;

    override fun toString(): String {
        return when (this) {
            PASS_POSITIVE -> "Past Positive sentence"
            PASS_NEGATIVE -> "Past Negative sentence"
            PASS_QUESTION -> "Past Question sentence"

            PRESENT_POSITIVE -> "Present Positive sentence"
            PRESENT_NEGATIVE -> "Present Negative sentence"
            PRESENT_QUESTION -> "Present Question sentence"

            PRESENT_CONTINUOUS_POSITIVE -> "Present continuous Positive sentence"
            PRESENT_CONTINUOUS_NEGATIVE -> "Present continuous Negative sentence"
            PRESENT_CONTINUOUS_QUESTION -> "Present continuous Question sentence"

            FUTURE_POSITIVE -> "Future Positive sentence"
            FUTURE_NEGATIVE -> "Future Negative sentence"
            FUTURE_QUESTION -> "Future Question sentence"
        }
    }
}