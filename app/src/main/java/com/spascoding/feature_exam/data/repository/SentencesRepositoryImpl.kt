package com.spascoding.feature_exam.data.repository

import com.spascoding.feature_exam.data.data_source.StudentBook
import com.spascoding.feature_exam.domain.model.Exam
import com.spascoding.feature_exam.domain.repository.SentencesRepository

class SentencesRepositoryImpl(

): SentencesRepository {
    override suspend fun getExam(): List<Exam> {
        return StudentBook.Beginner.exams
    }
}