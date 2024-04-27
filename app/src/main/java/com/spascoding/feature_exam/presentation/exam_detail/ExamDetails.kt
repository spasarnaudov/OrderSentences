package com.spascoding.feature_exam.presentation.exam_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(viewModel.state.value.tens.color)
                .padding(
                    vertical = Padding.MEDIUM,
                ),
            text = viewModel.state.value.tens.value,
            fontSize = FontSize.LARGE,
            textAlign = TextAlign.Center,
            color = Color.Black,
        )
        DetailsRowDescription()
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Padding.SMALL)
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
        modifier = Modifier
            .fillMaxWidth()
            .padding(Padding.SMALL)
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