package com.spascoding.feature_exam.presentation.tens_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.spascoding.core.constants.Colors
import com.spascoding.core.constants.FontSize
import com.spascoding.core.constants.Padding
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.presentation.Screen

@Composable
fun TensScreen(
    navController: NavController,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Titles()
        Divider()
        TensRow(
            modifier = Modifier.weight(1f),
            tens1 = Tens.PAST_SIMPLE,
            tens2 = Tens.PRESENT_SIMPLE,
            tens3 = Tens.FUTURE_SIMPLE,
            tensText = "simple",
            example1 = "worked",
            example2 = "work",
            example3 = "will work",
            navController = navController,
        )
        Divider()
        TensRow(
            modifier = Modifier.weight(1f),
            tens1 = Tens.PAST_PERFECT,
            tens2 = Tens.PRESENT_PERFECT,
            tens3 = Tens.FUTURE_PERFECT,
            tensText = "perfect",
            example1 = "had worked",
            example2 = "have worked",
            example3 = "will have worked",
            navController = navController,
        )
        Divider()
        TensRow(
            modifier = Modifier.weight(1f),
            tens1 = Tens.PAST_CONTINUOUS,
            tens2 = Tens.PRESENT_CONTINUOUS,
            tens3 = Tens.FUTURE_CONTINUOUS,
            tensText = "continuous",
            example1 = "was working",
            example2 = "am working",
            example3 = "will be working",
            navController = navController,
        )
        Divider()
        TensRow(
            modifier = Modifier.weight(1f),
            tens1 = Tens.PAST_PERFECT_CONTINUOUS,
            tens2 = Tens.PRESENT_PERFECT_CONTINUOUS,
            tens3 = Tens.FUTURE_PERFECT_CONTINUOUS,
            tensText = "perfect continuous",
            example1 = "has been working",
            example2 = "have been working",
            example3 = "will have been working",
            navController = navController,
        )
    }
}

@Composable
fun Titles() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .background(Colors.Blue)
                .padding(vertical = Padding.SMALL),
            text = "Past",
            color = Color.Black,
            fontSize = FontSize.LARGE,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .background(Colors.Yellow)
                .padding(vertical = Padding.SMALL),
            text = "Present",
            color = Color.Black,
            fontSize = FontSize.LARGE,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .background(Colors.Red)
                .padding(vertical = Padding.SMALL),
            text = "Future",
            color = Color.Black,
            fontSize = FontSize.LARGE,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun TensRow(
    modifier: Modifier,
    tens1: Tens,
    tens2: Tens,
    tens3: Tens,
    color1: Color = Colors.Blue,
    color2: Color = Colors.Yellow,
    color3: Color = Colors.Red,
    tensText: String,
    example1: String,
    example2: String,
    example3: String,
    navController: NavController,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        TensButton(
            modifier = Modifier
                .weight(1f)
                .background(color1),
            tens = tens1,
            tensText = tensText,
            exampleText = example1,
            navController = navController,
        )
        TensButton(
            modifier = Modifier
                .weight(1f)
                .background(color2),
            tens = tens2,
            tensText = tensText,
            exampleText = example2,
            navController = navController,
        )
        TensButton(
            modifier = Modifier
                .weight(1f)
                .background(color3),
            tens = tens3,
            tensText = tensText,
            exampleText = example3,
            navController = navController,
        )
    }
}

@Composable
fun TensButton(
    modifier: Modifier,
    tens: Tens,
    tensText: String,
    exampleText: String,
    navController: NavController,
    viewModel: TensScreenViewModel = hiltViewModel(),
) {
    Column(modifier = modifier
        .fillMaxHeight()
        .clickable(
            enabled = true,
            onClick = {
                viewModel.onEvent(TensScreenEventEvent.SelectTens(tens = tens))
                navController.navigate(Screen.ExamList.route)
            }
        )
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = Padding.SMALL,
                    start = Padding.SMALL,
                    end = Padding.SMALL,
                ),
            text = tensText,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .wrapContentHeight(align = Alignment.CenterVertically)
                .padding(horizontal = Padding.SMALL),
            text = exampleText,
            color = Color.Black,
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = Padding.SMALL,
                    end = Padding.SMALL,
                ),
            text = "${viewModel.getProgress(tens)}%",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = FontSize.LARGE,
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = Padding.SMALL,
                    start = Padding.SMALL,
                    end = Padding.SMALL,
                ),
            text = buildAnnotatedString {
                append("accuracy of\n")
                append("last ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("${viewModel.getSentencesCount(tens)}")
                }
                append(" sentences")
            },
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontSize = FontSize.SMALL,
            lineHeight = FontSize.SMALL,
        )
    }
}

@Composable
fun Divider() {
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(),
        thickness = 1.dp,
        color = Color.Black
    )
}