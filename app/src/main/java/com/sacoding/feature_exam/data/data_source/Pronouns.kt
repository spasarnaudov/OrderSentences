package com.sacoding.feature_exam.data.data_source

import com.sacoding.feature_exam.domain.model.noun.DemonstrativePronoun
import com.sacoding.feature_exam.domain.model.noun.IndefiniteBodyPronoun
import com.sacoding.feature_exam.domain.model.noun.IndefiniteOnePronoun
import com.sacoding.feature_exam.domain.model.noun.IndefiniteThingPronoun
import com.sacoding.feature_exam.domain.model.noun.PluralObjectPronoun
import com.sacoding.feature_exam.domain.model.noun.PluralPossessivePronoun
import com.sacoding.feature_exam.domain.model.noun.PluralPronoun
import com.sacoding.feature_exam.domain.model.noun.Pronoun
import com.sacoding.feature_exam.domain.model.noun.SingularObjectPronoun
import com.sacoding.feature_exam.domain.model.noun.SingularPossessivePronoun
import com.sacoding.feature_exam.domain.model.noun.SingularPronoun
import com.sacoding.feature_exam.domain.model.noun.SubjectPronoun

object Pronouns {

    val singular = listOf(
        SingularPronoun.I,
        SingularPronoun.YOU,
        SingularPronoun.HE,
        SingularPronoun.SHE,
        SingularPronoun.IT,
    )

    val plural = listOf(
        PluralPronoun.WE,
        PluralPronoun.YOU,
        PluralPronoun.THEY,
    )

    val names = listOf(
        SubjectPronoun("John"),
        SubjectPronoun("Emily")
    )

    object Demonstratives {
        val singular = listOf(
            DemonstrativePronoun.THIS,
            DemonstrativePronoun.THAT,
        )
        val plural = listOf(
            DemonstrativePronoun.THESE,
            DemonstrativePronoun.THOSE,
        )
    }

    object Possessive {
        val singular = listOf(
            SingularPossessivePronoun.MINE,
            SingularPossessivePronoun.YOURS,
            SingularPossessivePronoun.HIS,
            SingularPossessivePronoun.HERS,
//            "-",
        )
        val plural = listOf(
            PluralPossessivePronoun.OURS,
            PluralPossessivePronoun.YOURS,
            PluralPossessivePronoun.THEIRS,
        )
    }

    object Objects {
        val singular = listOf(
            SingularObjectPronoun.ME,
            SingularObjectPronoun.YOU,
            SingularObjectPronoun.HIM,
            SingularObjectPronoun.HER,
            SingularObjectPronoun.IT,
        )
        val plural = listOf(
            PluralObjectPronoun.US,
            PluralObjectPronoun.YOU,
            PluralObjectPronoun.THEM,
        )
    }

    val EACH_OTHER = Pronoun("each other")
    val ONE_ANOTHER = Pronoun("one another")

    val reciprocal = listOf(
        EACH_OTHER,
        ONE_ANOTHER,
    )

    /**
     * We use indefinite pronouns to refer to people or things without saying exactly who or what they are.
     * We use pronouns ending in -body or -one for people, and pronouns ending in -thing for things.
     */
    object Indefinite {
        val body = listOf(
            IndefiniteBodyPronoun.ANYBODY,
            IndefiniteBodyPronoun.EVERYBODY,
            IndefiniteBodyPronoun.NOBODY,
            IndefiniteBodyPronoun.SOMEBODY,
        )
        val one = listOf(
            IndefiniteOnePronoun.ANYONE,
            IndefiniteOnePronoun.EVERYONE,
            IndefiniteOnePronoun.NO_ONE,
            IndefiniteOnePronoun.SOMEONE,
        )
        val thing = listOf(
            IndefiniteThingPronoun.ANYTHING,
            IndefiniteThingPronoun.EVERYTHING,
            IndefiniteThingPronoun.NOTHING,
            IndefiniteThingPronoun.SOMETHING,
        )
    }

}