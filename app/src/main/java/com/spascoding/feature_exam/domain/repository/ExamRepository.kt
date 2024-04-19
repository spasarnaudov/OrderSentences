package com.spascoding.feature_exam.domain.repository

import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.Exam

interface ExamRepository {

    fun getExam(tens: Tens): List<Exam>

}