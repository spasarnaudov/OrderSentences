package com.spascoding.feature_exam.presentation.exam_screen

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.spascoding.feature_exam.R

@Composable
fun InputScreen(
    viewModel: ExamViewModel = hiltViewModel()
) {
    var answerText by remember { mutableStateOf(TextFieldValue(text = viewModel.state.value.enteredSentence, selection = TextRange(viewModel.state.value.enteredSentence.length))) }
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
                viewModel.onEvent(ExamEvent.EnterText(answerText.text))
            },
            label = { Text(stringResource(R.string.put_the_sentence_in_the_correct_order)) },
        )
        Button(
            modifier = Modifier
                .wrapContentSize(),
            enabled = answerText.text.isNotBlank(),
            onClick = {
                viewModel.onEvent(ExamEvent.EndExam(answerText.text))
            },
        ) {
            Text(text = stringResource(R.string.finish_game))
        }

        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
    }
}