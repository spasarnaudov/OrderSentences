package com.spascoding.feature_exam.domain.use_case

import com.spascoding.feature_exam.domain.model.ExamPattern
import com.spascoding.feature_exam.domain.repository.ExamPatternRepository
import javax.inject.Inject

class GetExamPatternsUseCase @Inject constructor(
    private val repository: ExamPatternRepository
) {

    operator fun invoke(): List<ExamPattern> {
        return repository.getExamPatterns()
    }

}