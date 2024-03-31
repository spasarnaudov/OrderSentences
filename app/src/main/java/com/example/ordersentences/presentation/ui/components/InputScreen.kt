package com.example.ordersentences.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ordersentences.domain.OrderSentenceEvent
import com.example.ordersentences.presentation.OrderSentenceViewModel

@Composable
fun InputScreen(
    viewModel: OrderSentenceViewModel
) {
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
                .padding(vertical = 16.dp)
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