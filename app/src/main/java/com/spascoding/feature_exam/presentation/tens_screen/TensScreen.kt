package com.spascoding.feature_exam.presentation.tens_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.spascoding.core.constants.Colors
import com.spascoding.core.constants.FontSize
import com.spascoding.core.constants.Padding
import com.spascoding.core.presentation.Table
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.presentation.tens_screen.components.TensButton
import com.spascoding.feature_exam.presentation.tens_screen.components.TensButtonObject

data class TitleObject(
    val text: String,
    val tensColor: Color,
)

@Composable
fun TensScreen(
    navController: NavController,
) {
    val titles = listOf(
        TitleObject("Past", Colors.Blue),
        TitleObject("Present", Colors.Yellow),
        TitleObject("Future", Colors.Red),
    )
    val cellsInfo = listOf(
        TensButtonObject(Tens.PAST_SIMPLE, Colors.Blue, "simple", "worked"),
        TensButtonObject(Tens.PRESENT_SIMPLE, Colors.Yellow, "simple", "work"),
        TensButtonObject(Tens.FUTURE_SIMPLE, Colors.Red, "simple", "will work"),

        TensButtonObject(Tens.PAST_PERFECT, Colors.Blue, "perfect", "had worked"),
        TensButtonObject(Tens.PRESENT_PERFECT, Colors.Yellow, "perfect", "have worked"),
        TensButtonObject(Tens.FUTURE_PERFECT, Colors.Red, "perfect", "will have worked"),

        TensButtonObject(Tens.PAST_CONTINUOUS, Colors.Blue, "continuous", "was working"),
        TensButtonObject(Tens.PRESENT_CONTINUOUS, Colors.Yellow, "continuous", "am working"),
        TensButtonObject(Tens.FUTURE_CONTINUOUS, Colors.Red, "continuous", "will be working"),

        TensButtonObject(Tens.PAST_PERFECT_CONTINUOUS, Colors.Blue, "perfect continuous", "has been working"),
        TensButtonObject(Tens.PRESENT_PERFECT_CONTINUOUS, Colors.Yellow, "perfect continuous", "have been working"),
        TensButtonObject(Tens.FUTURE_PERFECT_CONTINUOUS, Colors.Red, "perfect continuous", "will have been working"),
    )
    Table(
        titles = List(titles.size) { index ->
            {
                val title = titles[index]
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(title.tensColor)
                        .padding(vertical = Padding.SMALL),
                    text = title.text,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = FontSize.LARGE,
                    fontWeight = FontWeight.Bold,
                )
            }
        },
        cells = List(cellsInfo.size) { index ->
            {
                val cellInfo = cellsInfo[index]
                Column {
                    Divider()
                    TensButton(
                        modifier = Modifier
                            .background(cellInfo.tensColor),
                        cellInfo,
                        navController = navController,
                    )
                }
            }
        },
    )
}

@Composable
fun Divider() {
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(),
        thickness = 1.dp,
        color = Color.Black
    )
}