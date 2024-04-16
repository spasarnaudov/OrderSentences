package com.spascoding.feature_exam.data.data_source

import com.spascoding.feature_exam.R
import com.spascoding.feature_exam.domain.Article
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
                tens = Tens.PRESENT_SIMPLE,
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Pronouns.names),
                verbs = listOf(Verbs.toBe),
                objects = Nouns.nationals.build(),
            ),
            Exam(
                name = R.string.i_am_an_programmer,
                tens = Tens.PRESENT_SIMPLE,
                subjects = Pronouns.singular.plus(Pronouns.names),
                verbs = listOf(Verbs.toBe),
                objects = Nouns.jobs.addArticle(Article.INDEFINITE).build(),
            ),
            Exam(
                name = R.string.i_am_from_bulgaria,
                tens = Tens.PRESENT_SIMPLE,
                subjects = Pronouns.singular.plus(Pronouns.names),
                verbs = listOf(Verbs.toBe),
                objects = Nouns.countries.addPreposition(Preposition.FROM).build(),
            ),
            Exam(
                name = R.string.it_is_mine,
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
                tens = Tens.PRESENT_SIMPLE,
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Pronouns.names),
                verbs = listOf(Verbs.love),
                objects = Pronouns.names.plus(Pronouns.Objects.singular)
                    .plus(Pronouns.Objects.plural).build(),
            ),
            Exam(
                name = R.string.i_eat_pizza,
                tens = Tens.PRESENT_SIMPLE,
                subjects = Pronouns.singular
                    .plus(Pronouns.plural)
                    .plus(Pronouns.names),
                verbs = listOf(Verbs.eat),
                objects = listOf(Nouns.pizza).build(),
            ),
        )
    }

    object Intermediate {
        val exams = listOf(
            Exam(
                name = R.string.they_help_each_other,
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