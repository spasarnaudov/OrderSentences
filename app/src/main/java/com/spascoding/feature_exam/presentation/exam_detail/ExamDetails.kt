package com.spascoding.feature_exam.presentation.exam_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.spascoding.core.constants.FontSize
import com.spascoding.core.constants.Padding
import com.spascoding.feature_exam.R
import com.spascoding.feature_exam.domain.model.info

@Composable
fun ExamDetails(
    viewModel: ExamDetailViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Padding.LARGE),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val name = viewModel.getFirstItemName()
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = Padding.MEDIUM),
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = FontSize.LARGE
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            viewModel.state.value.exam?.info()?.forEachIndexed() { index, exam ->
                item {
                    Text(
                        modifier = Modifier.fillMaxWidth()
                            .padding(bottom = Padding.SMALL),
                        text = stringResource(R.string.lessen_row_info_pattern, index + 1, exam)
                    )
                }
            }
        }
    }
}