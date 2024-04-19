package com.spascoding.feature_exam.domain.use_case

import com.spascoding.feature_exam.domain.Tens
import com.spascoding.feature_exam.domain.model.Exam
import com.spascoding.feature_exam.domain.repository.SentencesRepository

class GetInitialDataUseCase(
    private val repository: SentencesRepository
) {
    suspend operator fun invoke(tens: Tens): List<Exam> {
        return repository.getExam(tens)
    }
}