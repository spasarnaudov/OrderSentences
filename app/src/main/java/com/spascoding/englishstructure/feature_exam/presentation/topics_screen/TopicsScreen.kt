package com.spascoding.englishstructure.feature_exam.presentation.topics_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.spascoding.englishstructure.core.constants.FontSize
import com.spascoding.englishstructure.core.constants.Padding
import com.spascoding.englishstructure.feature_exam.domain.model.getTenseInfo
import com.spascoding.englishstructure.feature_exam.presentation.Screen
import com.spascoding.englishstructure.feature_exam.presentation.components.ListElement
import com.spascoding.englishstructure.feature_exam.presentation.utils.upperFirstLetter

@Composable
fun TopicsScreen(
    navController: NavController,
    viewModel: TopicsViewModel = hiltViewModel(),
) {
    val tenseInfoList by viewModel.getTopicInfoFlow().collectAsState(initial = emptyList())
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = Padding.MEDIUM,
                ),
            text = viewModel.state.value.tense.value.upperFirstLetter(),
            fontSize = FontSize.LARGE,
            textAlign = TextAlign.Center,
        )
        val topicInfoList by viewModel.getTopics().collectAsState(initial = emptyList())
        LazyVerticalStaggeredGrid(
            modifier = Modifier.fillMaxSize(),
            columns = StaggeredGridCells.Fixed(1),
        ) {
            items(topicInfoList) { topic ->
                ListElement(
                    cellText = topic,
                    progressPercentage = tenseInfoList.getTenseInfo(topic).accuracy.toFloat() / 100f,
                    progressColor = viewModel.state.value.tense.color,
                    onClickInfo = {
                        navController.navigate(Screen.TopicDetailScreen.route + "?tense=${viewModel.state.value.tense.int}&topic=$topic")
                    },
                ) {
                    navController.navigate(Screen.ExamScreen.route + "?tense=${viewModel.state.value.tense.int}&topic=$topic")
                }
            }
        }
    }
}