package com.sacoding.feature_exam.presentation.ui.components

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sacoding.core.constants.FontSize
import com.sacoding.core.constants.Padding
import com.sacoding.feature_exam.R
import com.sacoding.feature_exam.domain.ExamEvent
import com.sacoding.feature_exam.presentation.ExamViewModel

@Composable
fun ResultScreen(
    viewModel: ExamViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Padding.MEDIUM),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (viewModel.state.value.enteredSentence.isNotBlank()) {
            Text(
                modifier = Modifier
                    .wrapContentSize(),
                text = viewModel.state.value.sentence,
                fontWeight = FontWeight.Bold,
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = Padding.MEDIUM)
                    .border(
                        width = 2.dp,
                        color = if (viewModel.isCorrectAnswer()) Color.Green else Color.Red,
                        shape = RoundedCornerShape(4.dp)
                    ),
            ) {
                Text(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(Padding.MEDIUM),
                    text = viewModel.state.value.enteredSentence,
                )
            }
            Button(
                modifier = Modifier
                    .wrapContentSize(),
                onClick = {
                    viewModel.onEvent(ExamEvent.StartGame)
                },
            ) {
                Text(text = stringResource(R.string.start_game))
            }
        } else {
            Button(
                modifier = Modifier.size(160.dp),
                shape = CircleShape,
                contentPadding = PaddingValues(Padding.MEDIUM),
                onClick = {
                    viewModel.onEvent(ExamEvent.StartGame)
                },
            ) {
                Text(
                    text = stringResource(R.string.start_game),
                    fontWeight = FontWeight.Bold,
                    fontSize = FontSize.LARGE
                )
            }
        }
    }
}