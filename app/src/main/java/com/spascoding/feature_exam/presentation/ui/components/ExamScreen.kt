package com.spascoding.feature_exam.presentation.ui.components

import androidx.compose.runtime.Composable
import com.spascoding.feature_exam.domain.GameState
import com.spascoding.feature_exam.presentation.ExamViewModel

@Composable
fun ExamScreen(
    viewModel: ExamViewModel
) {
    when (viewModel.state.value.gameState) {
        GameState.FINISHED -> {
            ResultScreen(viewModel)
        }

        GameState.STARTED -> {
            InputScreen(viewModel)
        }
    }
}