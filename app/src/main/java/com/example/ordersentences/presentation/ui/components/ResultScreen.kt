package com.example.ordersentences.presentation.ui.components

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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ordersentences.domain.OrderSentenceEvent
import com.example.ordersentences.presentation.OrderSentenceViewModel

@Composable
fun ResultScreen(
    viewModel: OrderSentenceViewModel
) {
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
                    .wrapContentSize(),
                text = viewModel.state.value.sentence?.buildSentence() ?: "",
                fontWeight = FontWeight.Bold,
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .border(
                        width = 2.dp,
                        color = if (viewModel.isCorrectAnswer()) Color.Green else Color.Red,
                        shape = RoundedCornerShape(4.dp)
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
                    .wrapContentSize(),
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