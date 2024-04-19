package com.spascoding.feature_exam.presentation.exam_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.text.font.FontWeight
import com.spascoding.core.constants.Padding

@Composable
fun ExamElement(
    onClickItem: () -> Unit,
    onClickInfo: () -> Unit,
    examName: String,
    tens: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClickItem.invoke() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .padding(
                    start = Padding.LARGE,
                    top = Padding.SMALL,
                    bottom = Padding.SMALL,
                )
        ) {
            Text(
                text = examName,
                fontWeight = FontWeight.Bold
            )
            Text(text = tens)
        }
        Spacer(
            Modifier
                .weight(1f)
                .fillMaxHeight())
        IconButton(
            onClick = onClickInfo,
            modifier = Modifier
                .padding(end = Padding.SMALL)
        ) {
            Icon(Icons.Default.Info, contentDescription = null)
        }
    }
}