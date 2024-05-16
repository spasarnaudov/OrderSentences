package com.spascoding.englishstructure.feature_exam.presentation.topics_screen

import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.spascoding.englishstructure.feature_exam.domain.model.getTenseInfo
import com.spascoding.englishstructure.feature_exam.presentation.Screen
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
            items(topics) { topic ->
                ListElement(
                    cellText = topic,
                    progressPercentage = topicInfoList.getTenseInfo(topic).accuracy.toFloat() / 100f,
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