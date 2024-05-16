package com.spascoding.englishstructure.feature_exam.presentation.exam_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.spascoding.englishstructure.R
import com.spascoding.englishstructure.core.constants.Padding
import com.spascoding.englishstructure.feature_exam.presentation.Screen
import com.spascoding.englishstructure.feature_exam.presentation.components.ListElement
import com.spascoding.englishstructure.feature_exam.presentation.utils.upperFirstLetter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExamScreen(
    navController: NavController,
    viewModel: ExamViewModel = hiltViewModel()
) {
    val recentSentences by viewModel.getRecentSentences().collectAsState(initial = emptyList())
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    titleContentColor = MaterialTheme.colorScheme.onBackground,
                ),
                title = { Text("${viewModel.state.value.topic.upperFirstLetter()} (${viewModel.state.value.tense.value.upperFirstLetter()})") },
                scrollBehavior = scrollBehavior,
            )
        },
    ) { innerPadding ->
        LazyVerticalStaggeredGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            columns = StaggeredGridCells.Fixed(1),
        ) {
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    UnderlinedText(text = viewModel.getShuffledText())
                    InputText()
                    Button(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(vertical = Padding.SMALL),
                        onClick = {
                            viewModel.onEvent(ExamEvent.CheckExam(viewModel.state.value.answerText))
                        },
                    ) {
                        Text(text = stringResource(R.string.check))
                    }
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(Padding.MEDIUM),
                        text = stringResource(R.string.recent),
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
            itemsIndexed(recentSentences) { i, recentSentence ->
                ListElement(
                    mainText = recentSentence.value,
                    additionalText = recentSentence.userValue,
                    progressPercentage = if (recentSentence.usedCount == 0) 0f else (recentSentence.usedCount.toFloat() - recentSentence.mistakeCount.toFloat()) / recentSentence.usedCount.toFloat(),
                    sentenceCount = recentSentence.usedCount,
                ) {
                    navController.navigate(Screen.TopicDetailScreen.route + "?tense=${viewModel.state.value.tense.int}&topic=${viewModel.state.value.topic}")
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
            .padding(Padding.MEDIUM)
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
            .padding(horizontal = Padding.MEDIUM)
            .focusRequester(focusRequester),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Go,
            capitalization = KeyboardCapitalization.Sentences,
        ),
        keyboardActions = KeyboardActions(
            onGo = {
                viewModel.onEvent(ExamEvent.CheckExam(viewModel.state.value.answerText))
            }
        ),
        value = viewModel.state.value.answerText,
        onValueChange = {
            viewModel.onEvent(ExamEvent.EnterText(it))
        },
        label = { Text(stringResource(R.string.put_the_sentence_in_the_correct_order)) },
    )
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}