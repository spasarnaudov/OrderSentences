package com.sacoding.feature_exam.data.repository

import com.sacoding.feature_exam.data.data_source.StudentBook
import com.sacoding.feature_exam.domain.Level
import com.sacoding.feature_exam.domain.model.Exam
import com.sacoding.feature_exam.domain.repository.VerbRepository

class VerbRepositoryImpl: VerbRepository {
    override suspend fun getExam(level: Level, index: Int): List<Exam> {
        return when (level) {
            Level.BEGINNER -> StudentBook.Beginner.exams
            Level.ELEMENTARY -> StudentBook.Beginner.exams
            Level.INTERMEDIATE -> StudentBook.Intermediate.exams
            Level.UPPER_INTERMEDIATE -> StudentBook.UpperIntermediate.exams
            Level.ADVANCED -> StudentBook.Advanced.exams
            Level.PROFICIENT -> StudentBook.Proficient.exams
        }
    }
}