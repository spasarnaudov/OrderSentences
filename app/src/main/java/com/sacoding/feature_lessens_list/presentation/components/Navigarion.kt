package com.sacoding.feature_lessens_list.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sacoding.feature_exam.presentation.ExamViewModel
import com.sacoding.feature_exam.presentation.Screen
import com.sacoding.feature_exam.presentation.ui.components.ExamScreen

@Composable
fun Navigation(
    viewModel: ExamViewModel
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.ExamList.route) {
        composable(route = Screen.ExamList.route) {
            ExamsList(navController, viewModel)
        }
        composable(route = Screen.ExamDetail.route) {
            ExamDetails(viewModel)
        }
        composable(route = Screen.ExamScreen.route) {
            ExamScreen(viewModel)
        }
    }
}