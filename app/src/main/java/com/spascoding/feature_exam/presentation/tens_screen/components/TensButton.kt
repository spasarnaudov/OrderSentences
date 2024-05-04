package com.spascoding.feature_exam.presentation.tens_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.spascoding.core.constants.FontSize
import com.spascoding.core.constants.Padding
import com.spascoding.core.constants.RoundCorner
import com.spascoding.feature_exam.R
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.presentation.components.AccuracyInfo
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
    viewModel: TensScreenViewModel = hiltViewModel(),
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .clickable(
                enabled = !viewModel.isTensLocked(tensButtonObject.tens),
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
        if (viewModel.isTensLocked(tensButtonObject.tens)) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        bottom = Padding.MEDIUM,
                        start = Padding.SMALL,
                        end = Padding.SMALL,
                    )
                    .background(Color.Black.copy(alpha = 0.1f), RoundedCornerShape(RoundCorner.SMALL))
                    .border(1.dp, Color.Black, RoundedCornerShape(RoundCorner.SMALL)),
                text = stringResource(R.string.locked),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = FontSize.LARGE,
                textAlign = TextAlign.Center,
            )
        } else {
            AccuracyInfo(
                progress = viewModel.getAccuracy(tensButtonObject.tens),
                lastSentenceCount = viewModel.getLastSentencesCount(tensButtonObject.tens),
                sentenceCount = viewModel.getSentencesCount(tensButtonObject.tens),
                textColor = Color.Black
            )
        }
    }
}