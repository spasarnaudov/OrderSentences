package com.example.ordersentences.data.data_source

import com.example.ordersentences.domain.model.Verb

object Verbs {

    val toBe = Verb("to be", "", "")
    val `do` = Verb("do", "did", "done")

    val countriesAndCities: List<Verb> = listOf(
        Verb("live", "lived", "lived"),
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