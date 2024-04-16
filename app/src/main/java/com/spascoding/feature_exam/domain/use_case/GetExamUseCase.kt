package com.spascoding.feature_exam.domain.use_case

import com.spascoding.feature_exam.domain.Level
import com.spascoding.feature_exam.domain.model.Exam
import com.spascoding.feature_exam.domain.repository.VerbRepository

class GetExamUseCase(
    private val repository: VerbRepository
) {

    suspend operator fun invoke(level: Level): List<Exam> {
        return repository.getExam(level, 0)
    }

}