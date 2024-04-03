package com.example.ordersentences.domain.repository

import com.example.ordersentences.domain.model.Lessen
import com.example.ordersentences.domain.model.Verb

interface VerbRepository {
    suspend fun upsertVerb(verb: Verb)
    suspend fun insertVerbs(verbs: List<Verb>)
    suspend fun getVerbAndIncrementUsageCount(): Verb
    suspend fun getLessen(index: Int): Lessen
    suspend fun isNoVerbs(): Boolean
}