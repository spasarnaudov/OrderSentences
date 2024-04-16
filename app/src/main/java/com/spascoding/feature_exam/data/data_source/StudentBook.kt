package com.spascoding.feature_exam.data.data_source

import com.spascoding.feature_exam.R
import com.spascoding.feature_exam.domain.Article
import com.spascoding.feature_exam.domain.Tens
import com.spascoding.feature_exam.domain.model.Exam
import com.spascoding.feature_exam.domain.model.noun.addArticle
import com.spascoding.feature_exam.domain.model.noun.build

object StudentBook {
    object Beginner {
        val exams = listOf(
            iAmAProgrammer(Tens.PRESENT_SIMPLE),
            iAmAProgrammer(Tens.PRESENT_CONTINUOUS),
            iAmAProgrammer(Tens.PRESENT_PERFECT),
            iAmAProgrammer(Tens.PRESENT_PERFECT_CONTINUOUS),

            iAmAProgrammer(Tens.PAST_SIMPLE),
            iAmAProgrammer(Tens.PAST_CONTINUOUS),
            iAmAProgrammer(Tens.PAST_PERFECT),
            iAmAProgrammer(Tens.PAST_PERFECT_CONTINUOUS),

            iAmAProgrammer(Tens.FUTURE_SIMPLE),
            iAmAProgrammer(Tens.FUTURE_CONTINUOUS),
            iAmAProgrammer(Tens.FUTURE_PERFECT),
            iAmAProgrammer(Tens.FUTURE_PERFECT_CONTINUOUS),

            iEatPizza(Tens.PRESENT_SIMPLE),
            iEatPizza(Tens.PRESENT_CONTINUOUS),
            iEatPizza(Tens.PRESENT_PERFECT),
            iEatPizza(Tens.PRESENT_PERFECT_CONTINUOUS),

            iEatPizza(Tens.PAST_SIMPLE),
            iEatPizza(Tens.PAST_CONTINUOUS),
            iEatPizza(Tens.PAST_PERFECT),
            iEatPizza(Tens.PAST_PERFECT_CONTINUOUS),

            iEatPizza(Tens.FUTURE_SIMPLE),
            iEatPizza(Tens.FUTURE_CONTINUOUS),
            iEatPizza(Tens.FUTURE_PERFECT),
            iEatPizza(Tens.FUTURE_PERFECT_CONTINUOUS),


//            Exam(
//                name = R.string.i_am_bulgarian,
//                tens = Tens.PRESENT_SIMPLE,
//                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Pronouns.names),
//                verbs = listOf(Verbs.toBe),
//                objects = Nouns.nationals.build(),
//            ),
//            Exam(
//                name = R.string.i_am_an_programmer,
//                tens = Tens.PRESENT_SIMPLE,
//                subjects = Pronouns.singular.plus(Pronouns.names),
//                verbs = listOf(Verbs.toBe),
//                objects = Nouns.jobs.addArticle(Article.INDEFINITE).build(),
//            ),
//            Exam(
//                name = R.string.i_am_from_bulgaria,
//                tens = Tens.PRESENT_SIMPLE,
//                subjects = Pronouns.singular.plus(Pronouns.names),
//                verbs = listOf(Verbs.toBe),
//                objects = Nouns.countries.addPreposition(Preposition.FROM).build(),
//            ),
//            Exam(
//                name = R.string.it_is_mine,
//                tens = Tens.PRESENT_SIMPLE,
//                subjects = listOf(Pronoun.IT),
//                verbs = listOf(Verbs.toBe),
//                objects = Pronouns.Possessive.singular
//                    .plus(Pronouns.Possessive.plural)
//                    .build(),
//            ),
//            Exam(
//                name = R.string.this_is_my_book,
//                tens = Tens.PRESENT_SIMPLE,
//                subjects = Pronouns.Demonstratives.singular,
//                verbs = listOf(Verbs.toBe),
//                objects = Nouns.thinks
//                    .addAdjective(
//                        Adjectives.Possessive.singular
//                            .plus(Adjectives.Possessive.plural)
//                            .plus(Adjectives.Possessive.name)
//                    )
//                    .build(),
//            ),
//            Exam(
//                name = R.string.these_are_my_keys,
//                tens = Tens.PRESENT_SIMPLE,
//                subjects = Pronouns.Demonstratives.plural,
//                verbs = listOf(Verbs.toBe),
//                objects = Nouns.thinks
//                    .plural()
//                    .addAdjective(
//                        Adjectives.Possessive.singular
//                            .plus(Adjectives.Possessive.plural)
//                            .plus(Adjectives.Possessive.name)
//                    ).build(),
//            ),
//            Exam(
//                name = R.string.she_loves_john,
//                tens = Tens.PRESENT_SIMPLE,
//                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Pronouns.names),
//                verbs = listOf(Verbs.love),
//                objects = Pronouns.names.plus(Pronouns.Objects.singular)
//                    .plus(Pronouns.Objects.plural).build(),
//            ),
        )
    }

    fun iAmAProgrammer(tens: Tens): Exam {
        return Exam(
            name = R.string.i_am_an_programmer,
            tens = tens,
            subjects = Pronouns.singular.plus(Pronouns.names),
            verbs = listOf(Verbs.toBe),
            objects = Nouns.jobs.addArticle(Article.INDEFINITE).build(),
        )
    }

    fun iEatPizza(tens: Tens): Exam {
        return Exam(
            name = R.string.i_eat_pizza,
            tens = tens,
            subjects = Pronouns.singular
                .plus(Pronouns.plural)
                .plus(Pronouns.names),
            verbs = listOf(Verbs.eat),
            objects = listOf(Nouns.pizza).build(),
        )
    }
}