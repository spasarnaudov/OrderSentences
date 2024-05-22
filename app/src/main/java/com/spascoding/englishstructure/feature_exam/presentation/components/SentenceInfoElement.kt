package com.spascoding.englishstructure.feature_exam.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    Column(
        modifier = Modifier.padding(Padding.MEDIUM),
    ) {
        Text(
            text = sentence.value,
            fontWeight = FontWeight.Bold,
        )
        Text(text = sentence.userValue)
        Text(
            text = stringResource(
                R.string.mistakes_sentences,
                sentence.mistakeCount,
                sentence.usedCount
            )
        )
    }
}