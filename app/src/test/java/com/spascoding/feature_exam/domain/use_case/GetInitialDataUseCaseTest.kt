package com.spascoding.feature_exam.domain.use_case

import com.spascoding.feature_exam.data.repository.SentencesRepositoryImpl
import com.spascoding.feature_exam.domain.Tens
import com.spascoding.feature_exam.domain.model.info
import com.spascoding.feature_exam.domain.repository.SentencesRepository
import org.junit.Before
import org.junit.Test

class GetInitialDataUseCaseTest {

    private lateinit var repository: SentencesRepository

    @Before
    fun setup() {
        repository = SentencesRepositoryImpl()
    }

    @Test
    fun getBeginnerData() {
        val data = GetInitialDataUseCase(repository).invoke(Tens.PRESENT_SIMPLE)
        for (exam in data) {
            for (value in exam.info()) {
                println(value)
            }
        }
    }

}