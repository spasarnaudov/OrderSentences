package com.spascoding.feature_exam.presentation.exam_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.spascoding.core.constants.Padding
import com.spascoding.feature_exam.presentation.exam_list.ExamListViewModel
import com.spascoding.feature_exam.presentation.components.AccuracyInfo

@Composable
fun ExamElement(
    onClickItem: () -> Unit,
    onClickInfo: () -> Unit,
    examName: String,
    viewModel: ExamListViewModel = hiltViewModel(),
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable(
            enabled = true,
            onClick = {
                onClickItem.invoke()
            }
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = examName)
        IconButton(
            onClick = onClickInfo, modifier = Modifier.padding(end = Padding.SMALL)
        ) {
            Icon(Icons.Default.Info, contentDescription = null)
        }
        AccuracyInfo(
            progress = viewModel.getProgress(examName),
            sentenceCount = viewModel.getSentencesCount(examName),
        )
    }
}