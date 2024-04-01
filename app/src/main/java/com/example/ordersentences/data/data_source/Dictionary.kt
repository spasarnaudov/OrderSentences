package com.example.ordersentences.data.data_source

import com.example.ordersentences.domain.model.Verb

object Dictionary {
    val toBeVerb = Verb("to be", "", "")
    val doVerb = Verb("do", "did", "done")

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

    val objectsFood: List<String> = listOf(
        "fish", "meat", "vegetables"
    )

    val objectsThinks: List<String> = listOf(
        "book", "house", "computer", "phone", "car", "speakers"
    )

    val subjectsNames: List<String> = listOf(
        "John",
        "Emily",
    )

    val subjects: List<String> = listOf(
        "I",
        "you",
        "he",
        "she",
        "it",
        "we",
        "you",
        "they",
    )

}