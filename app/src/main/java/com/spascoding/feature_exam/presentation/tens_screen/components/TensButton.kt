package com.spascoding.feature_exam.presentation.tens_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.spascoding.core.constants.FontSize
import com.spascoding.core.constants.Padding
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.presentation.Screen
import com.spascoding.feature_exam.presentation.tens_screen.TensScreenEventEvent
import com.spascoding.feature_exam.presentation.tens_screen.TensScreenViewModel

data class TensButtonObject(
    val tens: Tens,
    val tensColor: Color,
    val tensText: String,
    val exampleText: String,
)

@Composable
fun TensButton(
    modifier: Modifier,
    tensButtonObject: TensButtonObject,
    navController: NavController,
    viewModel: TensScreenViewModel = hiltViewModel(),
) {
    Column(modifier = modifier
        .clickable(
            enabled = true,
            onClick = {
                viewModel.onEvent(TensScreenEventEvent.SelectTens(tens = tensButtonObject.tens))
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
            text = tensButtonObject.tensText,
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
            text = tensButtonObject.exampleText,
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
            text = "${viewModel.getProgress(tensButtonObject.tens)}%",
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
                    append("${viewModel.getSentencesCount(tensButtonObject.tens)}")
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