package com.example.ordersentences.domain.use_case

import com.example.ordersentences.data.VerbDao
import com.example.ordersentences.domain.model.Verb

class IncrementVerbMistakeCountUseCase(
    private val dao: VerbDao
) {

    suspend operator fun invoke(verb: Verb) {
        val modifiedVerb = verb.copy(
            mistakeCount = verb.mistakeCount + 1
        )
        return dao.upsertVerb(modifiedVerb)
    }

}