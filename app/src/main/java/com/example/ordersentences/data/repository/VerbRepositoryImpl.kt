package com.example.ordersentences.data.repository

import com.example.ordersentences.data.data_source.VerbDao
import com.example.ordersentences.domain.model.Verb
import com.example.ordersentences.domain.repository.VerbRepository

class VerbRepositoryImpl(
    private val dao: VerbDao
): VerbRepository {
    override suspend fun upsertVerb(verb: Verb) {
        return dao.upsertVerb(verb)
    }

    override suspend fun insertVerbs(verbs: List<Verb>) {
        return dao.insertVerbs(*verbs.toTypedArray())
    }

    override suspend fun getVerbs(): List<Verb> {
        return dao.getVerbs()
    }

    override suspend fun getVerbAndIncrementUsageCount(): Verb {
        return dao.getVerbAndIncrementUsageCount()
    }

    override suspend fun isNoVerbs(): Boolean {
        return dao.countRows() == 0
    }

}