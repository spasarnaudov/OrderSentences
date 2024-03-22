package com.example.ordersentences.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ordersentences.domain.model.Verb

@Composable
fun InfoDialog(verbs: List<Verb>, showDialog: MutableState<Boolean>) {
    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text(text = "Verbs Info") },
            text = {
                Column {
                    TableTow(
                        value1 = "Verb",
                        value2 = "Use count",
                        value3 = "Mistake count",
                        align1 = TextAlign.Start,
                        align2 = TextAlign.Center,
                        align3 = TextAlign.Center,
                    )
                    LazyColumn {
                        items(verbs.size) { i ->
                            TableTow(
                                value1 = verbs[i].baseForm,
                                value2 = "${verbs[i].useCount}",
                                value3 = "${verbs[i].mistakeCount}",
                                align1 = TextAlign.Start,
                                align2 = TextAlign.End,
                                align3 = TextAlign.End,
                            )
                        }
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = { showDialog.value = false }
                ) {
                    Text("Close")
                }
            }
        )
    }
}

@Composable
private fun TableTow(
    value1: String,
    value2: String,
    value3: String,
    align1: TextAlign,
    align2: TextAlign,
    align3: TextAlign,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.weight(4f),
            text = value1,
            textAlign = align1,
        )
        Text(
            modifier = Modifier.weight(3f),
            text = value2,
            textAlign = align2,
        )
        Text(
            modifier = Modifier.weight(3f),
            text = value3,
            textAlign = align3,
        )
    }
}