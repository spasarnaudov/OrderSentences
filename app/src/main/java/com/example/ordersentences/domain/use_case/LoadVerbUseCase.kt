package com.example.ordersentences.domain.use_case

import com.example.ordersentences.data.VerbDao
import com.example.ordersentences.domain.model.Verb

class LoadVerbUseCase(
    private val dao: VerbDao
) {

    suspend operator fun invoke(): Verb {
        return dao.getVerbAndIncrementUsageCount()
    }

}