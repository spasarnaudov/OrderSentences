package com.spascoding.englishstructure.feature_exam.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import com.spascoding.englishstructure.core.constants.Colors
import com.spascoding.englishstructure.core.constants.Padding

@Composable
fun SuccessInfo(success: Boolean) {
    if (success) {
        Image(
            imageVector = Icons.Rounded.Check,
            modifier = Modifier.padding(Padding.SMALL)
                .background(Colors.GREEN, CircleShape),
            contentDescription = "",
            colorFilter = ColorFilter.tint(Color.White),
        )
    } else {
        Image(
            imageVector = Icons.Rounded.Close,
            modifier = Modifier.padding(Padding.SMALL)
                .background(Color.Red, CircleShape),
            contentDescription = "",
            colorFilter = ColorFilter.tint(Color.White),
        )
    }
}