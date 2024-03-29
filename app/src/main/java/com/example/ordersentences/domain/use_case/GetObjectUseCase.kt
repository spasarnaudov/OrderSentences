package com.example.ordersentences.domain.use_case

import com.example.ordersentences.domain.repository.VerbRepository

class GetObjectUseCase(
    private val repository: VerbRepository
) {

    suspend operator fun invoke(verb: String): String {
        return repository.getObjects(verb)?.random() ?: ""
    }

}