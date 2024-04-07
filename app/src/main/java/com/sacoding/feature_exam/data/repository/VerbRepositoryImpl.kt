package com.sacoding.feature_exam.data.repository

import com.sacoding.feature_exam.data.data_source.StudentBook
import com.sacoding.feature_exam.data.data_source.VerbDao
import com.sacoding.feature_exam.domain.Level
import com.sacoding.feature_exam.domain.model.Exam
import com.sacoding.feature_exam.domain.model.Verb
import com.sacoding.feature_exam.domain.repository.VerbRepository

class VerbRepositoryImpl(
    private val dao: VerbDao
): VerbRepository {
    override suspend fun upsertVerb(verb: Verb) {
        return dao.upsertVerb(verb)
    }

    override suspend fun insertVerbs(verbs: List<Verb>) {
        return dao.insertVerbs(*verbs.toTypedArray())
    }

    override suspend fun getVerbAndIncrementUsageCount(): Verb {
        return dao.getVerbAndIncrementUsageCount()
    }

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

    override suspend fun isNoVerbs(): Boolean {
        return dao.countRows() == 0
    }

}