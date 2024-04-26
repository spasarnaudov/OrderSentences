package com.spascoding.feature_exam.presentation.exam_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.spascoding.core.constants.FontSize
import com.spascoding.core.constants.Padding
import com.spascoding.feature_exam.R
import com.spascoding.feature_exam.domain.model.sentence.entity.Sentence

@Composable
fun ExamDetails(
    viewModel: ExamDetailViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Padding.SMALL)
    ) {
        DetailsRowDescription()
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            viewModel.state.value.sentences.forEachIndexed() { index, sentence ->
                item {
                    DetailsRow(index = index, sentence = sentence)
                }
            }
        }
    }
}

@Composable
fun DetailsRowDescription() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(R.string.use_mistake_ratio_pattern_description),
            textAlign = TextAlign.End,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun DetailsRow(
    index: Int,
    sentence: Sentence,
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(R.string.lessen_row_info_pattern, index + 1, sentence.value)
        )
        Text(
            text = stringResource(R.string.use_mistake_ratio_pattern, sentence.useCount, sentence.mistakeCount)
        )
    }

}