package com.spascoding.feature_exam.presentation.exam_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import com.spascoding.core.constants.Padding
import com.spascoding.feature_exam.R
import com.spascoding.feature_exam.domain.model.sentence.entity.Sentence
import com.spascoding.feature_exam.presentation.tens_screen.Divider
import kotlinx.coroutines.launch

@Composable
fun ExamScreen(
    viewModel: ExamViewModel = hiltViewModel()
) {
    val focusRequester = remember { FocusRequester() }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val underlineColor = MaterialTheme.colorScheme.onBackground
        Text(
            modifier = Modifier
                .wrapContentSize()
                .padding(
                    start = Padding.SMALL,
                    top = 64.dp,
                    end = Padding.SMALL,
                    bottom = 64.dp,
                )
                .drawBehind {
                    val strokeWidthPx = 2.dp.toPx()
                    val verticalOffset = size.height
                    drawLine(
                        color = underlineColor,
                        strokeWidth = strokeWidthPx,
                        start = Offset(0f, verticalOffset),
                        end = Offset(size.width, verticalOffset)
                    )
                },
            fontWeight = FontWeight.Bold,
            text = viewModel.getShuffledText(),
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Padding.SMALL)
                .focusRequester(focusRequester),
            value = viewModel.state.value.answerText.value,
            onValueChange = {
                viewModel.onEvent(ExamEvent.EnterText(it.text))
            },
            label = { Text(stringResource(R.string.put_the_sentence_in_the_correct_order)) },
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                focusedBorderColor = Color.Black,
//                unfocusedBorderColor = Color.Black
//            )
        )
        Button(
            modifier = Modifier
                .wrapContentSize()
                .padding(vertical = Padding.SMALL),
            enabled = viewModel.state.value.answerText.value.text.isNotBlank(),
            onClick = {
                viewModel.onEvent(ExamEvent.CheckExam(viewModel.state.value.answerText.value.text))
            },
        ) {
            Text(text = stringResource(R.string.check))
        }

        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            viewModel.viewModelScope.launch {
                viewModel.state.value.history.forEach() {
                    item {
                        ExamScreenRow(it)
                    }
                }
            }

        }
    }
}

@Composable
fun ExamScreenRow(sentence: Sentence) {
    Divider()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Padding.SMALL)
    ) {
        Text(text = sentence.value, fontWeight = FontWeight.Bold)
        Text(text = sentence.userValue)
    }
}