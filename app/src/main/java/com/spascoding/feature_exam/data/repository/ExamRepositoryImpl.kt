package com.spascoding.feature_exam.data.repository

import com.spascoding.feature_exam.data.data_source.StudentBook
import com.spascoding.feature_exam.domain.model.ExamPattern
import com.spascoding.feature_exam.domain.repository.ExamRepository

class ExamRepositoryImpl: ExamRepository {

    override fun getExam(): List<ExamPattern> {
        return StudentBook.exams()
    }
    
}