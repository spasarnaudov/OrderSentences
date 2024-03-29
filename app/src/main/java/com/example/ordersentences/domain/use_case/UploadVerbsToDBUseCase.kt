package com.example.ordersentences.domain.use_case

import com.example.ordersentences.domain.model.Verb
import com.example.ordersentences.domain.repository.VerbRepository

class UploadVerbsToDBUseCase(
    private val repository: VerbRepository
) {

    suspend operator fun invoke(verbs: List<Verb>) {
        repository.insertVerbs(verbs)
    }

}