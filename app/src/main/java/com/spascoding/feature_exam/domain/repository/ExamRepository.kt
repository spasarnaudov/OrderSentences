package com.spascoding.feature_exam.domain.repository

import com.spascoding.feature_exam.domain.model.ExamPattern

interface ExamRepository {

    fun getExam(): List<ExamPattern>

}