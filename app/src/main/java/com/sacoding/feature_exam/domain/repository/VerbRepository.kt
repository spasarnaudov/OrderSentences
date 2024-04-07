package com.sacoding.feature_exam.domain.repository

import com.sacoding.feature_exam.domain.Level
import com.sacoding.feature_exam.domain.model.Exam
import com.sacoding.feature_exam.domain.model.Verb

interface VerbRepository {
    suspend fun upsertVerb(verb: Verb)
    suspend fun insertVerbs(verbs: List<Verb>)
    suspend fun getVerbAndIncrementUsageCount(): Verb
    suspend fun getExam(level: Level, index: Int): List<Exam>
    suspend fun isNoVerbs(): Boolean
}