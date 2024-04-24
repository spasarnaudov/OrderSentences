package com.spascoding.feature_exam.domain.use_case

import com.spascoding.feature_exam.domain.model.ExamPattern
import com.spascoding.feature_exam.domain.repository.ExamRepository
import javax.inject.Inject

class GetExamUseCase @Inject constructor(
    private val repository: ExamRepository
) {

    operator fun invoke(): List<ExamPattern> {
        return repository.getExam()
    }

}