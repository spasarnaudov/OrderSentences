package com.example.ordersentences.data.data_source

import com.example.ordersentences.domain.model.Verb

object Dictionary {
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

    val objects: Map<String, List<String>> = mapOf(
        "cook" to listOf("fish", "meat", "vegetables"),
        "sell" to listOf("books", "house", "computers"),
        "take" to listOf("rest", "meat", "vegetables"),
        "buy" to listOf("phone", "car", "speakers"),
        "sell" to listOf("books", "house", "computers"),
        "take" to listOf("rest", "meat", "vegetables"),
        "throw" to listOf("stone", "ball", "shoes"),
        "write" to listOf("book", "note", "text"),
        "ride" to listOf("bike", "horse", "motorcycle"),
        "read" to listOf("book", "text", "message"),
    )

}