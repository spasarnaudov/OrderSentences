package com.sacoding.feature_exam.data.data_source

import com.sacoding.feature_exam.domain.Level
import com.sacoding.feature_exam.domain.Tens
import com.sacoding.feature_exam.domain.model.Exam
import com.sacoding.feature_exam.domain.model.addArticle

object StudentBook {
    object Exam {
        val presentSimple = listOf(
            Exam(
                name = "Where are you from?",
                level = Level.BEGINNER,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.Subject.singular.plus(Pronouns.Subject.plural).plus(Pronouns.Subject.names),
                verbs = listOf(Verbs.toBe),
                prepositions = Prepositions.originOrSourceOfMovement,
                objectVals = Objects.countries,
            ),
            Exam(
                name = "She is American.",
                level = Level.BEGINNER,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.Subject.singular.plus(Pronouns.Subject.plural).plus(Pronouns.Subject.names),
                verbs = listOf(Verbs.toBe),
                objectVals = Objects.nationals,
            ),
            Exam(
                name = "Where do you live?",
                level = Level.BEGINNER,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.Subject.singular.plus(Pronouns.Subject.plural).plus(Pronouns.Subject.names),
                verbs = Verbs.countriesAndCities,
                prepositions = Prepositions.enclosedSpaces,
                objectVals = Objects.cities,
            ),
            Exam(
                name = "She love John?",
                level = Level.BEGINNER,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.Subject.singular.plus(Pronouns.Subject.plural),
                verbs = Verbs.feelings,
                objectVals = Pronouns.Subject.names,
            ),
            Exam(
                name = "What is your job?",
                level = Level.BEGINNER,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.Subject.singular.plus(Pronouns.Subject.names),
                verbs = listOf(Verbs.toBe),
                objectVals = Objects.jobs.addArticle(),
            ),
        )
    }
}