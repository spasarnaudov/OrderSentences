package com.spascoding.feature_exam.presentation.exam_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.spascoding.feature_exam.data.repository.SharedPreferencesRepositoryImpl
import com.spascoding.feature_exam.domain.enums.SentenceType
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.Exam
import com.spascoding.feature_exam.domain.use_case.ExamUseCases
import com.spascoding.feature_exam.domain.use_case.GenerateSentenceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
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
        getExams(state.value.tens)
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
                getExams(state.value.tens)
            }
        }
    }

    private fun getExams(tens: Tens) {
        _state.value = state.value.copy(
            exams = examUseCases.getExamUseCase.invoke(tens),
        )
    }

    fun getFirstItemName(exam: Exam): String {
        val sentenceType = SentenceType.POSITIVE
        val tens = exam.tens
        val subject = exam.subjects[0]
        val verb = exam.verbs[0]
        val objectVal = exam.objects[0]

        return GenerateSentenceUseCase().invoke(
            sentenceType,
            tens,
            subject,
            verb,
            objectVal
        )
    }

}