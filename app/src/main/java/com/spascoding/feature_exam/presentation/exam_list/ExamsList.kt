package com.spascoding.feature_exam.presentation.exam_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.spascoding.core.constants.FontSize
import com.spascoding.core.constants.Padding
import com.spascoding.feature_exam.presentation.Screen
import kotlinx.coroutines.launch

@Composable
fun ExamsList(
    navController: NavController,
    viewModel: ExamListViewModel = hiltViewModel(),
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
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            viewModel.viewModelScope.launch {
                viewModel.state.value.exams.forEach() { examName ->
                    item {
                        ExamElement(
                            onClickItem = {
//                                viewModel.onEvent(ExamListEvent.SelectExam(examName))
                                navController.navigate(Screen.ExamScreen.route + "?tens=${viewModel.state.value.tens.int}&examName=$examName")
                            },
                            onClickInfo = {
//                                viewModel.onEvent(ExamListEvent.SelectExam(examName))
                                navController.navigate(Screen.ExamDetail.route + "?tens=${viewModel.state.value.tens.int}&examName=$examName")
                            },
                            examName = examName,
                        )
                    }
                }
            }
        }
    }
}