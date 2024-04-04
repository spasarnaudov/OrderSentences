package com.sacoding.feature_order_sentence.domain.use_case

import com.sacoding.feature_order_sentence.domain.model.Verb
import com.sacoding.feature_order_sentence.domain.repository.VerbRepository

class IncrementVerbMistakeCountUseCase(
    private val repository: VerbRepository
) {

    suspend operator fun invoke(verb: Verb) {
        val modifiedVerb = verb.copy(
            mistakeCount = verb.mistakeCount + 1
        )
        return repository.upsertVerb(modifiedVerb)
    }

}