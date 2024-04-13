package com.sacoding.feature_exam.data.data_source

import com.sacoding.feature_exam.domain.model.noun.Pronoun

object Pronouns {

    val singular = listOf(
        Pronoun.I,
        Pronoun.YOU,
        Pronoun.HE,
        Pronoun.SHE,
        Pronoun.IT,
    )

    val plural = listOf(
        Pronoun.WE,
        Pronoun.YOU,
        Pronoun.THEY,
    )

    val names = listOf(
        Pronoun("John"),
        Pronoun("Emily")
    )

    object Demonstratives {
        val singular = listOf(
            Pronoun.THIS,
            Pronoun.THAT,
        )
        val plural = listOf(
            Pronoun.THESE,
            Pronoun.THOSE,
        )
    }

    object Possessive {
        val singular = listOf(
            Pronoun.MINE,
            Pronoun.YOURS,
            Pronoun.HIS,
            Pronoun.HERS,
//            "-",
        )
        val plural = listOf(
            Pronoun.OURS,
            Pronoun.YOURS,
            Pronoun.THEIRS,
        )
    }

    object Objects {
        val singular = listOf(
            Pronoun.ME,
            Pronoun.YOU,
            Pronoun.HIM,
            Pronoun.HER,
            Pronoun.IT,
        )
        val plural = listOf(
            Pronoun.US,
            Pronoun.YOU,
            Pronoun.THEM,
        )
    }

    val reciprocal = listOf(
        Pronoun.EACH_OTHER,
        Pronoun.ONE_ANOTHER,
    )

    /**
     * We use indefinite pronouns to refer to people or things without saying exactly who or what they are.
     * We use pronouns ending in -body or -one for people, and pronouns ending in -thing for things.
     */
    object Indefinite {
        val body = listOf(
            Pronoun.ANYBODY,
            Pronoun.EVERYBODY,
            Pronoun.NOBODY,
            Pronoun.SOMEBODY,
        )
        val one = listOf(
            Pronoun.ANYONE,
            Pronoun.EVERYONE,
            Pronoun.NO_ONE,
            Pronoun.SOMEONE,
        )
        val thing = listOf(
            Pronoun.ANYTHING,
            Pronoun.EVERYTHING,
            Pronoun.NOTHING,
            Pronoun.SOMETHING,
        )
    }

}