package com.spascoding.englishstructure.feature_exam.presentation.tense_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.spascoding.englishstructure.core.constants.Colors
import com.spascoding.englishstructure.core.constants.FontSize
import com.spascoding.englishstructure.core.constants.Padding
import com.spascoding.englishstructure.core.presentation.MinimalDialog
import com.spascoding.englishstructure.core.presentation.Table
import com.spascoding.englishstructure.feature_exam.domain.enums.Tense
import com.spascoding.englishstructure.feature_exam.domain.enums.getPreviewsTense
import com.spascoding.englishstructure.feature_exam.presentation.Screen
import com.spascoding.englishstructure.feature_exam.presentation.tense_screen.components.TenseButton
import com.spascoding.englishstructure.feature_exam.presentation.tense_screen.components.TenseButtonObject

data class TitleObject(
    val text: String,
    val tenseColor: Color,
)

@Composable
fun TenseScreen(
    navController: NavController,
    viewModel: TenseScreenViewModel = hiltViewModel(),
) {
    val titles = listOf(
        TitleObject("Past", Colors.Blue),
        TitleObject("Present", Colors.Yellow),
        TitleObject("Future", Colors.Red),
    )
    val cellsInfo = listOf(
        TenseButtonObject(Tense.PAST_SIMPLE, Colors.Blue, "simple", "worked"),
        TenseButtonObject(Tense.PRESENT_SIMPLE, Colors.Yellow, "simple", "work"),
        TenseButtonObject(Tense.FUTURE_SIMPLE, Colors.Red, "simple", "will work"),

        TenseButtonObject(Tense.PAST_PERFECT, Colors.Blue, "perfect", "had worked"),
        TenseButtonObject(Tense.PRESENT_PERFECT, Colors.Yellow, "perfect", "have worked"),
        TenseButtonObject(Tense.FUTURE_PERFECT, Colors.Red, "perfect", "will have worked"),

        TenseButtonObject(Tense.PAST_CONTINUOUS, Colors.Blue, "continuous", "was working"),
        TenseButtonObject(Tense.PRESENT_CONTINUOUS, Colors.Yellow, "continuous", "am working"),
        TenseButtonObject(Tense.FUTURE_CONTINUOUS, Colors.Red, "continuous", "will be working"),

        TenseButtonObject(Tense.PAST_PERFECT_CONTINUOUS, Colors.Blue, "perfect continuous", "has been working"),
        TenseButtonObject(Tense.PRESENT_PERFECT_CONTINUOUS, Colors.Yellow, "perfect continuous", "have been working"),
        TenseButtonObject(Tense.FUTURE_PERFECT_CONTINUOUS, Colors.Red, "perfect continuous", "will have been working"),
    )
    val error = remember { mutableStateOf("") }
    if (error.value.isNotBlank()) {
        MinimalDialog(
            error.value
        ) {
            error.value = ""
        }
    }
    Table(
        titles = List(titles.size) { index ->
            {
                val title = titles[index]
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(title.tenseColor)
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
                val tenseButtonObject = cellsInfo[index]
                Column {
                    Divider()
                    TenseButton(
                        modifier = Modifier
                            .background(tenseButtonObject.tenseColor),
                        tenseButtonObject,
                    ) {
                        navController.navigate(Screen.TopicsScreen.route + "?tense=${tenseButtonObject.tense.int}")
                    }
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