package com.example.ordersentences.domain.use_case

import com.example.ordersentences.data.VerbDao
import com.example.ordersentences.domain.model.Verb

class LoadAllVerbsUseCase(
    private val dao: VerbDao
) {

    suspend operator fun invoke(): List<Verb> {
        return dao.getVerbs()
    }

}