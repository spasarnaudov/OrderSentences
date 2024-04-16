package com.spascoding.feature_exam.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.AnnotatedString
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spascoding.feature_exam.domain.ExamEvent
import com.spascoding.feature_exam.domain.GameState
import com.spascoding.feature_exam.domain.model.Exam
import com.spascoding.feature_exam.domain.use_case.GenerateSentenceUseCase
import com.spascoding.feature_exam.domain.use_case.ExamUseCases
import com.spascoding.feature_exam.presentation.utils.scratchWords
import com.spascoding.feature_exam.presentation.utils.shuffleSentence
import kotlinx.coroutines.launch

class ExamViewModel(
    private val examUseCases: ExamUseCases,
) : ViewModel() {

    private val _state = mutableStateOf(ExamState())
    val state: State<ExamState> = _state

    fun onEvent(event: ExamEvent) {
        when (event) {
            is ExamEvent.SelectLevel -> {
                _state.value = state.value.copy(
                    level = event.level
                )
            }

            is ExamEvent.SelectExam -> {
                viewModelScope.launch {
                    val exam = event.exam
                    val sentenceType = exam.sentenceTypes.random()
                    val tens = exam.tenses.random()
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
                        gameState = GameState.STARTED,
                        verb = verb,
                        exam = event.exam
                    )
                }
            }

            is ExamEvent.SelectExamInfo -> {
                _state.value = state.value.copy(
                    exam = event.exam
                )
            }

            is ExamEvent.EnterText -> {
                _state.value = state.value.copy(
                    enteredSentence = event.answerText
                )
            }

            is ExamEvent.EndGame -> {
                _state.value = state.value.copy(
                    enteredSentence = event.answerText,
                    gameState = GameState.FINISHED
                )
            }
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

    suspend fun getExams(): List<Exam> {
        return examUseCases.getExamUseCase.invoke(state.value.level)
    }
}