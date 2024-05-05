package com.spascoding.englishstructure.feature_exam.presentation.topics_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.spascoding.englishstructure.core.constants.FontSize
import com.spascoding.englishstructure.core.constants.Padding
import com.spascoding.englishstructure.feature_exam.presentation.Screen
import com.spascoding.englishstructure.feature_exam.presentation.topics_screen.components.TopicElement

@Composable
fun TopicsScreen(
    navController: NavController,
    viewModel: TopicsViewModel = hiltViewModel(),
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(viewModel.state.value.tens.color)
                .padding(
                    vertical = Padding.MEDIUM,
                ),
            text = viewModel.state.value.tens.value,
            fontSize = FontSize.LARGE,
            textAlign = TextAlign.Center,
            color = Color.Black,
        )
        LazyVerticalStaggeredGrid(
            modifier = Modifier.fillMaxSize(),
            columns = StaggeredGridCells.Fixed(3),
        ) {
            items(viewModel.state.value.topics) { topic ->
                TopicElement(
                    onClickItem = {
//                                viewModel.onEvent(ExamListEvent.SelectExam(examName))
                        navController.navigate(Screen.ExamScreen.route + "?tens=${viewModel.state.value.tens.int}&topic=$topic")
                    },
                    onClickInfo = {
//                                viewModel.onEvent(ExamListEvent.SelectExam(examName))
                        navController.navigate(Screen.TopicDetailScreen.route + "?tens=${viewModel.state.value.tens.int}&topic=$topic")
                    },
                    topic = topic,
                )
            }
        }
    }
}