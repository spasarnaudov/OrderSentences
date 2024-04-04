package com.sacoding.feature_order_sentence.domain.use_case

import com.sacoding.feature_order_sentence.domain.model.Verb
import com.sacoding.feature_order_sentence.domain.repository.VerbRepository

class UploadVerbsToDBUseCase(
    private val repository: VerbRepository
) {

    suspend operator fun invoke(verbs: List<Verb>) {
        repository.insertVerbs(verbs)
    }

}