package com.spascoding.feature_exam.presentation.exam_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.AnnotatedString
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.spascoding.feature_exam.domain.enums.ExamState
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.use_case.ExamUseCases
import com.spascoding.feature_exam.presentation.utils.scratchWords
import com.spascoding.feature_exam.presentation.utils.shuffleSentence
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ExamViewModel @Inject constructor(
    private val examUseCases: ExamUseCases,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = mutableStateOf(ExamViewModelState())
    val state: State<ExamViewModelState> = _state

    init {
        savedStateHandle.get<Int>("tens")?.also { tens ->
            savedStateHandle.get<String>("examName")?.also { examName ->
                _state.value = state.value.copy(
                    tens = Tens.fromInt(tens),
                    examName = examName
                )
                getSentence()
            }
        }
    }

    fun onEvent(event: ExamEvent) {
        when (event) {
            is ExamEvent.NewExam -> {
                getSentence()
            }

            is ExamEvent.EnterText -> {
                _state.value = state.value.copy(
                    enteredSentence = event.answerText
                )
            }

            is ExamEvent.EndExam -> {
                _state.value = state.value.copy(
                    enteredSentence = event.answerText,
                    gameState = ExamState.FINISHED
                )

                var sentence = state.value.sentences[0]
                if (!isCorrectAnswer()) {
                    sentence = state.value.sentences[0].copy(
                        useCount = state.value.sentences[0].useCount + 1,
                        mistakeCount = state.value.sentences[0].mistakeCount + 1,
                    )
                }
                GlobalScope.launch {
                    withContext(Dispatchers.IO) {
                        examUseCases.updateSentenceUseCase.invoke(sentence)
                    }
                }
            }
        }
    }

    private fun getSentence() {
        val tens = state.value.tens
        val examName = state.value.examName
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                examUseCases.getSentenceUseCase.invoke(tens, examName).also { sentence ->
                    withContext(Dispatchers.Main) {
                        _state.value = state.value.copy(
                            sentences = listOf(sentence),
                        )
                        generateSentence()
                    }
                }
            }
        }
    }

    private fun generateSentence() {
        val sentence = state.value.sentences[0]
        val shuffledSentence = sentence.value.shuffleSentence(" / ")
        _state.value = state.value.copy(
            sentence = sentence.value,
            shuffledSentence = shuffledSentence,
            enteredSentence = "",
            gameState = ExamState.STARTED,
        )
    }

    fun getShuffledText(): AnnotatedString {
        return scratchWords(
            textToScratch = state.value.enteredSentence,
            shuffledSentence = state.value.shuffledSentence
        )
    }

    fun isCorrectAnswer(): Boolean {
        return state.value.enteredSentence == state.value.sentence
    }

}