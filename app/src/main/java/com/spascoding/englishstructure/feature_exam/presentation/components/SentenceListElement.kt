package com.spascoding.englishstructure.feature_exam.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.spascoding.englishstructure.R
import com.spascoding.englishstructure.core.constants.Padding
import com.spascoding.englishstructure.core.constants.RoundCorner
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.entity.Sentence

@Composable
fun SentenceListElement(
    sentence: Sentence,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = Padding.MEDIUM,
                bottom = Padding.MEDIUM,
                end = Padding.MEDIUM,
            )
            .background(
                MaterialTheme.colorScheme.primary.copy(alpha = 0.15f),
                RoundedCornerShape(RoundCorner.MEDIUM)
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.primary,
                RoundedCornerShape(RoundCorner.MEDIUM)
            )
            .clip(RoundedCornerShape(RoundCorner.MEDIUM)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .height(100.dp) //TODO extract to constant or something else
                .width(Padding.SMALL)
                .background(MaterialTheme.colorScheme.primary),
            text = ""
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(
                    top = Padding.MEDIUM,
                    start = Padding.SMALL,
                    bottom = Padding.MEDIUM,
                ),
        ) {
            Text(
                text = sentence.value,
                fontWeight = FontWeight.Bold,
            )
            Text(text = sentence.userValue)
            Text(text = stringResource(
                R.string.mistakes_sentences,
                sentence.mistakeCount,
                sentence.usedCount
            ))
        }
        if (sentence.usedCount > 0) {
            Icon(
                modifier = Modifier.padding(end = Padding.MEDIUM),
                imageVector = if (sentence.mistakeCount == 0) Icons.Default.Check else Icons.Default.Close,
                contentDescription = null
            )
        }
    }
}