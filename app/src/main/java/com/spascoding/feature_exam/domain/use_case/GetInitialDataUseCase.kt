package com.spascoding.feature_exam.domain.use_case

import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.Exam
import com.spascoding.feature_exam.domain.repository.ExamRepository

class GetInitialDataUseCase(
    private val repository: ExamRepository
) {
    suspend operator fun invoke(tens: Tens): List<Exam> {
        return repository.getExam(tens)
    }
}