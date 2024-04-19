package com.spascoding.feature_exam.domain.use_case

import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.Exam
import com.spascoding.feature_exam.domain.repository.ExamRepository
import javax.inject.Inject

class GetExamUseCase @Inject constructor(
    private val repository: ExamRepository
) {

    operator fun invoke(tens: Tens): List<Exam> {
        return repository.getExam(tens)
    }

}