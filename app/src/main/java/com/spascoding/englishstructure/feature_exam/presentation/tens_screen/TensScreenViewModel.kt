package com.spascoding.englishstructure.feature_exam.presentation.tens_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.spascoding.englishstructure.feature_exam.domain.MIN_COUNT_SENTECES
import com.spascoding.englishstructure.feature_exam.domain.enums.Tens
import com.spascoding.englishstructure.feature_exam.domain.model.getElementByTens
import com.spascoding.englishstructure.feature_exam.domain.use_case.TensUseCases
import com.spascoding.englishstructure.feature_exam.domain.utils.TensLocker
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TensScreenViewModel @Inject constructor(
    private val examUseCases: TensUseCases,
) : ViewModel() {

    private val _state = mutableStateOf(TensScreenViewModelState())
    val state: State<TensScreenViewModelState> = _state

    init {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                val tensesAccuracyInfo = examUseCases.getTensesAccuracyInfoUseCase.invoke(MIN_COUNT_SENTECES)
                withContext(Dispatchers.Main) {
                    _state.value = state.value.copy(
                        tensesAccuracyInfo = tensesAccuracyInfo,
                    )
                }
            }
        }
    }

    fun onEvent(event: TensScreenEventEvent) {
        when (event) {
            is TensScreenEventEvent.SelectTens -> {

            }
        }
    }

    fun getAccuracy(tens: Tens): Int {
        val tensAccuracyInfo = state.value.tensesAccuracyInfo.getElementByTens(tens)
        if (tensAccuracyInfo != null) {
            return tensAccuracyInfo.accuracy()
        }
        return 0
    }

    fun getLastSentencesCount(tens: Tens): Int {
        val tensAccuracyInfo = state.value.tensesAccuracyInfo.getElementByTens(tens)
        if (tensAccuracyInfo != null) {
            val sentencesCounts = tensAccuracyInfo.sentencesCount
            if (sentencesCounts > MIN_COUNT_SENTECES) {
                return MIN_COUNT_SENTECES
            }
            return sentencesCounts
        }
        return 0
    }

    fun getSentencesCount(tens: Tens): Int {
        val tensAccuracyInfo = state.value.tensesAccuracyInfo.getElementByTens(tens)
        if (tensAccuracyInfo != null) {
            return tensAccuracyInfo.sentencesCount
        }
        return 0
    }

    fun isTensLocked(tens: Tens): Boolean {
        return TensLocker.isLocked(tens, state.value.tensesAccuracyInfo)
    }

}