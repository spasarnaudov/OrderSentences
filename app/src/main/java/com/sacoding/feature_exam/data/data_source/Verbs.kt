package com.sacoding.feature_exam.data.data_source

import com.sacoding.feature_exam.domain.model.Verb

object Verbs {

    val toBe = Verb("to be", "", "")
    val `do` = Verb("do", "did", "done")

    val countriesAndCities: List<Verb> = listOf(
        Verb("live", "lived", "lived"),
    )

    val feelings: List<Verb> = listOf(
        Verb("love", "loved", "loved"),
        Verb("like", "liked", "liked"),
        Verb("hate", "hated", "hated"),
        Verb("know", "knew", "known"),
        Verb("trust", "trusted", "trusted"),
    )

    val mutualOrReciprocalActions = listOf(
        Verb("help", "helped", "helped"),
        Verb("understand", "understood", "understood"),
        Verb("respect", "respected", "respected"),
        Verb("trust", "trusted", "trusted"),
        Verb("greet", "greeted", "greeted"),
        Verb("learn", "learned", "learned"),
        Verb("listen", "listened", "listened"),
        Verb("support", "supported", "supported"),
//        Verb("teach", "taught", "taught"),
//        Verb("forgive", "forgave", "forgiven"),
//        Verb("meet", "met", "met"),
//        Verb("know", "knew", "known"),
    )

    val levelOneVerbs: List<Verb> = listOf(
        Verb("cook", "cooked", "cooked"),
    )

    val levelTwoVerbs: List<Verb> = listOf(
        Verb("buy", "bought", "bought"),
        Verb("sell", "sold", "sold"),
        Verb("take", "took", "taken"),
        Verb("throw", "threw", "thrown"),
        Verb("write", "wrote", "written"),
        Verb("ride", "rode", "ridden"),
        Verb("read", "read", "read")
    )

}