package com.spascoding.feature_exam.presentation.exam_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.spascoding.feature_exam.domain.MIN_COUNT_SENTECES
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.sentence.entity.Sentence
import com.spascoding.feature_exam.domain.use_case.ExamUseCases
import com.spascoding.feature_exam.presentation.utils.scratchWords
import com.spascoding.feature_exam.presentation.utils.shuffleSentence
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Date
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
                GlobalScope.launch {
                    withContext(Dispatchers.IO) {
                        val newSentence = examUseCases.getSentenceUseCase.invoke(Tens.fromInt(tens), examName)
                        val history = examUseCases.getUserSentenceUseCase.invoke(Tens.fromInt(tens), examName, 10)
                        withContext(Dispatchers.Main) {
                            _state.value = state.value.copy(
                                sentences = listOf(newSentence),
                                sentence = newSentence.value,
                                shuffledSentence = newSentence.value.shuffleSentence(" / "),
                                history = history,
                            )
                        }
                    }
                }
            }
        }
    }

    fun onEvent(event: ExamEvent) {
        when (event) {
            is ExamEvent.EnterText -> {
                _state.value = state.value.copy(
                    enteredSentence = event.answerText,
                    answerText = mutableStateOf(TextFieldValue(text = event.answerText, selection = TextRange(event.answerText.length))),
                )
            }

            is ExamEvent.CheckExam -> {
                val originSentence = state.value.sentences[0]

                val tens = state.value.tens
                val examName = state.value.examName

                GlobalScope.launch {
                    withContext(Dispatchers.IO) {
                        updateCurrentSentence(originSentence, event.answerText)
                        val newSentence = examUseCases.getSentenceUseCase.invoke(tens, examName)
                        val history = examUseCases.getUserSentenceUseCase.invoke(tens, examName, 10)
                        withContext(Dispatchers.Main) {
                            _state.value = state.value.copy(
                                sentences = listOf(newSentence),
                                sentence = newSentence.value,
                                shuffledSentence = newSentence.value.shuffleSentence(" / "),
                                enteredSentence = "",
                                answerText = mutableStateOf(TextFieldValue(text = "", selection = TextRange(0))),
                                history = history,
                            )
                        }
                    }
                }
            }
        }
    }

    private suspend fun updateCurrentSentence(originSentence: Sentence, answerText: String) {
        var mistakeCount = originSentence.mistakeCount
        if (!isCorrectAnswer()) {
            mistakeCount++
        }
        val sentence = originSentence.copy(
            useCount = state.value.sentences[0].useCount + 1,
            mistakeCount = mistakeCount,
            userValue = answerText,
            userValueTime = Date().time
        )
        examUseCases.updateSentenceUseCase.invoke(sentence)
    }

    fun getShuffledText(): AnnotatedString {
        return scratchWords(
            textToScratch = state.value.enteredSentence,
            shuffledSentence = state.value.shuffledSentence
        )
    }

    private fun isCorrectAnswer(): Boolean {
        return state.value.enteredSentence == state.value.sentence
    }

}