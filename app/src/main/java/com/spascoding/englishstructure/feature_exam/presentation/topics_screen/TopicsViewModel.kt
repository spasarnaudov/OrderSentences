package com.spascoding.englishstructure.feature_exam.presentation.topics_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.spascoding.englishstructure.feature_exam.domain.MIN_COUNT_SENTECES
import com.spascoding.englishstructure.feature_exam.domain.enums.Tens
import com.spascoding.englishstructure.feature_exam.domain.model.getElementByTopic
import com.spascoding.englishstructure.feature_exam.domain.repository.FirebaseRepository
import com.spascoding.englishstructure.feature_exam.domain.use_case.CommonUseCases
import com.spascoding.englishstructure.feature_exam.domain.use_case.TopicsUseCases
import com.spascoding.englishstructure.feature_exam.domain.utils.SentencesGenerator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class TopicsViewModel @Inject constructor(
    private val commonUseCases: CommonUseCases,
    private val topicsUseCases: TopicsUseCases,
    private val savedStateHandle: SavedStateHandle,
    private val firebaseRepository: FirebaseRepository,
) : ViewModel() {

    private val _state = mutableStateOf(TopicsViewModelState())
    val state: State<TopicsViewModelState> = _state

    init {
        savedStateHandle.get<Int>("tens")?.also { tensInt ->
            val tens: Tens = Tens.fromInt(tensInt)

            _state.value = state.value.copy(
                tens = tens,
            )

            saveSentencesToDatabase(tens).also {
                getExams(tens)
            }

            GlobalScope.launch {
                withContext(Dispatchers.IO) {
                    val topicsAccuracyInfo = topicsUseCases.getTopicsAccuracyInfoUseCase.invoke(tens, MIN_COUNT_SENTECES)
                    withContext(Dispatchers.Main) {
                        _state.value = state.value.copy(
                            topicsAccuracyInfo = topicsAccuracyInfo,
                        )
                    }
                }
            }
        }
    }

    fun onEvent(event: TopicsScreenEvent) {
        when (event) {
            is TopicsScreenEvent.SelectTopic -> {

            }
            is TopicsScreenEvent.SelectTopicInfo -> {

            }
        }
    }

    private fun saveSentencesToDatabase(tens: Tens) {
        GlobalScope.launch {
            var topics: List<String>
            withContext(Dispatchers.IO) {
                val examPatterns = commonUseCases.getExamPatternsUseCase.invoke()
                val sentences = SentencesGenerator(tens, examPatterns).generate()
                commonUseCases.importNotExistedSentencesUseCase.invoke(sentences)
                topics = topicsUseCases.getTopicsUseCase.invoke(tens)
            }.also {
                withContext(Dispatchers.Main) {
                    _state.value = state.value.copy(
                        topics = topics,
                    )
                }
            }
        }
    }

    private fun getExams(tens: Tens) {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                val examNames = topicsUseCases.getTopicsUseCase.invoke(tens)
                withContext(Dispatchers.Main) {
                    _state.value = state.value.copy(
                        topics = examNames,
                    )
                }
            }
        }
    }

    fun isSuccess(topic: String): Boolean {
        return getAccuracy(topic) >= firebaseRepository.getUnlockTopicAccuracy()
                && getSentencesCount(topic) > firebaseRepository.getUnlockTopicSentenceCount()
    }

    fun getAccuracy(topic: String): Int {
        val tensAccuracyInfo = state.value.topicsAccuracyInfo.getElementByTopic(topic)
        if (tensAccuracyInfo != null) {
            return tensAccuracyInfo.accuracy()
        }
        return 0
    }

    fun getLastSentencesCount(topic: String): Int {
        val tensAccuracyInfo = state.value.topicsAccuracyInfo.getElementByTopic(topic)
        if (tensAccuracyInfo != null) {
            val sentencesCounts = tensAccuracyInfo.sentencesCount
            if (sentencesCounts > MIN_COUNT_SENTECES) {
                return MIN_COUNT_SENTECES
            }
            return sentencesCounts
        }
        return 0
    }

    fun getSentencesCount(topic: String): Int {
        val tensAccuracyInfo = state.value.topicsAccuracyInfo.getElementByTopic(topic)
        if (tensAccuracyInfo != null) {
            return tensAccuracyInfo.sentencesCount
        }
        return 0
    }

}