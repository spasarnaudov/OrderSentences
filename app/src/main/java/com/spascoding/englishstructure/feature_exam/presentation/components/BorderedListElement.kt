package com.spascoding.englishstructure.feature_exam.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.spascoding.englishstructure.core.constants.Padding
import com.spascoding.englishstructure.core.constants.RoundCorner

@Composable
fun BorderedListElement(
    borderColor: Color = MaterialTheme.colorScheme.primary,
    onClickItem: (() -> Unit)? = null,
    content: @Composable RowScope.() -> Unit,
) {
    val localDensity = LocalDensity.current
    var heightIs by remember {
        mutableStateOf(0.dp)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = Padding.MEDIUM,
                bottom = Padding.MEDIUM,
                end = Padding.MEDIUM,
            )
            .background(
                borderColor.copy(alpha = 0.05f),
                RoundedCornerShape(RoundCorner.MEDIUM)
            )
            .border(
                1.dp,
                borderColor,
                RoundedCornerShape(RoundCorner.MEDIUM)
            )
            .clip(RoundedCornerShape(RoundCorner.MEDIUM))
            .clickable(
                enabled = true,
                onClick = {
                    onClickItem?.invoke()
                }
            )
            .onGloballyPositioned { coordinates ->
                heightIs = with(localDensity) { coordinates.size.height.toDp() }
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .height(heightIs)
                .width(Padding.SMALL)
                .background(
                    borderColor,
                )
        )
        content.invoke(this)
    }
}