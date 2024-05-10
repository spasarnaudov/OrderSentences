package com.spascoding.englishstructure.feature_exam.presentation.exam_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import com.spascoding.englishstructure.R
import com.spascoding.englishstructure.core.constants.FontSize
import com.spascoding.englishstructure.core.constants.Padding
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.entity.Sentence
import com.spascoding.englishstructure.feature_exam.presentation.components.SuccessInfo
import kotlinx.coroutines.launch

@Composable
fun ExamScreen(
    viewModel: ExamViewModel = hiltViewModel()
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(viewModel.state.value.tense.color)
                .padding(
                    vertical = Padding.MEDIUM,
                ),
            text = viewModel.state.value.tense.value,
            fontSize = FontSize.LARGE,
            textAlign = TextAlign.Center,
            color = Color.Black,
        )
        UnderlinedText(text = viewModel.getShuffledText())
        InputText()
        Button(
            modifier = Modifier
                .wrapContentSize()
                .padding(vertical = Padding.SMALL),
            onClick = {
                viewModel.onEvent(ExamEvent.CheckExam(viewModel.state.value.answerText.value.text))
            },
        ) {
            Text(text = stringResource(R.string.check))
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
fun UnderlinedText(text: AnnotatedString) {
    val onBackgroundColor = MaterialTheme.colorScheme.onBackground
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
                    color = onBackgroundColor,
                    strokeWidth = strokeWidthPx,
                    start = Offset(0f, verticalOffset),
                    end = Offset(size.width, verticalOffset)
                )
            },
        fontWeight = FontWeight.Bold,
        text = text,
    )
}

@Composable
fun InputText(
    viewModel: ExamViewModel = hiltViewModel()
) {
    val focusRequester = remember { FocusRequester() }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Padding.SMALL)
            .focusRequester(focusRequester),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Go),
        keyboardActions = KeyboardActions(
            onGo = {
                viewModel.onEvent(ExamEvent.CheckExam(viewModel.state.value.answerText.value.text))
            }
        ),
        value = viewModel.state.value.answerText.value,
        onValueChange = {
            viewModel.onEvent(ExamEvent.EnterText(it.text))
        },
        label = { Text(stringResource(R.string.put_the_sentence_in_the_correct_order)) },
    )
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}

@Composable
fun ExamScreenRow(sentence: Sentence) {
    Divider()
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        SuccessInfo(sentence.value == sentence.userValue)
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(Padding.SMALL)
        ) {
            Text(text = sentence.value, fontWeight = FontWeight.Bold)
            Text(text = sentence.userValue)
        }
    }

}

@Composable
fun Divider() {
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(),
        thickness = 1.dp,
        color = MaterialTheme.colorScheme.onBackground
    )
}