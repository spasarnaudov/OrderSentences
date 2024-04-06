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
fun LessensList(
    navController: NavController,
    viewModel: ExamViewModel,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(vertical = Padding.MEDIUM),
            text = stringResource(id = R.string.lessens),
            fontWeight = FontWeight.Bold,
            fontSize = FontSize.LARGE
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            viewModel.getLessens().forEach() { lessen ->
                item {
                    LessenElement(
                        onClickItem = {
                            viewModel.onEvent(ExamEvent.SelectLesson(lessen))
                            navController.navigate(Screen.Exam.route)
                        },
                        onClickInfo = {
                            viewModel.onEvent(ExamEvent.SelectLesson(lessen))
                            navController.navigate(Screen.LessenDetail.route)
                        },
                        lessenName = lessen.name,
                        levelName = lessen.level.text,
                    )
                }
            }
        }
    }
}