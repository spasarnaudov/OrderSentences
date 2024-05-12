package com.spascoding.englishstructure.feature_exam.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import com.spascoding.englishstructure.core.constants.FontSize
import com.spascoding.englishstructure.core.constants.Padding

@Composable
fun AccuracyInfo(
    accuracy: Int,
    sentenceCount: Int,
    textColor: Color = MaterialTheme.colorScheme.onBackground,
) {
    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = Padding.SMALL,
                    end = Padding.SMALL,
                ),
            text = "${accuracy}%",
            color = textColor,
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
                append("success rate for\n")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("$sentenceCount")
                }
                append(" sentences")
            },
            color = textColor,
            textAlign = TextAlign.Center,
            fontSize = FontSize.SMALL,
            lineHeight = FontSize.SMALL,
        )
    }
}