package com.spascoding.englishstructure.core.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Table(
    titles: List<@Composable () -> Unit>,
    cells: List<@Composable () -> Unit>,
    columnCount: Int = if (titles.isNotEmpty()) titles.size else cells.size,
) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            for (title in titles) {
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    title.invoke()
                }
            }
        }
        for (row in cells.indices step columnCount) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
                    .weight(1f)
            ) {
                for (col in 0 until columnCount) {
                    if (row + col < cells.size) {
                        Box(
                            modifier = Modifier.weight(1f)
                        ) {
                            cells[row +col].invoke()
                        }
                    } else {
                        Box(
                            modifier = Modifier.weight(1f)
                        ) {
                            //Empty space
                        }
                    }
                }
            }
        }
    }
}