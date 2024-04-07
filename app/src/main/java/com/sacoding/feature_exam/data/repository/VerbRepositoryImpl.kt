package com.sacoding.feature_exam.data.repository

import com.sacoding.feature_exam.data.data_source.StudentBook
import com.sacoding.feature_exam.domain.Level
import com.sacoding.feature_exam.domain.model.Exam
import com.sacoding.feature_exam.domain.repository.VerbRepository

class VerbRepositoryImpl: VerbRepository {
    override suspend fun getExam(level: Level, index: Int): List<Exam> {
        return when (level) {
            Level.BEGINNER -> StudentBook.Exam.Beginner.presentSimple
            Level.ELEMENTARY -> StudentBook.Exam.Elementary.presentSimple
            Level.PRE_ELEMENTARY -> StudentBook.Exam.PreElementary.presentSimple
            Level.INTERMEDIATE -> StudentBook.Exam.Intermediate.presentSimple
            Level.UPPER_INTERMEDIATE -> StudentBook.Exam.UpperIntermediate.presentSimple
            Level.ADVANCED -> StudentBook.Exam.Advanced.presentSimple
            Level.PROFICIENT -> StudentBook.Exam.Proficient.presentSimple
        }
    }
}