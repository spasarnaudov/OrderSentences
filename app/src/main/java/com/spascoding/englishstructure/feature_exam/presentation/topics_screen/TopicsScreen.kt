package com.spascoding.englishstructure.feature_exam.presentation.topics_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.spascoding.englishstructure.core.constants.FontSize
import com.spascoding.englishstructure.core.constants.Padding
import com.spascoding.englishstructure.feature_exam.domain.model.getTenseInfo
import com.spascoding.englishstructure.feature_exam.presentation.Screen
import com.spascoding.englishstructure.feature_exam.presentation.components.CircularProgressBar
import com.spascoding.englishstructure.feature_exam.presentation.components.ListElement
import com.spascoding.englishstructure.feature_exam.presentation.utils.upperFirstLetter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopicsScreen(
    navController: NavController,
    viewModel: TopicsViewModel = hiltViewModel(),
) {
    val topicInfoList by viewModel.getTopicInfoFlow().collectAsState(initial = emptyList())
    val topics by viewModel.getTopics().collectAsState(initial = emptyList())
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    var accuracySum = 0f
    var usedSentenceCount = 0;
    var sentenceCountSum = 0
    topics.forEach { topic ->
        val tenseInfo = topicInfoList.getTenseInfo(topic)
        val accuracy = tenseInfo.accuracy
        accuracySum += accuracy
        if (accuracy > 0) {
            usedSentenceCount+=1
        }
        sentenceCountSum += tenseInfo.sentenceCount
    }
    if (usedSentenceCount > 0) {
        accuracySum /= usedSentenceCount
    }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    titleContentColor = MaterialTheme.colorScheme.onBackground,
                ),
                title = { Text(viewModel.state.value.tense.value.upperFirstLetter()) },
                scrollBehavior = scrollBehavior,
            )
        },
    ) { innerPadding ->
        LazyVerticalStaggeredGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            columns = StaggeredGridCells.Fixed(1),
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(Padding.MEDIUM),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    CircularProgressBar(
                        modifier = Modifier.padding(bottom = Padding.SMALL),
                        percentage = accuracySum,
                        fontSize = FontSize.EXTRA_LARGE,
                        radius = 72.dp,
                        strokeWidth = 8.dp,
                        description = "Accuracy"
                    )
                    Text(text = "Sentences: $sentenceCountSum")
                }
            }
            items(topics) { topic ->
                val topicInfo = topicInfoList.getTenseInfo(topic)
                ListElement(
                    mainText = topic.upperFirstLetter(),
                    progressPercentage = topicInfo.accuracy,
                    sentenceCount = topicInfo.sentenceCount,
                ) {
                    navController.navigate(Screen.ExamScreen.route + "?tense=${viewModel.state.value.tense.int}&topic=$topic")
                }
            }
        }
    }
}