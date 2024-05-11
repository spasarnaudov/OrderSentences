package com.spascoding.englishstructure.feature_exam.presentation.topics_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.spascoding.englishstructure.core.constants.Padding
import com.spascoding.englishstructure.core.constants.RoundCorner
import com.spascoding.englishstructure.feature_exam.domain.model.getTenseInfo
import com.spascoding.englishstructure.feature_exam.presentation.topics_screen.TopicsViewModel
import com.spascoding.englishstructure.feature_exam.presentation.components.AccuracyInfo
import com.spascoding.englishstructure.feature_exam.presentation.utils.upperFirstLetter

@Composable
fun TopicElement(
    onClickItem: () -> Unit,
    onClickInfo: () -> Unit,
    topic: String,
    viewModel: TopicsViewModel = hiltViewModel(),
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(Padding.SMALL)
        .background(MaterialTheme.colorScheme.background, RoundedCornerShape(RoundCorner.SMALL))
        .border(1.dp, MaterialTheme.colorScheme.onBackground, RoundedCornerShape(RoundCorner.SMALL))
        .clickable(
            enabled = true,
            onClick = {
                onClickItem.invoke()
            }
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            onClick = onClickInfo
        ) {
            Icon(Icons.Default.Info, contentDescription = null)
        }
        Text(
            modifier = Modifier.padding(bottom = Padding.SMALL),
            text = topic.upperFirstLetter(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        val tenseInfoList by viewModel.getTopicInfoFlow().collectAsState(initial = emptyList())
        AccuracyInfo(
            progress = tenseInfoList.getTenseInfo(topic).accuracy,
            lastSentenceCount = tenseInfoList.getTenseInfo(topic).sentenceCount,
            sentenceCount = tenseInfoList.getTenseInfo(topic).sentenceCount,
        )
    }
}