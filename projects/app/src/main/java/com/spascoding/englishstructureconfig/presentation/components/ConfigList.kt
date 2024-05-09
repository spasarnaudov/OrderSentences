package com.spascoding.englishstructureconfig.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.spascoding.englishstructureconfig.presentation.ConfigViewModel

@Composable
fun ConfigList(
    viewModel: ConfigViewModel = hiltViewModel()
) {
    val showDialog = remember { mutableStateOf(false) }
    val rememberParameter = remember { mutableStateOf("") }
    val rememberValue = remember { mutableStateOf("") }

    if (showDialog.value)
        CustomDialog(
            parameter = rememberParameter.value,
            value = rememberValue.value,
            setShowDialog = {
                showDialog.value = it
            }
        ) {
            if (it.isNotBlank()) {
                viewModel.setConfig(rememberParameter.value, it)
            }
        }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier.padding(vertical = 8.dp),
            onClick = {
                viewModel.syncFirebase()
            }) {
            Text(text = "Load from Firebase")
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            viewModel.state.value.config.forEach { (parameter, value) ->
                item {
                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(),
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                showDialog.value = true
                                rememberParameter.value = parameter
                                rememberValue.value = value
                            }
                            .wrapContentHeight()
                            .padding(start = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            modifier = Modifier.weight(1f),
                        ) {
                            val onBackgroundColor = MaterialTheme.colorScheme.onBackground
                            Text(
                                modifier = Modifier
                                    .drawBehind {
                                        val strokeWidthPx = 1.dp.toPx()
                                        val verticalOffset = size.height - 2.dp.toPx()
                                        drawLine(
                                            color = onBackgroundColor,
                                            strokeWidth = strokeWidthPx,
                                            start = Offset(0f, verticalOffset),
                                            end = Offset(size.width, verticalOffset)
                                        )
                                    },
                                text = parameter,
                                fontWeight = FontWeight.Bold,
                            )
                            Text(
                                text = value,
                            )
                        }
                        Icon(
                            modifier = Modifier.padding(16.dp),
                            imageVector = Icons.Default.Edit,
                            contentDescription = ""
                        )
                    }
                }
            }
        }
    }
}