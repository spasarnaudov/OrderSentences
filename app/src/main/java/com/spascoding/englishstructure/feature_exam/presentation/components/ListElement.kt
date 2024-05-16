package com.spascoding.englishstructure.feature_exam.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.spascoding.englishstructure.core.constants.Padding
import com.spascoding.englishstructure.core.constants.RoundCorner

@Composable
fun ListElement(
    cellText: String,
    progressPercentage: Float,
    progressColor: Color = Color.Gray,
    onClickInfo: () -> Unit,
    onClickItem: () -> Unit,
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
        )
        .clickable(
            enabled = true,
            onClick = {
                onClickItem.invoke()
            }
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onClickInfo
        ) {
            Icon(Icons.Default.Info, contentDescription = null)
        }
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = Padding.SMALL),
            text = cellText,
            fontWeight = FontWeight.Bold
        )
        CircularProgressBar(
            percentage = progressPercentage,
            color = progressColor,
            number = 100,
        )
    }
}