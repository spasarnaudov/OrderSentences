package com.example.ordersentences.domain.use_case

import com.example.ordersentences.domain.repository.VerbRepository

class GetSubjectUseCase(
    private val repository: VerbRepository
) {

    operator fun invoke(): String {
        val subjectsNames: List<String> = listOf(
            "John",
        )
        var subjects: List<String> = listOf(
            "I",
            "you",
            "he",
            "she",
            "it",
            "we",
            "you",
            "they",
        )
        return subjects.plus(subjectsNames).random()
    }

}