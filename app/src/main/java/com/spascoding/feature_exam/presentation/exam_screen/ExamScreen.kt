package com.spascoding.feature_exam.presentation.exam_screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.spascoding.feature_exam.domain.ExamState

@Composable
fun ExamScreen(
    viewModel: ExamViewModel = hiltViewModel()

) {
    when (viewModel.state.value.gameState) {
        ExamState.FINISHED -> {
            ResultScreen()
        }

        ExamState.STARTED -> {
            InputScreen()
        }
    }
}