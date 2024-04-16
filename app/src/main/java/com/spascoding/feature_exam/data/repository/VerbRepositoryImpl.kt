package com.spascoding.feature_exam.data.repository

import com.spascoding.feature_exam.data.data_source.StudentBook
import com.spascoding.feature_exam.domain.model.Exam
import com.spascoding.feature_exam.domain.repository.VerbRepository

class VerbRepositoryImpl: VerbRepository {
    override suspend fun getExam(index: Int): List<Exam> {
        return StudentBook.Beginner.exams
    }
}