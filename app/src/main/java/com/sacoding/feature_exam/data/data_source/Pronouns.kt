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
    }

    val demonstratives = listOf(
        "this",     //singular pronoun to talk about people or things near us
        "these",    //plural pronoun to talk about people or things near us
        "that",     //singular pronoun to talk about things that are not near us
        "those",    //plural pronoun to talk about things that are not near us
    )

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