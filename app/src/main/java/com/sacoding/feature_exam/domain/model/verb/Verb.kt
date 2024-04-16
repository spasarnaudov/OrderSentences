package com.sacoding.feature_exam.domain.model.verb

import com.sacoding.feature_exam.data.data_source.Verbs
import com.sacoding.feature_exam.domain.model.noun.Noun
import com.sacoding.feature_exam.listVowels

class Verb(
    val baseForm: String,
    val pastTense: String = baseForm.toPast(),
    val pastParticiple: String = baseForm.toPast(),
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

fun Verb.adaptToSubject(subject: Noun): String {
    return if (subject.isThirdPerson()) {
        thirdPerson()
    } else {
        baseForm
    }
}

fun Verb.thirdPerson(): String {
    if (this == Verbs.have) {
        return "has"
    }

    if (baseForm.endsWith("ch")
        || baseForm.endsWith("sh")
        || baseForm.endsWith("s")
        || baseForm.endsWith("x")
        || baseForm.endsWith("z")
    ) {
        return "${baseForm}es"
    }

    val lastLetter = baseForm.lowercase()[baseForm.length-1]
    val penultimate = baseForm.lowercase()[baseForm.length-2]
    val isPenultimateVowel = listVowels.contains(penultimate.toString())

    if (lastLetter == 'y' && !isPenultimateVowel) {
        return "${baseForm.substring(0, baseForm.length-1)}ies"
    }

    if (lastLetter == 'o' && !isPenultimateVowel) {
        return "${baseForm}es"
    }

    return "${baseForm}s"
}

fun Verb.toContinuous(): String {
    //When the verb ends in -e, we take off the -e and add -ing.
    if (baseForm.endsWith("e")) {
        return "${baseForm.substring(0, baseForm.length - 1)}ing"
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

//TODO must be create verb
fun toBe(subject: String): String {
    when (subject.lowercase()) {
        "i" -> return "am"
        "you" -> return "are"
        "we" -> return "are"
        "they" -> return "are"
        "these" -> return "are"
        "those" -> return "are"
    }
    return "is"
}

//TODO must be create verb
fun toBePast(subject: String): String {
    when (subject.lowercase()) {
        "you" -> return "were"
        "we" -> return "were"
        "they" -> return "were"
    }
    return "was"
}