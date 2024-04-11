package com.sacoding.feature_exam.data.data_source

import com.sacoding.feature_exam.R
import com.sacoding.feature_exam.domain.Level
import com.sacoding.feature_exam.domain.SentenceType
import com.sacoding.feature_exam.domain.Tens
import com.sacoding.feature_exam.domain.model.Exam
import com.sacoding.feature_exam.domain.model.addArticle
import com.sacoding.feature_exam.domain.model.addPossessiveAdjective
import com.sacoding.feature_exam.domain.model.plural

object StudentBook {
    object Beginner {
        val exams = listOf(
            Exam(
                name = R.string.i_am_bulgarian,
                level = Level.BEGINNER,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.Subject.singular.plus(Pronouns.Subject.plural).plus(Pronouns.Subject.names),
                verbs = listOf(Verbs.toBe),
                objectVals = Objects.nationals,
            ),
            Exam(
                name = R.string.i_am_an_programmer,
                level = Level.BEGINNER,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.Subject.singular.plus(Pronouns.Subject.names),
                verbs = listOf(Verbs.toBe),
                objectVals = Objects.jobs.addArticle(),
            ),
            Exam(
                name = R.string.i_am_from_bulgaria,
                level = Level.BEGINNER,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.Subject.singular.plus(Pronouns.Subject.plural).plus(Pronouns.Subject.names),
                verbs = listOf(Verbs.toBe),
                prepositions = Prepositions.originOrSourceOfMovement,
                objectVals = Objects.countries,
            ),
            Exam(
                name = R.string.who_are_you_meeting,
                level = Level.BEGINNER,
                sentenceTypes = listOf(SentenceType.QUESTION),
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.Subject.all,
                questionWord = "Who",
                verbs = listOf(Verbs.toBe),
                objectVals = listOf("meeting"),
            ),
            Exam(
                name = R.string.where_is_she_from,
                level = Level.BEGINNER,
                sentenceTypes = listOf(SentenceType.QUESTION),
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.Subject.all,
                questionWord = "Where",
                verbs = listOf(Verbs.toBe),
                objectVals = listOf("from"),
            ),
            Exam(
                name = R.string.when_are_they_arriving,
                level = Level.BEGINNER,
                sentenceTypes = listOf(SentenceType.QUESTION),
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.Subject.all,
                questionWord = "When",
                verbs = listOf(Verbs.toBe),
                objectVals = listOf("arriving"),
            ),
            Exam(
                name = R.string.why_am_i_a_teacher,
                level = Level.BEGINNER,
                sentenceTypes = listOf(SentenceType.QUESTION),
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.Subject.all,
                questionWord = "Why",
                verbs = listOf(Verbs.toBe),
                objectVals = Objects.jobs.addArticle(),
            ),
            Exam(
                name = R.string.it_is_mine,
                level = Level.BEGINNER,
                sentenceTypes = SentenceType.entries,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = listOf("it"),
                verbs = listOf(Verbs.toBe),
                objectVals = Pronouns.PossessivePronoun.all.plus(Pronouns.PossessivePronoun.name),
            ),
            Exam(
                name = R.string.this_is_my_book,
                level = Level.BEGINNER,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.Demonstratives.singular,
                verbs = listOf(Verbs.toBe),
                objectVals = Objects.thinks.addPossessiveAdjective(Pronouns.PossessiveAdjective.all.plus(Pronouns.PossessiveAdjective.name)),
            ),
            Exam(
                name = R.string.these_are_my_keys,
                level = Level.BEGINNER,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.Demonstratives.plural,
                verbs = listOf(Verbs.toBe),
                objectVals = Objects.thinks.plural().addPossessiveAdjective(Pronouns.PossessiveAdjective.all.plus(Pronouns.PossessiveAdjective.name)),
            ),
//            Exam(
//                name = R.string.where_do_you_live,
//                level = Level.BEGINNER,
//                tenses = listOf(Tens.PRESENT_SIMPLE),
//                subjects = Pronouns.Subject.singular.plus(Pronouns.Subject.plural).plus(Pronouns.Subject.names),
//                verbs = Verbs.countriesAndCities,
//                prepositions = Prepositions.enclosedSpaces,
//                objectVals = Objects.cities,
//            ),
//            Exam(
//                name = R.string.she_love_john,
//                level = Level.BEGINNER,
//                tenses = listOf(Tens.PRESENT_SIMPLE),
//                subjects = Pronouns.Subject.singular.plus(Pronouns.Subject.plural),
//                verbs = Verbs.feelings,
//                objectVals = Pronouns.Subject.names,
//            ),
//            Exam(
//                name = R.string.what_is_your_phone_number,
//                level = Level.BEGINNER,
//                tenses = listOf(Tens.PRESENT_SIMPLE),
//                subjects = listOf("phone number").addPossessiveAdjective(Pronouns.PossessiveAdjective.all),
//                verbs = listOf(Verbs.toBe),
//                objectVals = Objects.phoneNumbers,
//            ),
//            Exam(
//                name = R.string.what_is_your_phone_number,
//                level = Level.BEGINNER,
//                tenses = listOf(Tens.PRESENT_SIMPLE),
//                subjects = listOf("phone number").addPossessiveAdjective(Pronouns.PossessiveAdjective.all),
//                verbs = listOf(Verbs.toBe),
//                objectVals = Objects.phoneNumbers,
//            ),
//            Exam(
//                name = R.string.this_is_main,
//                level = Level.BEGINNER,
//                tenses = listOf(Tens.PRESENT_SIMPLE),
//                subjects = Pronouns.Demonstratives.all.plus(Pronouns.Demonstratives.name),
//                verbs = listOf(Verbs.toBe),
//                objectVals = Pronouns.PossessivePronoun.all.plus(Pronouns.PossessivePronoun.name),
//            ),
//            Exam(
//                name = R.string.birds,
//                level = Level.BEGINNER,
//                tenses = listOf(Tens.PRESENT_SIMPLE),
//                subjects = Subjects.birds,
//                verbs = listOf(Verb("fly", "flew", "flown")),
//                prepositions = Prepositions.directionTowardsASpecificDestination,
//                objectVals = Objects.countries,
//            ),
        )
    }
    object Elementary {
        val exams = listOf(
            Exam(
                name = R.string.the_room_is_small,
                level = Level.ELEMENTARY,
                tenses = listOf(Tens.PRESENT_SIMPLE, Tens.PAST_SIMPLE),
                subjects = Objects.home.addArticle(),
                verbs = listOf(Verbs.toBe),
                objectVals = Adjectives.size,
            ),
            Exam(
                name = R.string.the_soup_was_delicious,
                level = Level.ELEMENTARY,
                tenses = listOf(Tens.PRESENT_SIMPLE, Tens.PAST_SIMPLE),
                subjects = Objects.food.addArticle(),
                verbs = listOf(Verbs.toBe),
                objectVals = Adjectives.taste,
            ),
            Exam(
                name = R.string.this_hat_is_beautiful,
                level = Level.ELEMENTARY,
                tenses = listOf(Tens.PRESENT_SIMPLE, Tens.PAST_SIMPLE),
                subjects = Objects.food.addArticle(),
                verbs = listOf(Verbs.toBe),
                objectVals = Adjectives.taste,
            ),
        )
    }
    object Intermediate {
        val exams = listOf(
            Exam(
                name = R.string.they_help_each_other,
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
                name = R.string.i_am_from_bulgaria,
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
                name = R.string.i_am_from_bulgaria,
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
                    name = R.string.i_am_from_bulgaria,
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