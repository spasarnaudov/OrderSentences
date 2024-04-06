package com.sacoding.feature_exam.domain.use_case

import com.sacoding.feature_exam.domain.model.Exam
import com.sacoding.feature_exam.domain.repository.VerbRepository

class GetLessenUseCase(
    private val repository: VerbRepository
) {

    suspend operator fun invoke(): Exam {
        return repository.getLessen(0)
    }

}