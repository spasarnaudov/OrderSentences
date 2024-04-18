package com.spascoding.feature_exam.domain.repository

import com.spascoding.feature_exam.domain.model.Exam

interface SentencesRepository {
    suspend fun getExam(): List<Exam>
}