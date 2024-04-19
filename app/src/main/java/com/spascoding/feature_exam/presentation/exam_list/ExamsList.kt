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
        Box(modifier = Modifier.padding(Padding.MEDIUM)) {
            DropDownMenu(
                title = stringResource(R.string.tenses),
                defaultValue = viewModel.state.value.tens.value,
                list = Tens.entries.map { it.value },
            ) {
                viewModel.onEvent(ExamListEvent.SelectTens(tens = Tens.fromString(it)))
            }
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            viewModel.viewModelScope.launch {
                viewModel.state.value.exams.forEachIndexed() { index, exam ->
                    val name = viewModel.getFirstItemName(exam)
                    item {
                        ExamElement(
                            onClickItem = {
                                viewModel.onEvent(ExamListEvent.SelectExam(exam))
                                navController.navigate(Screen.ExamScreen.route + "?examIndex=$index&tens=${exam.tens.int}")
                            },
                            onClickInfo = {
                                viewModel.onEvent(ExamListEvent.SelectExam(exam))
                                navController.navigate(Screen.ExamDetail.route + "?examIndex=$index&tens=${exam.tens.int}")
                            },
                            examName = name,
                            tens = exam.tens.value
                        )
                    }
                }
            }
        }
    }
}