package com.sacoding.feature_exam.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.AnnotatedString
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sacoding.feature_exam.data.data_source.StudentBook
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
            is ExamEvent.StartGame -> {
                startGame()
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

            is ExamEvent.EnterText -> {
                _state.value = state.value.copy(
                    enteredSentence = event.answerText
                )
            }

            is ExamEvent.SelectExam -> {
                _state.value = state.value.copy(
                    lessen = event.lessen
                )
            }
        }
    }

    fun getGameState(): GameState {
        return state.value.gameState
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

    fun getLessens(): List<Exam> {
        return StudentBook.Exam.presentSimple
    }

    private fun startGame() {
        viewModelScope.launch {
            val lessen = state.value.lessen
            val sentenceType = lessen.sentenceTypes.random()
            val tens = lessen.tenses.random()
            val subject = lessen.subjects.random()
            val verb = lessen.verbs.random()
            val objectVal = lessen.objectVals.random()

            val sentence = GenerateSentenceUseCase().invoke(
                sentenceType,
                tens,
                subject,
                verb,
                if (lessen.prepositions.isEmpty()) objectVal else objectVal.addPreposition(lessen.prepositions.random())
            )
            val shuffledSentence = sentence.shuffleSentence(" / ")
            _state.value = state.value.copy(
                sentence = sentence,
                shuffledSentence = shuffledSentence,
                enteredSentence = "",
                gameState = GameState.STARTED,
                verb = verb
            )
        }
    }
}