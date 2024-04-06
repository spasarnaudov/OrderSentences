package com.sacoding.feature_lessens_list.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.sacoding.core.constants.FontSize
import com.sacoding.core.constants.Padding
import com.sacoding.feature_exam.R
import com.sacoding.feature_exam.domain.ExamEvent
import com.sacoding.feature_exam.presentation.ExamViewModel
import com.sacoding.feature_exam.presentation.Screen

@Composable
fun ExamsList(
    navController: NavController,
    viewModel: ExamViewModel,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(vertical = Padding.MEDIUM),
            text = stringResource(id = R.string.exams),
            fontWeight = FontWeight.Bold,
            fontSize = FontSize.LARGE
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            viewModel.getLessens().forEach() { lessen ->
                item {
                    ExamElement(
                        onClickItem = {
                            viewModel.onEvent(ExamEvent.SelectExam(lessen))
                            navController.navigate(Screen.ExamScreen.route)
                        },
                        onClickInfo = {
                            viewModel.onEvent(ExamEvent.SelectExam(lessen))
                            navController.navigate(Screen.ExamDetail.route)
                        },
                        examName = lessen.name,
                        levelName = lessen.level.text,
                    )
                }
            }
        }
    }
}