package com.example.ordersentences.domain.use_case

import com.example.ordersentences.domain.model.Lessen
import com.example.ordersentences.domain.repository.VerbRepository

class GetLessenUseCase(
    private val repository: VerbRepository
) {

    suspend operator fun invoke(): Lessen {
        return repository.getLessen(0)
    }

}