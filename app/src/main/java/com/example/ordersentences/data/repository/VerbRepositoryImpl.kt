package com.example.ordersentences.data.repository

import com.example.ordersentences.data.data_source.StudentBook
import com.example.ordersentences.data.data_source.VerbDao
import com.example.ordersentences.domain.model.Lessen
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

    override suspend fun getVerbAndIncrementUsageCount(): Verb {
        return dao.getVerbAndIncrementUsageCount()
    }

    override suspend fun getLessen(index: Int): Lessen {
        return StudentBook.presentSimpleLessens[index]
    }

    override suspend fun isNoVerbs(): Boolean {
        return dao.countRows() == 0
    }

}