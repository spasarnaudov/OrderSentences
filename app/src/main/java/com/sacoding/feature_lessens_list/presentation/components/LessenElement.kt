package com.sacoding.feature_lessens_list.presentation.components

import androidx.compose.foundation.clickable
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
import com.sacoding.core.constants.Padding

@Composable
fun LessenElement(
    onClickItem: () -> Unit,
    onClickInfo: () -> Unit,
    lessenName: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClickItem.invoke() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = lessenName,
            modifier = Modifier
                .padding(start = Padding.LARGE)
        )
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