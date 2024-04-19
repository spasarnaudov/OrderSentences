package com.spascoding.feature_exam.domain.repository

import com.spascoding.feature_exam.domain.Tens
import com.spascoding.feature_exam.domain.model.Exam

interface SentencesRepository {
    fun getExam(tens: Tens): List<Exam>
}