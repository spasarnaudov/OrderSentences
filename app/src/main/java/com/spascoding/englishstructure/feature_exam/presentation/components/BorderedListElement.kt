package com.spascoding.englishstructure.feature_exam.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.spascoding.englishstructure.core.constants.Padding
import com.spascoding.englishstructure.core.constants.RoundCorner

@Composable
fun BorderedListElement(
    onClickItem: (() -> Unit)? = null,
    content: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Padding.MEDIUM)
            .background(
                MaterialTheme.colorScheme.primary.copy(alpha = 0.02f),
                RoundedCornerShape(RoundCorner.MEDIUM)
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                RoundedCornerShape(RoundCorner.MEDIUM)
            )
            .clip(RoundedCornerShape(RoundCorner.MEDIUM))
            .clickable(
                enabled = true,
                onClick = {
                    onClickItem?.invoke()
                }
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        content.invoke(this)
    }
}