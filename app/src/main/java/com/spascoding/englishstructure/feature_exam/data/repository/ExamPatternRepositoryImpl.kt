package com.spascoding.englishstructure.feature_exam.data.repository

import com.spascoding.englishstructure.feature_exam.data.data_source.StudentBook
import com.spascoding.englishstructure.feature_exam.domain.model.ExamPattern
import com.spascoding.englishstructure.feature_exam.domain.repository.ExamPatternRepository

class ExamPatternRepositoryImpl: ExamPatternRepository {

    override fun getExamPatterns(): List<ExamPattern> {
        return StudentBook.examPatterns()
    }
    
}