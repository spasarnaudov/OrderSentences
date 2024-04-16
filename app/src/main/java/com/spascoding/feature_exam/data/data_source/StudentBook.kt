package com.spascoding.feature_exam.data.data_source

import com.spascoding.feature_exam.R
import com.spascoding.feature_exam.domain.Article
import com.spascoding.feature_exam.domain.Level
import com.spascoding.feature_exam.domain.SentenceType
import com.spascoding.feature_exam.domain.Tens
import com.spascoding.feature_exam.domain.model.Exam
import com.spascoding.feature_exam.domain.NounAdapter
import com.spascoding.feature_exam.domain.model.noun.Pronoun
import com.spascoding.feature_exam.domain.model.noun.addArticle
import com.spascoding.feature_exam.domain.model.noun.addPossessiveAdjective
import com.spascoding.feature_exam.domain.model.noun.plural

object StudentBook {
    object Beginner {
        val exams = listOf(
            Exam(
                name = R.string.i_am_bulgarian,
                level = Level.BEGINNER,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.singular
                    .plus(Pronouns.plural)
                    .plus(Pronouns.names),
                verbs = listOf(Verbs.toBe),
                objects = NounAdapter(Nouns.nationals).build(),
            ),
            Exam(
                name = R.string.i_am_an_programmer,
                level = Level.BEGINNER,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.singular
                    .plus(Pronouns.names),
                verbs = listOf(Verbs.toBe),
                objects = NounAdapter(Nouns.jobs.addArticle(Article.INDEFINITE)).build(),
            ),
            Exam(
                name = R.string.i_am_from_bulgaria,
                level = Level.BEGINNER,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.singular
                        .plus(Pronouns.names)
                ,
                verbs = listOf(Verbs.toBe),
                objects = NounAdapter(Nouns.countries).build(),
            ),
//            Exam(
//                name = R.string.who_are_you_meeting,
//                level = Level.BEGINNER,
//                sentenceTypes = listOf(SentenceType.QUESTION),
//                tenses = listOf(Tens.PRESENT_SIMPLE),
//                subjects = Pronouns.singular
//                        .plus(Pronouns.plural)
//                        .plus(Pronouns.names)
//                ,
////                questionWord = "Who",
//                verbs = listOf(Verbs.toBe),
//                objectVals = listOf("meeting"),
//            ),
//            Exam(
//                name = R.string.where_is_she_from,
//                level = Level.BEGINNER,
//                sentenceTypes = listOf(SentenceType.QUESTION),
//                tenses = listOf(Tens.PRESENT_SIMPLE),
//                subjects = Pronouns.singular
//                        .plus(Pronouns.plural)
//                        .plus(Pronouns.names)
//                ,
////                questionWord = "Where",
//                verbs = listOf(Verbs.toBe),
//                objectVals = listOf("from"),
//            ),
//            Exam(
//                name = R.string.when_are_they_arriving,
//                level = Level.BEGINNER,
//                sentenceTypes = listOf(SentenceType.QUESTION),
//                tenses = listOf(Tens.PRESENT_SIMPLE),
//                subjects = Pronouns.singular.plus(Pronouns.plural)
//                        .plus(Pronouns.names)
//                ,
////                questionWord = "When",
//                verbs = listOf(Verbs.toBe),
//                objectVals = listOf("arriving"),
//            ),
            Exam(
                name = R.string.it_is_mine,
                level = Level.BEGINNER,
                sentenceTypes = SentenceType.entries,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = listOf(Pronoun.IT),
                verbs = listOf(Verbs.toBe),
                objects = NounAdapter(
                    Pronouns.Possessive.singular
                        .plus(Pronouns.Possessive.plural)
                ).build(),
            ),
            Exam(
                name = R.string.this_is_my_book,
                level = Level.BEGINNER,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.Demonstratives.singular,
                verbs = listOf(Verbs.toBe),
                objects = NounAdapter(
                    Nouns.thinks
                        .addPossessiveAdjective(
                            Adjectives.Possessive.singular
                                .plus(Adjectives.Possessive.plural)
                                .plus(Adjectives.Possessive.name)
                        )
                ).build(),
            ),
            Exam(
                name = R.string.these_are_my_keys,
                level = Level.BEGINNER,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.Demonstratives.plural,
                verbs = listOf(Verbs.toBe),
                objects = NounAdapter(
                    Nouns.thinks
                        .plural()
                        .addPossessiveAdjective(
                            Adjectives.Possessive.singular
                                .plus(Adjectives.Possessive.plural)
                                .plus(Adjectives.Possessive.name)
                        )
                ).build(),
            ),
            Exam(
                name = R.string.she_loves_john,
                level = Level.BEGINNER,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Pronouns.names),
                verbs = listOf(Verbs.love),
                objects = NounAdapter(Pronouns.names.plus(Pronouns.Objects.singular.plus(Pronouns.Objects.plural))).build(),
            ),
            Exam(
                name = R.string.i_eat_pizza,
                level = Level.BEGINNER,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.singular
                    .plus(Pronouns.plural)
                    .plus(Pronouns.names),
                verbs = listOf(Verbs.eat),
                objects = NounAdapter(Nouns.pizza).build(),
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
                tenses = listOf(Tens.PRESENT_SIMPLE, Tens.PAST_SIMPLE),
                subjects = Pronouns.plural,
                verbs = Verbs.mutualOrReciprocalActions,
                objects = NounAdapter(Pronouns.reciprocal).build(),
            ),
        )
    }

    object UpperIntermediate {
        val exams = listOf(
            Exam(
                name = R.string.i_am_from_bulgaria,
                level = Level.UPPER_INTERMEDIATE,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.singular
                        .plus(Pronouns.plural)
                        .plus(Pronouns.names)
                ,
                verbs = listOf(Verbs.toBe),
                objects = NounAdapter(Nouns.countries).build(),
            ),
        )
    }

    object Advanced {
        val exams = listOf(
            Exam(
                name = R.string.i_am_from_bulgaria,
                level = Level.ADVANCED,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.singular
                        .plus(Pronouns.plural)
                        .plus(Pronouns.names)
                ,
                verbs = listOf(Verbs.toBe),
                objects = NounAdapter(Nouns.countries).build(),
            ),
        )
    }

    object Proficient {
        val exams = listOf(
            Exam(
                name = R.string.i_am_from_bulgaria,
                level = Level.PROFICIENT,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.singular
                        .plus(Pronouns.plural)
                        .plus(Pronouns.names)
                ,
                verbs = listOf(Verbs.toBe),
                objects = NounAdapter(Nouns.countries).build(),
            ),
        )
    }
}