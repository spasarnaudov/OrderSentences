package com.example.ordersentences.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ordersentences.data.data_source.OrderSentenceDatabase
import com.example.ordersentences.data.repository.VerbRepositoryImpl
import com.example.ordersentences.domain.OrderSentenceEvent
import com.example.ordersentences.domain.model.GameState
import com.example.ordersentences.domain.use_case.GetAllVerbsUseCase
import com.example.ordersentences.domain.use_case.GetObjectUseCase
import com.example.ordersentences.domain.use_case.GetSubjectUseCase
import com.example.ordersentences.domain.use_case.GetVerbUseCase
import com.example.ordersentences.domain.use_case.IncrementVerbMistakeCountUseCase
import com.example.ordersentences.domain.use_case.IsNotVerbsInDatabaseUseCase
import com.example.ordersentences.domain.use_case.OrderSentenceUseCases
import com.example.ordersentences.domain.use_case.UploadVerbsToDBUseCase
import com.example.ordersentences.presentation.theme.OrderSentencesTheme

class OrderSentenceActivity : ComponentActivity() {

    private val viewModel by viewModels<OrderSentenceViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    val repository = VerbRepositoryImpl(OrderSentenceDatabase.getDatabase(applicationContext).dao)
                    val useCases = OrderSentenceUseCases(
                        GetAllVerbsUseCase(repository = repository),
                        GetObjectUseCase(repository = repository),
                        GetSubjectUseCase(repository = repository),
                        GetVerbUseCase(repository = repository),
                        IncrementVerbMistakeCountUseCase(repository = repository),
                        IsNotVerbsInDatabaseUseCase(repository = repository),
                        UploadVerbsToDBUseCase(repository = repository),
                    )
                    return OrderSentenceViewModel(useCases) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrderSentencesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when (viewModel.getGameState()) {
                        GameState.FINISHED -> {
                            StartGame()
                        }
                        GameState.STARTED -> {
                            UserInput()
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun UserInput() {
        var answerText by remember { mutableStateOf("") }
        val focusRequester = remember { FocusRequester() }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier
                    .wrapContentSize(),
                fontWeight = FontWeight.Bold,
                text = viewModel.getShuffledText(),
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .focusRequester(focusRequester),
                value = answerText,
                onValueChange = {
                    answerText = it
                    viewModel.onEvent(OrderSentenceEvent.EnterText(answerText))
                },
                label = { Text("Enter your sentence") },
            )
            Button(
                modifier = Modifier
                    .wrapContentSize(),
                enabled = answerText.isNotBlank(),
                onClick = {
                    viewModel.onEvent(OrderSentenceEvent.EndGame(answerText))
                },
            ) {
                Text(text = "Finish game")
            }

            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
        }
    }

    @Composable
    fun StartGame() {
        val showDialog = remember { mutableStateOf(false) }
        InfoDialog(verbs = viewModel.getVerbs(), showDialog = showDialog)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            if (viewModel.state.value.enteredSentence.isNotBlank()) {
                Text(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    text = viewModel.state.value.sentence?.buildSentence() ?: "",
                    fontWeight = FontWeight.Bold,
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 2.dp,
                            color = if (viewModel.isCorrectAnswer()) Color.Green else Color.Red,
                            shape = RoundedCornerShape(8.dp)
                        ),
                ) {
                    Text(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(16.dp),
                        text = viewModel.state.value.enteredSentence,
                    )
                }
                Button(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(16.dp),
                    onClick = {
                        viewModel.onEvent(OrderSentenceEvent.StartGame)
                    },
                ) {
                    Text(text = "Start game")
                }
            } else {
                Button(
                    modifier = Modifier.size(160.dp),
                    shape = CircleShape,
                    contentPadding = PaddingValues(16.dp),
                    onClick = {
                        viewModel.onEvent(OrderSentenceEvent.StartGame)
                    },
                ) {
                    Text(
                        text = "Start game",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                }
            }
        }
    }
}