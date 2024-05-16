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
import androidx.compose.ui.res.stringResource
import com.spascoding.englishstructure.R
import com.spascoding.englishstructure.core.constants.Colors
import com.spascoding.englishstructure.core.constants.Padding

@Composable
fun SuccessInfo(success: Boolean) {
    if (success) {
        Image(
            imageVector = Icons.Rounded.Check,
            modifier = Modifier
                .padding(Padding.MEDIUM)
                .background(Colors.GREEN, CircleShape),
            contentDescription = stringResource(R.string.your_answer_is_correct),
            colorFilter = ColorFilter.tint(Color.White),
        )
    } else {
        Image(
            imageVector = Icons.Rounded.Close,
            modifier = Modifier
                .padding(Padding.MEDIUM)
                .background(Color.Red, CircleShape),
            contentDescription = stringResource(R.string.your_answer_is_incorrect),
            colorFilter = ColorFilter.tint(Color.White),
        )
    }
}