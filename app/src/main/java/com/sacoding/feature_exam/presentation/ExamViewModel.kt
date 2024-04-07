package com.sacoding.feature_exam.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.AnnotatedString
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sacoding.feature_exam.domain.ExamEvent
import com.sacoding.feature_exam.data.data_source.Verbs
import com.sacoding.feature_exam.data.data_source.addPreposition
import com.sacoding.feature_exam.domain.GameState
import com.sacoding.feature_exam.domain.model.Exam
import com.sacoding.feature_exam.domain.use_case.GenerateSentenceUseCase
import com.sacoding.feature_exam.domain.use_case.ExamUseCases
import com.sacoding.feature_exam.presentation.utils.scratchWords
import com.sacoding.feature_exam.presentation.utils.shuffleSentence
import kotlinx.coroutines.launch

class ExamViewModel(
    private val examUseCases: ExamUseCases,
) : ViewModel() {

    private val _state = mutableStateOf(ExamState())
    val state: State<ExamState> = _state

    init {
        viewModelScope.launch {
            if (examUseCases.isNotVerbsInDatabaseUseCase.invoke()) {
                examUseCases.uploadVerbsToDBUseCase.invoke(Verbs.levelOneVerbs)
            }
        }
    }

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
                    val objectVal = exam.objectVals.random()

                    val sentence = GenerateSentenceUseCase().invoke(
                        sentenceType,
                        tens,
                        subject,
                        verb,
                        if (exam.prepositions.isEmpty()) objectVal else objectVal.addPreposition(exam.prepositions.random())
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
                val isCorrectAnswer = isCorrectAnswer()
                if (!isCorrectAnswer) {
                    state.value.verb?.let {
                        viewModelScope.launch {
                            examUseCases.incrementVerbMistakeCountUseCase.invoke(it)
                        }
                    }
                }
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