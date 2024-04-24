package com.spascoding.feature_exam.presentation.exam_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spascoding.feature_exam.data.repository.SharedPreferencesRepositoryImpl
import com.spascoding.feature_exam.domain.enums.SentenceType
import com.spascoding.feature_exam.domain.use_case.ExamUseCases
import com.spascoding.feature_exam.domain.utils.GenerateSentence
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExamDetailViewModel @Inject constructor(
    private val examUseCases: ExamUseCases,
    savedStateHandle: SavedStateHandle,
    private val sharedPreferencesRepository: SharedPreferencesRepositoryImpl,
) : ViewModel() {

    private val _state = mutableStateOf(ExamDetailState())
    val state: State<ExamDetailState> = _state

    init {
        savedStateHandle.get<Int>("examIndex")?.also { examIndex ->
            savedStateHandle.get<Int>("tens")?.also { tens ->
                if(examIndex != -1) {
                    viewModelScope.launch {
                        examUseCases.getExamPatternsUseCase.invoke()[examIndex].also {
                            _state.value = state.value.copy(
                                exam = it,
                            )
                        }
                    }
                }
            }
        }
    }

    fun getFirstItemName(): String {
        val sentenceType = SentenceType.POSITIVE
        val tens = sharedPreferencesRepository.getSelectedTens()
        val subject = state.value.exam?.subjects?.get(0)
        val verb = state.value.exam?.verbs?.get(0)
        val objectVal = state.value.exam?.objects?.get(0)

        if (subject != null && verb != null && objectVal != null) {
            return GenerateSentence().invoke(
                sentenceType,
                tens,
                subject,
                verb,
                objectVal
            )
        }
        return ""
    }

}