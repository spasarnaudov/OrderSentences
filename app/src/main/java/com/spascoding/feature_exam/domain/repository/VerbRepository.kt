package com.spascoding.feature_exam.domain.repository

import com.spascoding.feature_exam.domain.Level
import com.spascoding.feature_exam.domain.model.Exam

interface VerbRepository {
    suspend fun getExam(level: Level, index: Int): List<Exam>
}