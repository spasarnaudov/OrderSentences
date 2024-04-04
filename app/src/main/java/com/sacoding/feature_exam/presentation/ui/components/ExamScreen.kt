package com.sacoding.feature_exam.presentation.ui.components

import androidx.compose.runtime.Composable
import com.sacoding.feature_exam.domain.GameState
import com.sacoding.feature_exam.presentation.OrderSentenceViewModel

@Composable
fun ExamScreen(
    viewModel: OrderSentenceViewModel
) {
    when (viewModel.getGameState()) {
        GameState.FINISHED -> {
            ResultScreen(viewModel)
        }

        GameState.STARTED -> {
            InputScreen(viewModel)
        }
    }
}