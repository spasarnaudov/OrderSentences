package com.example.ordersentences.domain.use_case

import com.example.ordersentences.domain.repository.VerbRepository

class GetSubjectUseCase(
    private val repository: VerbRepository
) {

    suspend operator fun invoke(): String {
        return repository.getSubjects().random()
    }

}