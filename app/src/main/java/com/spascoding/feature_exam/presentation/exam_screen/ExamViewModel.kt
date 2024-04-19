package com.spascoding.feature_exam.presentation.exam_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.AnnotatedString
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spascoding.feature_exam.domain.ExamState
import com.spascoding.feature_exam.domain.SentenceType
import com.spascoding.feature_exam.domain.Tens
import com.spascoding.feature_exam.domain.use_case.GenerateSentenceUseCase
import com.spascoding.feature_exam.domain.use_case.ExamUseCases
import com.spascoding.feature_exam.presentation.utils.scratchWords
import com.spascoding.feature_exam.presentation.utils.shuffleSentence
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExamViewModel @Inject constructor(
    private val examUseCases: ExamUseCases,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = mutableStateOf(ExamViewModelState())
    val state: State<ExamViewModelState> = _state

    init {
        savedStateHandle.get<Int>("examIndex")?.also { examIndex ->
            savedStateHandle.get<Int>("tens")?.also { tens ->
                if (examIndex != -1) {
                    viewModelScope.launch {
                        examUseCases.getExamUseCase.invoke(Tens.fromInt(tens))[examIndex].also {
                            _state.value = state.value.copy(
                                exam = it,
                            )
                            generateSentence()
                        }
                    }
                }
            }
        }
    }

    fun onEvent(event: ExamEvent) {
        when (event) {
            is ExamEvent.NewExam -> {
                generateSentence()
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
            }
        }
    }

    private fun generateSentence() {
        viewModelScope.launch {
            val exam = state.value.exam
            val sentenceType = SentenceType.entries.random()
            val tens = exam.tens
            val subject = exam.subjects.random()
            val verb = exam.verbs.random()
            val objectVal = exam.objects.random()

            val sentence = GenerateSentenceUseCase().invoke(
                sentenceType,
                tens,
                subject,
                verb,
                objectVal
            )
            val shuffledSentence = sentence.shuffleSentence(" / ")
            _state.value = state.value.copy(
                sentence = sentence,
                shuffledSentence = shuffledSentence,
                enteredSentence = "",
                gameState = ExamState.STARTED,
            )
        }
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