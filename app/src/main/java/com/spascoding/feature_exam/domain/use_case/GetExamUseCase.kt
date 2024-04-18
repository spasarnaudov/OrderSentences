package com.spascoding.feature_exam.domain.use_case

import com.spascoding.feature_exam.domain.model.Exam
import com.spascoding.feature_exam.domain.repository.SentencesRepository
import javax.inject.Inject

class GetExamUseCase @Inject constructor(
    private val repository: SentencesRepository
) {

    suspend operator fun invoke(): List<Exam> {
        return repository.getExam()
    }

}