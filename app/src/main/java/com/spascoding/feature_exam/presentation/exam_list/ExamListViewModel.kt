package com.spascoding.feature_exam.presentation.exam_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.spascoding.feature_exam.data.repository.SharedPreferencesRepositoryImpl
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.use_case.ExamUseCases
import com.spascoding.feature_exam.domain.utils.SentencesGenerator
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

}