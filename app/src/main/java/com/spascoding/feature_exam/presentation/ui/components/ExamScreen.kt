package com.spascoding.feature_exam.presentation.ui.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.spascoding.feature_exam.domain.GameState
import com.spascoding.feature_exam.presentation.ExamViewModel

@Composable
fun ExamScreen(
    viewModel: ExamViewModel = hiltViewModel()

) {
    when (viewModel.state.value.gameState) {
        GameState.FINISHED -> {
            ResultScreen()
        }

        GameState.STARTED -> {
            InputScreen()
        }
    }
}