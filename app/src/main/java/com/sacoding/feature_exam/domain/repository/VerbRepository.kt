package com.sacoding.feature_exam.domain.repository

import com.sacoding.feature_exam.domain.Level
import com.sacoding.feature_exam.domain.model.Exam

interface VerbRepository {
    suspend fun getExam(level: Level, index: Int): List<Exam>
}