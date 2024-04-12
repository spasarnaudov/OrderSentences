package com.sacoding.feature_exam.domain.model.verb

class RegularVerb(
    override val baseForm: String,
): Verb(
    baseForm = baseForm,
    pastTense = baseForm.toPast(),
    pastParticiple = baseForm.toPast(),
)

fun String.toPast(): String {
    if (lowercase().endsWith("e")) {
        return "${this}d"
    }
    if (lowercase().endsWith("y")) {
        return "${substring(0, length-1)}ied"
    }
    return "${this}ed"
}