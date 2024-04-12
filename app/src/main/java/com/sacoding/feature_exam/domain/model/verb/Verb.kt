package com.sacoding.feature_exam.domain.model.verb

abstract class Verb(
    open val baseForm: String,
    open val pastTense: String,
    open val pastParticiple: String,
)

fun Verb.getSingularPresentTenseForm(subject: String): String {
    when(subject.lowercase()) {
        "i" -> return baseForm
        "you" -> return baseForm
        "we" -> return baseForm
        "they" -> return baseForm
    }
    val isSpecialCase =
        "go" == baseForm
                || "do" == baseForm
                || baseForm.endsWith("s", true)
    return if (isSpecialCase) "${baseForm}es" else "${baseForm}s"
}

fun Verb.toContinuous(): String {
    //When the verb ends in -e, we take off the -e and add -ing.
    if (baseForm.endsWith("e")) {
        return "${baseForm.substring(0, baseForm.length-1)}ing"
    }
    //When the verb ends in a vowel + l, we double the consonant.
    if (baseForm.endsWith("l")) {
        return "${baseForm}${baseForm.last()}ing"
    }

    //When the verb ends in a vowel followed by a single consonant
    //and if the last syllable is stressed, then the consonant is doubled.
    //TODO
//    if (vowels.contains(baseForm[baseForm.length-2].toString())
//        && !vowels.contains(baseForm.last().toString())
//    ) {
//        return "${baseForm}${baseForm.last()}ing"
//    }
    return "${baseForm}ing"
}

fun toBe(subject: String): String {
    when(subject.lowercase()) {
        "i" -> return "am"
        "you" -> return "are"
        "we" -> return "are"
        "they" -> return "are"
        "these" -> return "are"
        "those" -> return "are"
    }
    return "is"
}

fun toBePast(subject: String): String {
    when(subject.lowercase()) {
        "you" -> return "were"
        "we" -> return "were"
        "they" -> return "were"
    }
    return "was"
}

fun toHave(subject: String): String {
    return when(subject.lowercase()) {
        "i", "you", "we", "they" -> "have"
        else -> "has"
    }
}