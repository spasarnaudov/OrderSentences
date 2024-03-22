package com.example.ordersentences.domain.use_case

import com.example.ordersentences.data.VerbDao
import com.example.ordersentences.domain.model.Verb

class UploadVerbsToDBUseCase(
    private val dao: VerbDao
) {

    suspend operator fun invoke() {
        val verbs: List<Verb> = listOf(
            Verb("cook", "cooked", "cooked"),
            Verb("buy", "bought", "bought"),
            Verb("sell", "sold", "sold"),
            Verb("take", "took", "taken"),
            Verb("throw", "threw", "thrown"),
            Verb("write", "wrote", "written"),
            Verb("ride", "rode", "ridden"),
            Verb("read", "read", "read")
        )
        dao.insertVerbAll(*verbs.toTypedArray())
    }

}