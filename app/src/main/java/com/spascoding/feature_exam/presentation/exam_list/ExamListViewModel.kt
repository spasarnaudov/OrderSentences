package com.spascoding.feature_exam.presentation.exam_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.spascoding.feature_exam.data.repository.SharedPreferencesRepositoryImpl
import com.spascoding.feature_exam.domain.MIN_COUNT_SENTECES
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.use_case.ExamUseCases
import com.spascoding.feature_exam.domain.utils.SentencesGenerator
import com.spascoding.feature_exam.presentation.tens_screen.calculateAccuracy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class ExamListViewModel @Inject constructor(
    private val examUseCases: ExamUseCases,
    private val sharedPreferencesRepository: SharedPreferencesRepositoryImpl,
) : ViewModel() {

    private val _state = mutableStateOf(ExamListViewModelState())
    val state: State<ExamListViewModelState> = _state

    init {
        _state.value = state.value.copy(
            tens = sharedPreferencesRepository.getSelectedTens(),
        )
        saveSentencesToDatabase(state.value.tens).also {
            getExams(state.value.tens)
        }

        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                val mistakesCounts = examUseCases.getMistakesCountsUseCase.invoke(MIN_COUNT_SENTECES)
                val usedCountUseCase = examUseCases.getUsedCountUseCase.invoke(MIN_COUNT_SENTECES)
                val sentencesCounts = examUseCases.getSentencesCountsUseCase.invoke()
                withContext(Dispatchers.Main) {
                    _state.value = state.value.copy(
                        mistakesCounts = mistakesCounts,
                        usedCountUseCase = usedCountUseCase,
                        sentencesCounts = sentencesCounts,
                    )
                }
            }
        }
    }

    fun onEvent(event: ExamListEvent) {
        when (event) {
            is ExamListEvent.SelectExam -> {

            }
            is ExamListEvent.SelectExamInfo -> {

            }
            is ExamListEvent.SelectTens -> {
                sharedPreferencesRepository.setSelectedTens(event.tens)
                _state.value = state.value.copy(
                    tens = event.tens,
                )

                saveSentencesToDatabase(state.value.tens).also {
                    getExams(state.value.tens)
                }
            }
        }
    }

    private fun saveSentencesToDatabase(tens: Tens) {
        GlobalScope.launch {
            var examNames: List<String>
            withContext(Dispatchers.IO) {
                val examPatterns = examUseCases.getExamPatternsUseCase.invoke()
                val sentences = SentencesGenerator(tens, examPatterns).generate()
                examUseCases.importNotExistedSentencesUseCase.invoke(sentences)
                examNames = examUseCases.getExamNamesUseCase.invoke(tens)
            }.also {
                withContext(Dispatchers.Main) {
                    _state.value = state.value.copy(
                        exams = examNames,
                    )
                }
            }
        }
    }

    private fun getExams(tens: Tens) {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                val examNames = examUseCases.getExamNamesUseCase.invoke(tens)
                withContext(Dispatchers.Main) {
                    _state.value = state.value.copy(
                        exams = examNames,
                    )
                }
            }
        }
    }

    fun getProgress(tens: Tens): Int {
        if (state.value.mistakesCounts.containsKey(tens.int)
            && state.value.usedCountUseCase.containsKey(tens.int)) {
            val mistakesCounts = state.value.mistakesCounts[tens.int]!!
            val usedCount = state.value.usedCountUseCase[tens.int]!!
            return calculateAccuracy(mistakesCounts, usedCount)
        }
        return 0
    }

    fun getSentencesCount(tens: Tens): Int {
        if (state.value.sentencesCounts.containsKey(tens.int)) {
            val sentencesCounts = state.value.sentencesCounts[tens.int]!!
            if (sentencesCounts > MIN_COUNT_SENTECES) {
                return MIN_COUNT_SENTECES
            }
            return sentencesCounts
        }
        return 0
    }

}