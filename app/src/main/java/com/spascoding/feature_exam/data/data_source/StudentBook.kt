package com.spascoding.feature_exam.data.data_source

import com.spascoding.feature_exam.R
import com.spascoding.feature_exam.domain.Article
import com.spascoding.feature_exam.domain.Level
import com.spascoding.feature_exam.domain.SentenceType
import com.spascoding.feature_exam.domain.Tens
import com.spascoding.feature_exam.domain.model.Exam
import com.spascoding.feature_exam.domain.model.Preposition
import com.spascoding.feature_exam.domain.model.noun.Pronoun
import com.spascoding.feature_exam.domain.model.noun.addAdjective
import com.spascoding.feature_exam.domain.model.noun.addArticle
import com.spascoding.feature_exam.domain.model.noun.addPreposition
import com.spascoding.feature_exam.domain.model.noun.build
import com.spascoding.feature_exam.domain.model.noun.plural

object StudentBook {
    object Beginner {
        val exams = listOf(
            Exam(
                name = R.string.i_am_bulgarian,
                level = Level.BEGINNER,
                tens = Tens.PRESENT_SIMPLE,
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Pronouns.names),
                verbs = listOf(Verbs.toBe),
                objects = Nouns.nationals.build(),
            ),
            Exam(
                name = R.string.i_am_an_programmer,
                level = Level.BEGINNER,
                tens = Tens.PRESENT_SIMPLE,
                subjects = Pronouns.singular.plus(Pronouns.names),
                verbs = listOf(Verbs.toBe),
                objects = Nouns.jobs.addArticle(Article.INDEFINITE).build(),
            ),
            Exam(
                name = R.string.i_am_from_bulgaria,
                level = Level.BEGINNER,
                tens = Tens.PRESENT_SIMPLE,
                subjects = Pronouns.singular.plus(Pronouns.names),
                verbs = listOf(Verbs.toBe),
                objects = Nouns.countries.addPreposition(Preposition.FROM).build(),
            ),
            Exam(
                name = R.string.it_is_mine,
                level = Level.BEGINNER,
                sentenceTypes = SentenceType.entries,
                tens = Tens.PRESENT_SIMPLE,
                subjects = listOf(Pronoun.IT),
                verbs = listOf(Verbs.toBe),
                objects = Pronouns.Possessive.singular
                    .plus(Pronouns.Possessive.plural)
                    .build(),
            ),
            Exam(
                name = R.string.this_is_my_book,
                level = Level.BEGINNER,
                tens = Tens.PRESENT_SIMPLE,
                subjects = Pronouns.Demonstratives.singular,
                verbs = listOf(Verbs.toBe),
                objects = Nouns.thinks
                    .addAdjective(
                        Adjectives.Possessive.singular
                            .plus(Adjectives.Possessive.plural)
                            .plus(Adjectives.Possessive.name)
                    )
                    .build(),
            ),
            Exam(
                name = R.string.these_are_my_keys,
                level = Level.BEGINNER,
                tens = Tens.PRESENT_SIMPLE,
                subjects = Pronouns.Demonstratives.plural,
                verbs = listOf(Verbs.toBe),
                objects = Nouns.thinks
                    .plural()
                    .addAdjective(
                        Adjectives.Possessive.singular
                            .plus(Adjectives.Possessive.plural)
                            .plus(Adjectives.Possessive.name)
                    ).build(),
            ),
            Exam(
                name = R.string.she_loves_john,
                level = Level.BEGINNER,
                tens = Tens.PRESENT_SIMPLE,
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Pronouns.names),
                verbs = listOf(Verbs.love),
                objects = Pronouns.names.plus(Pronouns.Objects.singular)
                    .plus(Pronouns.Objects.plural).build(),
            ),
            Exam(
                name = R.string.i_eat_pizza,
                level = Level.BEGINNER,
                tens = Tens.PRESENT_SIMPLE,
                subjects = Pronouns.singular
                    .plus(Pronouns.plural)
                    .plus(Pronouns.names),
                verbs = listOf(Verbs.eat),
                objects = listOf(Nouns.pizza).build(),
            ),
        )
    }

    object Elementary {
//        val exams = listOf(
//            Exam(
//                name = R.string.the_room_is_small,
//                level = Level.ELEMENTARY,
//                tenses = listOf(Tens.PRESENT_SIMPLE, Tens.PAST_SIMPLE),
//                subjects = Objects.home.addArticle(),
//                verbs = listOf(Verbs.toBe),
//                objectVals = Adjectives.size,
//            ),
//            Exam(
//                name = R.string.the_soup_was_delicious,
//                level = Level.ELEMENTARY,
//                tenses = listOf(Tens.PRESENT_SIMPLE, Tens.PAST_SIMPLE),
//                subjects = Objects.food.addArticle(),
//                verbs = listOf(Verbs.toBe),
//                objectVals = Adjectives.taste,
//            ),
//            Exam(
//                name = R.string.this_hat_is_beautiful,
//                level = Level.ELEMENTARY,
//                tenses = listOf(Tens.PRESENT_SIMPLE, Tens.PAST_SIMPLE),
//                subjects = Objects.food.addArticle(),
//                verbs = listOf(Verbs.toBe),
//                objectVals = Adjectives.taste,
//            ),
//        )
    }

    object Intermediate {
        val exams = listOf(
            Exam(
                name = R.string.they_help_each_other,
                level = Level.INTERMEDIATE,
                tens = Tens.PAST_SIMPLE,
                subjects = Pronouns.plural,
                verbs = Verbs.mutualOrReciprocalActions,
                objects = Pronouns.reciprocal.build(),
            ),
        )
    }

    object UpperIntermediate {
        val exams = listOf(
            Exam(
                name = R.string.i_am_from_bulgaria,
                level = Level.UPPER_INTERMEDIATE,
                tens = Tens.PRESENT_SIMPLE,
                subjects = Pronouns.singular
                    .plus(Pronouns.plural)
                    .plus(Pronouns.names),
                verbs = listOf(Verbs.toBe),
                objects = Nouns.countries.build(),
            ),
        )
    }

    object Advanced {
        val exams = listOf(
            Exam(
                name = R.string.i_am_from_bulgaria,
                level = Level.ADVANCED,
                tens = Tens.PRESENT_SIMPLE,
                subjects = Pronouns.singular
                    .plus(Pronouns.plural)
                    .plus(Pronouns.names),
                verbs = listOf(Verbs.toBe),
                objects = Nouns.countries.build(),
            ),
        )
    }

    object Proficient {
        val exams = listOf(
            Exam(
                name = R.string.i_am_from_bulgaria,
                level = Level.PROFICIENT,
                tens = Tens.PRESENT_SIMPLE,
                subjects = Pronouns.singular
                    .plus(Pronouns.plural)
                    .plus(Pronouns.names),
                verbs = listOf(Verbs.toBe),
                objects = Nouns.countries.build(),
            ),
        )
    }
}