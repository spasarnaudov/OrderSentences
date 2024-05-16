package com.spascoding.englishstructure.feature_exam.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.spascoding.englishstructure.core.constants.Padding
import com.spascoding.englishstructure.core.constants.RoundCorner

@Composable
fun RecentElement(
    sentence: String,
    userSentence: String,
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(
            start = Padding.MEDIUM,
            bottom = Padding.MEDIUM,
            end = Padding.MEDIUM,
        )
        .background(MaterialTheme.colorScheme.background, RoundedCornerShape(RoundCorner.MEDIUM))
        .border(
            1.dp,
            MaterialTheme.colorScheme.onBackground,
            RoundedCornerShape(RoundCorner.MEDIUM)
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(
                    bottom = Padding.SMALL,
                    start = Padding.MEDIUM,
                    top = Padding.SMALL,
                ),
        ) {
            Text(
                text = sentence,
                fontWeight = FontWeight.Bold
            )
            Text(text = userSentence)
        }
        SuccessInfo(sentence == userSentence)
    }
}