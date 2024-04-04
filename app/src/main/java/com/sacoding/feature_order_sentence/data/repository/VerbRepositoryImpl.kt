package com.sacoding.feature_order_sentence.data.repository

import com.sacoding.feature_order_sentence.data.data_source.StudentBook
import com.sacoding.feature_order_sentence.data.data_source.VerbDao
import com.sacoding.feature_order_sentence.domain.model.Lessen
import com.sacoding.feature_order_sentence.domain.model.Verb
import com.sacoding.feature_order_sentence.domain.repository.VerbRepository

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