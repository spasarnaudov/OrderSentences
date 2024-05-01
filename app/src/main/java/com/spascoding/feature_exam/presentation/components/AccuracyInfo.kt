package com.spascoding.feature_exam.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import com.spascoding.core.constants.FontSize
import com.spascoding.core.constants.Padding

@Composable
fun AccuracyInfo(
    progress: Int,
    lastSentenceCount: Int,
    sentenceCount: Int,
) {
    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = Padding.SMALL,
                    end = Padding.SMALL,
                ),
            text = "${progress}%",
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
                append("accuracy of last\n")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("$lastSentenceCount")
                }
                if (lastSentenceCount < sentenceCount) {
                    append(" from ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("$sentenceCount")
                    }
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