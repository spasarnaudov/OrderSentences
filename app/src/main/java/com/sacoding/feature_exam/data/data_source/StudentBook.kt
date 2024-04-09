package com.sacoding.feature_exam.data.data_source

import com.sacoding.feature_exam.domain.Level
import com.sacoding.feature_exam.domain.Tens
import com.sacoding.feature_exam.domain.model.Exam
import com.sacoding.feature_exam.domain.model.addArticle

object StudentBook {
    object Beginner {
        val exams = listOf(
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
    object Elementary {
        val exams = listOf(
            Exam(
                name = "Distances",
                level = Level.ELEMENTARY,
                tenses = listOf(Tens.PRESENT_SIMPLE, Tens.PAST_SIMPLE),
                subjects = listOf(
                    "Birmingham"
                ),
                verbs = listOf(Verbs.toBe),
                prepositions = listOf(
                    "250 kilometres from",
                    "250 kilometres away from",
                ),
                objectVals = listOf(
                    "London"
                ),
            ),
            Exam(
                name = "Where are you from?",
                level = Level.ELEMENTARY,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.Subject.singular.plus(Pronouns.Subject.plural).plus(Pronouns.Subject.names),
                verbs = listOf(Verbs.toBe),
                prepositions = Prepositions.originOrSourceOfMovement,
                objectVals = Objects.countries,
            ),
        )
    }
    object Intermediate {
        val exams = listOf(
            Exam(
                name = "They help each other",
                level = Level.INTERMEDIATE,
                tenses = listOf(Tens.PRESENT_SIMPLE, Tens.PAST_SIMPLE),
                subjects = Pronouns.Subject.plural,
                verbs = Verbs.mutualOrReciprocalActions,
                objectVals = Pronouns.reciprocal,
            ),
        )
    }
    object UpperIntermediate {
        val exams = listOf(
            Exam(
                name = "Where are you from?",
                level = Level.UPPER_INTERMEDIATE,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.Subject.singular.plus(Pronouns.Subject.plural).plus(Pronouns.Subject.names),
                verbs = listOf(Verbs.toBe),
                prepositions = Prepositions.originOrSourceOfMovement,
                objectVals = Objects.countries,
            ),
        )
    }
    object Advanced {
        val exams = listOf(
            Exam(
                name = "Where are you from?",
                level = Level.ADVANCED,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.Subject.singular.plus(Pronouns.Subject.plural).plus(Pronouns.Subject.names),
                verbs = listOf(Verbs.toBe),
                prepositions = Prepositions.originOrSourceOfMovement,
                objectVals = Objects.countries,
            ),
        )
    }
    object Proficient {
            val exams = listOf(
                Exam(
                    name = "Where are you from?",
                    level = Level.PROFICIENT,
                    tenses = listOf(Tens.PRESENT_SIMPLE),
                    subjects = Pronouns.Subject.singular.plus(Pronouns.Subject.plural).plus(Pronouns.Subject.names),
                    verbs = listOf(Verbs.toBe),
                    prepositions = Prepositions.originOrSourceOfMovement,
                    objectVals = Objects.countries,
                ),
            )
        }
}