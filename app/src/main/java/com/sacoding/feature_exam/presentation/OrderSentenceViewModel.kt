package com.sacoding.feature_exam.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.AnnotatedString
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sacoding.feature_exam.data.data_source.StudentBook
import com.sacoding.feature_exam.domain.OrderSentenceEvent
import com.sacoding.feature_exam.data.data_source.Verbs
import com.sacoding.feature_exam.data.data_source.addPreposition
import com.sacoding.feature_exam.domain.GameState
import com.sacoding.feature_exam.domain.model.Lessen
import com.sacoding.feature_exam.domain.use_case.GenerateSentenceUseCase
import com.sacoding.feature_exam.domain.use_case.OrderSentenceUseCases
import com.sacoding.feature_exam.presentation.utils.scratchWords
import com.sacoding.feature_exam.presentation.utils.shuffleSentence
import kotlinx.coroutines.launch

class OrderSentenceViewModel(
    private val orderSentenceUseCases: OrderSentenceUseCases,
) : ViewModel() {

    private val _state = mutableStateOf(SentenceGenerationState())
    val state: State<SentenceGenerationState> = _state

    init {
        viewModelScope.launch {
            if (orderSentenceUseCases.isNotVerbsInDatabaseUseCase.invoke()) {
                orderSentenceUseCases.uploadVerbsToDBUseCase.invoke(Verbs.levelOneVerbs)
            }
        }
    }

    fun onEvent(event: OrderSentenceEvent) {
        when (event) {
            is OrderSentenceEvent.StartGame -> {
                startGame()
            }

            is OrderSentenceEvent.EndGame -> {
                _state.value = state.value.copy(
                    enteredSentence = event.answerText,
                    gameState = GameState.FINISHED
                )
                val isCorrectAnswer = isCorrectAnswer()
                if (!isCorrectAnswer) {
                    state.value.verb?.let {
                        viewModelScope.launch {
                            orderSentenceUseCases.incrementVerbMistakeCountUseCase.invoke(it)
                        }
                    }
                }
            }

            is OrderSentenceEvent.EnterText -> {
                _state.value = state.value.copy(
                    enteredSentence = event.answerText
                )
            }

            is OrderSentenceEvent.SelectLesson -> {
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

    fun getLessens(): List<Lessen> {
        return StudentBook.presentSimpleLessens
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