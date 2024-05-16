package com.spascoding.englishstructure.core.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import com.spascoding.englishstructure.core.constants.Padding

@Composable
fun MinimalDialog(
    text: String,
    onDismissRequest: () -> Unit,
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            shape = RoundedCornerShape(Padding.MEDIUM),
        ) {
            Column(
                modifier = Modifier.padding(Padding.MEDIUM),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier.padding(bottom = Padding.MEDIUM),
                    imageVector = Icons.Default.Info,
                    contentDescription = null
                )
                Text(text)
            }
        }
    }
}