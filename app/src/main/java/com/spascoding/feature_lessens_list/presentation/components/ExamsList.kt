package com.spascoding.feature_lessens_list.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.spascoding.feature_exam.domain.ExamEvent
import com.spascoding.feature_exam.presentation.ExamViewModel
import com.spascoding.feature_exam.presentation.Screen
import kotlinx.coroutines.launch

@Composable
fun ExamsList(
    navController: NavController,
    viewModel: ExamViewModel,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            viewModel.viewModelScope.launch {
                viewModel.getExams().forEach() { exam ->
                    item {
                        ExamElement(
                            onClickItem = {
                                viewModel.onEvent(ExamEvent.SelectExam(exam))
                                navController.navigate(Screen.ExamScreen.route)
                            },
                            onClickInfo = {
                                viewModel.onEvent(ExamEvent.SelectExam(exam))
                                navController.navigate(Screen.ExamDetail.route)
                            },
                            examName = stringResource(id = exam.name),
                            tens = exam.tens.value
                        )
                    }
                }
            }

        }
    }
}