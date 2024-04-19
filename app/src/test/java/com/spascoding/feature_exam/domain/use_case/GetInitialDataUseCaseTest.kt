package com.spascoding.feature_exam.domain.use_case

import com.spascoding.feature_exam.data.repository.SentencesRepositoryImpl
import com.spascoding.feature_exam.domain.Tens
import com.spascoding.feature_exam.domain.model.info
import com.spascoding.feature_exam.domain.repository.SentencesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.Before
import org.junit.Test

class GetInitialDataUseCaseTest {

    private lateinit var repository: SentencesRepository

    @Before
    fun setup() {
        repository = SentencesRepositoryImpl()
    }

    @Test
    fun getBeginnerData() = runBlocking {
        val data = GetInitialDataUseCase(repository).invoke(Tens.PRESENT_SIMPLE)
        for (exam in data) {
            for (value in exam.info()) {
                println(value)
            }
        }
    }

}