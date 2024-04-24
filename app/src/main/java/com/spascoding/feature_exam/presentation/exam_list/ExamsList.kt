package com.spascoding.feature_exam.presentation.exam_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.spascoding.core.constants.Padding
import com.spascoding.core.presentation.DropDownMenu
import com.spascoding.feature_exam.R
import com.spascoding.feature_exam.domain.enums.Tens
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
        Box(modifier = Modifier
            .padding(Padding.MEDIUM)) {
            DropDownMenu(
                title = stringResource(R.string.tenses),
                defaultValue = viewModel.state.value.tens.value,
                list = Tens.entries.sortedBy { it.int }.map { it.value },
            ) {
                viewModel.onEvent(ExamListEvent.SelectTens(tens = Tens.fromString(it)))
            }
        }
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