package com.spascoding.feature_exam.domain.repository

import com.spascoding.feature_exam.domain.model.ExamPattern

interface ExamPatternRepository {

    fun getExamPatterns(): List<ExamPattern>

}