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
import com.example.ordersentences.data.OrderSentenceDatabase
import com.example.ordersentences.domain.OrderSentenceEvent
import com.example.ordersentences.domain.model.GameState
import com.example.ordersentences.presentation.theme.OrderSentencesTheme

class OrderSentenceActivity : ComponentActivity() {

    private val viewModel by viewModels<OrderSentenceViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return OrderSentenceViewModel(OrderSentenceDatabase.getDatabase(applicationContext).dao) as T
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
                modifier = Modifier.fillMaxWidth(),
                text = viewModel.getSentenceType(),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                text = viewModel.getShuffledText(),
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
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
                    .wrapContentSize()
                    .padding(8.dp),
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
                val isCorrectAnswer = viewModel.isCorrectAnswer()
                Button(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(16.dp),
                    onClick = { showDialog.value = true },
                ) {
                    Image(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = "Info",
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.background)
                    )
                    Text("Info")
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .wrapContentSize()
                        .border(
                            width = 2.dp,
                            color = if (isCorrectAnswer) Color.Green else Color.Red,
                            shape = RoundedCornerShape(8.dp)
                        ),
                ) {
                    Text(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                        text = viewModel.state.value.sentence?.buildSentence() ?: "",
                        fontWeight = FontWeight.Bold,
                    )
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