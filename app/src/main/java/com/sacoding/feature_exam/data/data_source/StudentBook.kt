package com.sacoding.feature_exam.data.data_source

import com.sacoding.feature_exam.domain.Level
import com.sacoding.feature_exam.domain.Tens
import com.sacoding.feature_exam.domain.model.Lessen
import com.sacoding.feature_exam.domain.model.addArticle

object StudentBook {
    val presentSimpleLessens = listOf(
        Lessen(
            name = "Where are you from?",
            level = Level.BEGINNER,
            tenses = listOf(Tens.PRESENT_SIMPLE),
            subjects = Pronouns.Subject.singular.plus(Pronouns.Subject.plural).plus(Pronouns.Subject.names),
            verbs = listOf(Verbs.toBe),
            prepositions = Prepositions.originOrSourceOfMovement,
            objectVals = Objects.countries,
        ),
        Lessen(
            name = "She is American.",
            level = Level.BEGINNER,
            tenses = listOf(Tens.PRESENT_SIMPLE),
            subjects = Pronouns.Subject.singular.plus(Pronouns.Subject.plural).plus(Pronouns.Subject.names),
            verbs = listOf(Verbs.toBe),
            objectVals = Objects.nationals,
        ),
        Lessen(
            name = "Where do you live?",
            level = Level.BEGINNER,
            tenses = listOf(Tens.PRESENT_SIMPLE),
            subjects = Pronouns.Subject.singular.plus(Pronouns.Subject.plural).plus(Pronouns.Subject.names),
            verbs = Verbs.countriesAndCities,
            prepositions = Prepositions.enclosedSpaces,
            objectVals = Objects.cities,
        ),
        Lessen(
            name = "She love John?",
            level = Level.BEGINNER,
            tenses = listOf(Tens.PRESENT_SIMPLE),
            subjects = Pronouns.Subject.singular.plus(Pronouns.Subject.plural),
            verbs = Verbs.feelings,
            objectVals = Pronouns.Subject.names,
        ),
        Lessen(
            name = "What is your job?",
            level = Level.BEGINNER,
            tenses = listOf(Tens.PRESENT_SIMPLE),
            subjects = Pronouns.Subject.singular.plus(Pronouns.Subject.names),
            verbs = listOf(Verbs.toBe),
            objectVals = Objects.jobs.addArticle(),
        ),
    )
}