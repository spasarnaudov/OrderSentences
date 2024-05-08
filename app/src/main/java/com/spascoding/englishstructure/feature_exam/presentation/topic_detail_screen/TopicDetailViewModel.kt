package com.spascoding.englishstructure.feature_exam.presentation.topic_detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.spascoding.englishstructure.feature_exam.domain.enums.Tense
import com.spascoding.englishstructure.feature_exam.domain.use_case.TopicsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TopicDetailViewModel @Inject constructor(
    private val topicsUseCases: TopicsUseCases,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = mutableStateOf(TopicDetailState())
    val state: State<TopicDetailState> = _state

    init {
        savedStateHandle.get<Int>("tense")?.also { tense ->
            savedStateHandle.get<String>("topic")?.also { topic ->
                GlobalScope.launch {
                    withContext(Dispatchers.IO) {
                        topicsUseCases.getSentencesUseCase.invoke(Tense.fromInt(tense), topic).also { sentences ->
                            withContext(Dispatchers.Main) {
                                _state.value = state.value.copy(
                                    tense = Tense.fromInt(tense),
                                    examName = topic,
                                    sentences = sentences,
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}