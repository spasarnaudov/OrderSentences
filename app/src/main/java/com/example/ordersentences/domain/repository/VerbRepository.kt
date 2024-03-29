package com.example.ordersentences.domain.repository

import com.example.ordersentences.domain.model.Verb

interface VerbRepository {
    suspend fun upsertVerb(verb: Verb)
    suspend fun insertVerbs(verbs: List<Verb>)
    suspend fun getVerbs(): List<Verb>
    suspend fun getVerbAndIncrementUsageCount(): Verb
    suspend fun getObjects(verb: String): List<String>?
    suspend fun getSubjects(): List<String>
    suspend fun isNoVerbs(): Boolean
}