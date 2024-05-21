package com.spascoding.englishstructure.feature_exam.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.spascoding.englishstructure.R
import com.spascoding.englishstructure.core.constants.Padding
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.entity.Sentence

@Composable
fun SentenceInfoElement(
    sentence: Sentence
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
                text = sentence.value,
                fontWeight = FontWeight.Bold,
            )
            Text(text = sentence.userValue)
            Text(text = stringResource(
                R.string.mistakes_sentences,
                sentence.mistakeCount,
                sentence.usedCount
            )
            )
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