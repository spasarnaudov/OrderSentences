package com.spascoding.feature_exam.domain.use_case

import com.spascoding.feature_exam.data.repository.ExamRepositoryImpl
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.info
import com.spascoding.feature_exam.domain.repository.ExamRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetInitialDataUseCaseTest {

    private lateinit var repository: ExamRepository

    @Before
    fun setup() {
        repository = ExamRepositoryImpl()
    }

    @Test
    fun getBeginnerData() = runBlocking {
        val data = GetExamUseCase(repository).invoke(Tens.PRESENT_SIMPLE)
        for (exam in data) {
            for (value in exam.info()) {
                println(value)
            }
        }
    }

}