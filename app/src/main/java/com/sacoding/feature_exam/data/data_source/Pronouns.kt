package com.sacoding.feature_exam.data.data_source

object Pronouns {

    object Subject {
        val names = listOf(
            "John",
            "Emily",
        )

        val singular = listOf(
            "I",
            "you",
            "he",
            "she",
            "it",
        )

        val plural = listOf(
            "we",
            "you",
            "they",
        )

        val all = singular.plus(plural)
    }

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

        val all = singular.plus(plural)
    }

    object PossessiveAdjective {
        val singular = listOf(
            "my",
            "your",
            "his",
            "her",
            "its",
        )

        val plural = listOf(
            "our",
            "your",
            "their",
        )

        val name = listOf(
            "John's",
            "Emily's",
        )

        val all = singular.plus(plural)
    }

    object PossessivePronoun {
        val singular = listOf(
            "mine",
            "yours",
            "his",
            "hers",
//            "-",
        )

        val plural = listOf(
            "ours",
            "yours",
            "theirs",
        )

        val name = listOf(
            "John's",
            "Emily's",
        )

        val all = singular.plus(plural)
    }

    object Demonstratives {
        val singular = listOf(
            "this",     //singular pronoun to talk about people or things near us
            "that",     //singular pronoun to talk about things that are not near us
        )

        val plural = listOf(
            "these",    //plural pronoun to talk about people or things near us
            "those",    //plural pronoun to talk about things that are not near us
        )

        val name = listOf(
            "John's",
            "Emily's",
        )

        val all = singular.plus(plural)
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