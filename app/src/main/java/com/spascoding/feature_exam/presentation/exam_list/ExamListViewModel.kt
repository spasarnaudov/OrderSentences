package com.spascoding.feature_exam.presentation.exam_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.spascoding.feature_exam.data.repository.SharedPreferencesRepositoryImpl
import com.spascoding.feature_exam.domain.enums.SentenceType
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.ExamPattern
import com.spascoding.feature_exam.domain.use_case.ExamUseCases
import com.spascoding.feature_exam.domain.utils.GenerateSentence
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
        getExams()
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
                getExams()
            }
        }
    }

    private fun getExams() {
        _state.value = state.value.copy(
            exams = examUseCases.getExamUseCase.invoke(),
        )
    }

    fun getFirstItemName(exam: ExamPattern): String {
        val sentenceType = SentenceType.POSITIVE
        val tens = state.value.tens
        val subject = exam.subjects[0]
        val verb = exam.verbs[0]
        val objectVal = exam.objects[0]

        return GenerateSentence().invoke(
            sentenceType,
            tens,
            subject,
            verb,
            objectVal
        )
    }

}