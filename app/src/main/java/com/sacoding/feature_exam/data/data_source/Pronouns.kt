package com.sacoding.feature_exam.data.data_source

import com.sacoding.feature_exam.domain.model.PluralPronoun
import com.sacoding.feature_exam.domain.model.SingularPronoun
import com.sacoding.feature_exam.domain.model.SubjectPronoun

object Pronouns {

    val singular = listOf(
        SingularPronoun(SingularPronoun.Values.I),
        SingularPronoun(SingularPronoun.Values.YOU),
        SingularPronoun(SingularPronoun.Values.HE),
        SingularPronoun(SingularPronoun.Values.SHE),
        SingularPronoun(SingularPronoun.Values.IT),
    )

    val plural = listOf(
        PluralPronoun(PluralPronoun.Values.WE),
        PluralPronoun(PluralPronoun.Values.YOU),
        PluralPronoun(PluralPronoun.Values.THEY),
    )

    val names = listOf(
        SubjectPronoun("John"),
        SubjectPronoun("Emily")
    )

    object Demonstratives {
        val singular = listOf(
            SubjectPronoun("this"),     //singular pronoun to talk about people or things near us
            SubjectPronoun("that"),     //singular pronoun to talk about things that are not near us
        )

        val plural = listOf(
            SubjectPronoun("these"),    //plural pronoun to talk about people or things near us
            SubjectPronoun("those"),    //plural pronoun to talk about things that are not near us
        )

        val name = listOf(
            SubjectPronoun("John's"),
            SubjectPronoun("Emily's"),
        )
    }

    object Possessive {
        val singular = listOf(
            SubjectPronoun("mine"),
            SubjectPronoun("yours"),
            SubjectPronoun("his"),
            SubjectPronoun("hers"),
//            "-",
        )

        val plural = listOf(
            SubjectPronoun("ours"),
            SubjectPronoun("yours"),
            SubjectPronoun("theirs"),
        )

        val name = listOf(
            SubjectPronoun("John's"),
            SubjectPronoun("Emily's"),
        )
    }

    //TODO
    object Objects {
        val singular = listOf(
            "me",
            "you",
            "him",
            "her",
            "it",
        )

        val plural = listOf(
            "us",
            "you",
            "them",
        )
    }

    val reciprocal = listOf(
        "each other",
        "one another",
    )

    /**
     * We use indefinite pronouns to refer to people or things without saying exactly who or what they are.
     * We use pronouns ending in -body or -one for people, and pronouns ending in -thing for things.
     */
    object Indefinite {
        val body = listOf(
            "anybody",
            "everybody",
            "nobody",
            "somebody",
        )

        val one = listOf(
            "anyone",
            "everyone",
            "no one",
            "someone",
        )

        val thing = listOf(
            "anything",
            "everything",
            "nothing",
            "something",
        )
    }

}