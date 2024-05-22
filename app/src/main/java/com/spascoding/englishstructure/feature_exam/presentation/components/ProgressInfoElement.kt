package com.spascoding.englishstructure.feature_exam.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.spascoding.englishstructure.core.constants.FontSize
import com.spascoding.englishstructure.core.constants.Padding

@Composable
fun ProgressInfoElement(
    title: String,
    sentenceCount: String,
    accuracy: Float,
    color: Color,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(
                    top = Padding.MEDIUM,
                    start = Padding.MEDIUM,
                    bottom = Padding.MEDIUM,
                ),
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
            )
            Text(sentenceCount)
        }
        CircularProgressBar(
            modifier = Modifier
                .padding(
                    horizontal = Padding.MEDIUM,
                    vertical = Padding.SMALL
                ),
            percentage = accuracy,
            radius = 28.dp,
            fontSize = FontSize.MEDIUM,
            color = color
        )
    }
}