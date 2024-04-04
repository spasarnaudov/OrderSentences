package com.sacoding.feature_order_sentence.domain.use_case

import com.sacoding.feature_order_sentence.domain.model.Lessen
import com.sacoding.feature_order_sentence.domain.repository.VerbRepository

class GetLessenUseCase(
    private val repository: VerbRepository
) {

    suspend operator fun invoke(): Lessen {
        return repository.getLessen(0)
    }

}