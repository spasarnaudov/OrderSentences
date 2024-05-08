package com.spascoding.englishstructure.feature_exam.presentation.tense_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.spascoding.englishstructure.feature_exam.domain.enums.Tense
import com.spascoding.englishstructure.feature_exam.domain.model.getElementByTense
import com.spascoding.englishstructure.feature_exam.domain.repository.ConfigRepository
import com.spascoding.englishstructure.feature_exam.domain.use_case.TenseUseCases
import com.spascoding.englishstructure.feature_exam.domain.utils.TenseLocker
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TenseScreenViewModel @Inject constructor(
    private val examUseCases: TenseUseCases,
    private val configRepository: ConfigRepository,
) : ViewModel() {

    private val _state = mutableStateOf(TenseScreenViewModelState())
    val state: State<TenseScreenViewModelState> = _state

    init {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                val tensesAccuracyInfo = examUseCases.getTensesAccuracyInfoUseCase.invoke(configRepository.getAccuracySentencesCount())
                withContext(Dispatchers.Main) {
                    _state.value = state.value.copy(
                        tensesAccuracyInfo = tensesAccuracyInfo,
                    )
                }
            }
        }
    }

    fun onEvent(event: TenseScreenEventEvent) {
        when (event) {
            is TenseScreenEventEvent.SelectTense -> {

            }
        }
    }

    fun getAccuracy(tense: Tense): Int {
        val tenseAccuracyInfo = state.value.tensesAccuracyInfo.getElementByTense(tense)
        if (tenseAccuracyInfo != null) {
            return tenseAccuracyInfo.accuracy()
        }
        return 0
    }

    fun getLastSentencesCount(tense: Tense): Int {
        val tenseAccuracyInfo = state.value.tensesAccuracyInfo.getElementByTense(tense)
        if (tenseAccuracyInfo != null) {
            val sentencesCounts = tenseAccuracyInfo.sentencesCount
            if (sentencesCounts > configRepository.getAccuracySentencesCount()) {
                return configRepository.getAccuracySentencesCount()
            }
            return sentencesCounts
        }
        return 0
    }

    fun getSentencesCount(tense: Tense): Int {
        val tenseAccuracyInfo = state.value.tensesAccuracyInfo.getElementByTense(tense)
        if (tenseAccuracyInfo != null) {
            return tenseAccuracyInfo.sentencesCount
        }
        return 0
    }

    fun isTenseLocked(tense: Tense): Boolean {
        return TenseLocker(configRepository).isLocked(tense, state.value.tensesAccuracyInfo)
    }

}