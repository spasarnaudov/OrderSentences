package com.sacoding.feature_order_sentence.domain.use_case

import com.sacoding.feature_order_sentence.domain.repository.VerbRepository

class IsNotVerbsInDatabaseUseCase(
    private val repository: VerbRepository
) {

    suspend operator fun invoke(): Boolean {
        return repository.isNoVerbs()
    }

}