package com.spascoding.feature_exam.presentation.topics_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.spascoding.feature_exam.data.repository.SharedPreferencesRepositoryImpl
import com.spascoding.feature_exam.domain.MIN_COUNT_SENTECES
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.use_case.CommonUseCases
import com.spascoding.feature_exam.domain.use_case.TopicsUseCases
import com.spascoding.feature_exam.domain.utils.Accuracy
import com.spascoding.feature_exam.domain.utils.SentencesGenerator
import com.spascoding.feature_exam.domain.utils.TensLocker
import com.spascoding.feature_exam.presentation.utils.shuffleSentence
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class TopicsViewModel @Inject constructor(
    private val commonUseCases: CommonUseCases,
    private val topicsUseCases: TopicsUseCases,
    savedStateHandle: SavedStateHandle,
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
                    val mistakesCounts = topicsUseCases.getMistakesTopicsCountsByTensUseCase.invoke(tens, MIN_COUNT_SENTECES)
                    val usedCounts = topicsUseCases.getUsedTopicsCountsByTensUseCase.invoke(tens, MIN_COUNT_SENTECES)
                    val sentencesCounts = topicsUseCases.getSentencesTopicsCountsByTensUseCase.invoke(tens, MIN_COUNT_SENTECES)
                    withContext(Dispatchers.Main) {
                        _state.value = state.value.copy(
                            mistakesCounts = mistakesCounts,
                            usedCounts = usedCounts,
                            sentencesCounts = sentencesCounts,
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

    fun getProgress(topic: String): Int {
        if (state.value.mistakesCounts.containsKey(topic)
            && state.value.usedCounts.containsKey(topic)) {
            val mistakesCount = state.value.mistakesCounts[topic]!!
            val usedCount = state.value.usedCounts[topic]!!
            return Accuracy(mistakesCount, usedCount).calculate()
        }
        return 0
    }

    fun getLastSentencesCount(topic: String): Int {
        if (state.value.sentencesCounts.containsKey(topic)) {
            val sentencesCounts = state.value.sentencesCounts[topic]!!
            if (sentencesCounts > MIN_COUNT_SENTECES) {
                return MIN_COUNT_SENTECES
            }
            return sentencesCounts
        }
        return 0
    }

    fun getSentencesCount(topic: String): Int {
        if (state.value.sentencesCounts.containsKey(topic)) {
            return state.value.sentencesCounts[topic]!!
        }
        return 0
    }

}