package com.sacoding.feature_order_sentence.domain.repository

import com.sacoding.feature_order_sentence.domain.model.Lessen
import com.sacoding.feature_order_sentence.domain.model.Verb

interface VerbRepository {
    suspend fun upsertVerb(verb: Verb)
    suspend fun insertVerbs(verbs: List<Verb>)
    suspend fun getVerbAndIncrementUsageCount(): Verb
    suspend fun getLessen(index: Int): Lessen
    suspend fun isNoVerbs(): Boolean
}