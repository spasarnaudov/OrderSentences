package com.example.ordersentences.domain.use_case

import com.example.ordersentences.domain.repository.VerbRepository

class GetObjectUseCase(
    private val repository: VerbRepository
) {

    operator fun invoke(verb: String): String {
        val verbs: List<String> =
            when (verb) {
                "cook" -> listOf("fish", "meat", "vegetables")
                "buy" -> listOf("phone", "car", "speakers")
                "sell" -> listOf("books", "house", "computers")
                "take" -> listOf("rest", "meat", "vegetables")
                "throw" -> listOf("stone", "ball", "shoes")
                "write" -> listOf("book", "note", "text")
                "ride" -> listOf("bike", "horse", "motorcycle")
                "read" -> listOf("book", "text", "message")
                else -> listOf()
            }
        return verbs.random()
    }

}