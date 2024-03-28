package com.example.ordersentences.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.AnnotatedString
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ordersentences.data.VerbDao
import com.example.ordersentences.domain.OrderSentenceEvent
import com.example.ordersentences.domain.model.GameState
import com.example.ordersentences.domain.model.SentenceType
import com.example.ordersentences.domain.model.Verb
import com.example.ordersentences.presentation.utils.removeNonWordSymbols
import com.example.ordersentences.domain.use_case.GenerateSentenceUseCase
import com.example.ordersentences.domain.use_case.LoadObjectUseCase
import com.example.ordersentences.domain.use_case.LoadSubjectUseCase
import com.example.ordersentences.domain.use_case.LoadVerbUseCase
import com.example.ordersentences.domain.use_case.UploadVerbsToDBUseCase
import com.example.ordersentences.domain.use_case.IncrementVerbMistakeCountUseCase
import com.example.ordersentences.domain.use_case.LoadAllVerbsUseCase
import com.example.ordersentences.presentation.utils.scratchWords
import com.example.ordersentences.presentation.utils.shuffleSentence
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

class OrderSentenceViewModel(
    private val dao: VerbDao
): ViewModel() {
    private val _state = mutableStateOf(SentenceGenerationState())
    val state: State<SentenceGenerationState> = _state

    init {
        viewModelScope.launch {
            if (dao.countRows() == 0) {
                UploadVerbsToDBUseCase(dao).invoke()
            }
        }
    }

    fun getGameState(): GameState {
        return state.value.gameState
    }

    fun getSentenceType(): String {
        return if (state.value.sentenceType != null)
            state.value.sentenceType.toString()
        else
            ""
    }

    fun getShuffledText(): AnnotatedString {
        return scratchWords(
            textToScratch = state.value.enteredSentence,
            shuffledSentence = state.value.shuffledSentence
        )
    }

    fun isCorrectAnswer(): Boolean {
        return state.value.enteredSentence.removeNonWordSymbols() == state.value.sentence?.buildSentence()
            ?.removeNonWordSymbols()
    }

    fun onEvent(event: OrderSentenceEvent) {
        when(event) {
            is OrderSentenceEvent.StartGame -> {
                val sentenceType: SentenceType = SentenceType.entries[Random.nextInt(SentenceType.entries.size)]
                startGame(sentenceType)
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
                            IncrementVerbMistakeCountUseCase(dao).invoke(it)
                        }
                    }
                }
            }
            is OrderSentenceEvent.EnterText -> {
                _state.value = state.value.copy(
                    enteredSentence = event.answerText
                )
            }
        }
    }

    private fun startGame(sentenceType: SentenceType) {
        viewModelScope.launch {
            val subject = LoadSubjectUseCase().invoke()
            val verb = LoadVerbUseCase(dao).invoke()
            val objectVal = LoadObjectUseCase().invoke(verb.baseForm)

            val sentence = GenerateSentenceUseCase().invoke(
                sentenceType,
                subject,
                verb,
                objectVal
            )
            val shuffledSentence = shuffleSentence(
                " / ",
                sentence.buildSentence().removeNonWordSymbols()
            )
            _state.value = state.value.copy(
                sentence = sentence,
                shuffledSentence = shuffledSentence,
                enteredSentence = "",
                sentenceType = sentenceType,
                gameState = GameState.STARTED,
                verb = verb
            )
        }
    }

    fun getVerbs(): List<Verb> = runBlocking {
        LoadAllVerbsUseCase(dao = dao).invoke()
    }
}