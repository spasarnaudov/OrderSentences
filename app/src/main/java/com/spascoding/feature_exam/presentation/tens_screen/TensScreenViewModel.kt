package com.spascoding.feature_exam.presentation.tens_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.spascoding.feature_exam.data.repository.SharedPreferencesRepositoryImpl
import com.spascoding.feature_exam.domain.MIN_COUNT_SENTECES
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.use_case.ExamUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TensScreenViewModel @Inject constructor(
    private val examUseCases: ExamUseCases,
    private val sharedPreferencesRepository: SharedPreferencesRepositoryImpl,
) : ViewModel() {

    private val _state = mutableStateOf(TensScreenViewModelState())
    val state: State<TensScreenViewModelState> = _state

    init {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                val mistakesCounts = examUseCases.getMistakesCountsUseCase.invoke(MIN_COUNT_SENTECES)
                val useCountUseCase = examUseCases.getUseCountUseCase.invoke(MIN_COUNT_SENTECES)
                val sentencesCounts = examUseCases.getSentencesCountsUseCase.invoke()
                withContext(Dispatchers.Main) {
                    _state.value = state.value.copy(
                        mistakesCounts = mistakesCounts,
                        useCountUseCase = useCountUseCase,
                        sentencesCounts = sentencesCounts,
                        tens = sharedPreferencesRepository.getSelectedTens(),
                    )
                }
            }
        }
    }

    fun onEvent(event: TensScreenEventEvent) {
        when (event) {
            is TensScreenEventEvent.SelectTens -> {
                sharedPreferencesRepository.setSelectedTens(event.tens)
                _state.value = state.value.copy(
                    tens = event.tens,
                )
            }
        }
    }

    fun getProgress(tens: Tens): Int {
        if (state.value.mistakesCounts.containsKey(tens.int)
            && state.value.useCountUseCase.containsKey(tens.int)) {
            val mistakesCounts = state.value.mistakesCounts[tens.int]!!
            val useCount = state.value.useCountUseCase[tens.int]!!
            return calculateAccuracy(mistakesCounts, useCount)
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