package com.example.ordersentences.domain.use_case

import com.example.ordersentences.domain.model.Verb
import com.example.ordersentences.domain.repository.VerbRepository

class GetAllVerbsUseCase(
    private val repository: VerbRepository
) {

    suspend operator fun invoke(): List<Verb> {
        return repository.getVerbs()
    }

}