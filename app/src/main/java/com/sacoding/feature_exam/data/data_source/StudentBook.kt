package com.sacoding.feature_exam.data.data_source

import com.sacoding.feature_exam.domain.Level
import com.sacoding.feature_exam.domain.SentenceType
import com.sacoding.feature_exam.domain.Tens
import com.sacoding.feature_exam.domain.model.Lessen

object StudentBook {
    val presentSimpleLessens = listOf(
        Lessen(
            name = "Where are you from?",
            level = Level.BEGINNER,
            sentenceTypes = SentenceType.entries,
            tenses = listOf(Tens.PRESENT_SIMPLE),
            subjects = Subjects.pronouns.plus(Subjects.names),
            verbs = listOf(Verbs.toBe),
            prepositions = Prepositions.originOrSourceOfMovement.plus(Prepositions.enclosedSpaces),
            objectVals = Objects.countries.plus(Objects.cities),
        ),
        Lessen(
            name = "She is American",
            level = Level.BEGINNER,
            sentenceTypes = SentenceType.entries,
            tenses = listOf(Tens.PRESENT_SIMPLE),
            subjects = Subjects.pronouns.plus(Subjects.names),
            verbs = listOf(Verbs.toBe),
            objectVals = Objects.nationals,
        ),
        Lessen(
            name = "Where are you live?",
            level = Level.BEGINNER,
            sentenceTypes = SentenceType.entries,
            tenses = listOf(Tens.PRESENT_SIMPLE),
            subjects = Subjects.pronouns.plus(Subjects.names),
            verbs = Verbs.countriesAndCities,
            prepositions = Prepositions.enclosedSpaces,
            objectVals = Objects.countries.plus(Objects.cities),
        ),
    )
}