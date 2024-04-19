package com.spascoding.feature_exam.data.repository

import com.spascoding.feature_exam.data.data_source.StudentBook
import com.spascoding.feature_exam.domain.Tens
import com.spascoding.feature_exam.domain.model.Exam
import com.spascoding.feature_exam.domain.repository.ExamRepository

class ExamRepositoryImpl: ExamRepository {

    override fun getExam(tens: Tens): List<Exam> {
        return StudentBook.exams(tens)
    }
    
}