package com.spascoding.feature_exam.presentation.exam_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spascoding.feature_exam.domain.enums.SentenceType
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.use_case.ExamUseCases
import com.spascoding.feature_exam.domain.utils.GenerateSentence
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExamDetailViewModel @Inject constructor(
    private val examUseCases: ExamUseCases,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = mutableStateOf(ExamDetailState())
    val state: State<ExamDetailState> = _state

    init {
        savedStateHandle.get<Int>("examIndex")?.also { examIndex ->
            savedStateHandle.get<Int>("tens")?.also { tens ->
                if(examIndex != -1) {
                    viewModelScope.launch {
                        examUseCases.getExamUseCase.invoke(Tens.fromInt(tens))[examIndex].also {
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
        val tens = state.value.exam?.tens
        val subject = state.value.exam?.subjects?.get(0)
        val verb = state.value.exam?.verbs?.get(0)
        val objectVal = state.value.exam?.objects?.get(0)

        if (tens != null && subject != null && verb != null && objectVal != null) {
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