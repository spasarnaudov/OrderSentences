package com.spascoding.englishstructure.feature_exam.presentation.tense_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.spascoding.englishstructure.core.constants.Padding
import com.spascoding.englishstructure.feature_exam.domain.enums.Tense
import com.spascoding.englishstructure.feature_exam.domain.model.getTenseInfo
import com.spascoding.englishstructure.feature_exam.presentation.components.AccuracyInfo
import com.spascoding.englishstructure.feature_exam.presentation.tense_screen.TenseScreenViewModel

data class TenseButtonObject(
    val tense: Tense,
    val tenseColor: Color,
    val tenseText: String,
    val exampleText: String,
)

@Composable
fun TenseButton(
    modifier: Modifier,
    tenseButtonObject: TenseButtonObject,
    viewModel: TenseScreenViewModel = hiltViewModel(),
    onClick: () -> Unit
) {
    Box {
        Column(
            modifier = modifier
                .clickable(
                    onClick = onClick,
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(color = Color.DarkGray)
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
                text = tenseButtonObject.tenseText,
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
                text = tenseButtonObject.exampleText,
                color = Color.Black,
                textAlign = TextAlign.Center,
            )

            val tenseInfoList by viewModel.getTenseInfoFlow().collectAsState(initial = emptyList())
            AccuracyInfo(
                accuracy = tenseInfoList.getTenseInfo(tenseButtonObject.tense).accuracy,
                sentenceCount = tenseInfoList.getTenseInfo(tenseButtonObject.tense).sentenceCount,
                textColor = Color.Black
            )
        }
    }
}