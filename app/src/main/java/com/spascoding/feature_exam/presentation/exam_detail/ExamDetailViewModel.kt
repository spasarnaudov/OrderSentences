package com.spascoding.feature_exam.presentation.exam_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.use_case.ExamUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ExamDetailViewModel @Inject constructor(
    private val examUseCases: ExamUseCases,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = mutableStateOf(ExamDetailState())
    val state: State<ExamDetailState> = _state

    init {
        savedStateHandle.get<Int>("tens")?.also { tens ->
            savedStateHandle.get<String>("examName")?.also { examName ->
                GlobalScope.launch {
                    withContext(Dispatchers.IO) {
                        examUseCases.getSentencesUseCase.invoke(Tens.fromInt(tens), examName).also { sentences ->
                            withContext(Dispatchers.Main) {
                                _state.value = state.value.copy(
                                    examName = examName,
                                    sentences = sentences.map { it.value },
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}