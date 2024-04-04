package com.sacoding.feature_lessens_list.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sacoding.feature_exam.presentation.OrderSentenceViewModel
import com.sacoding.feature_exam.presentation.Screen
import com.sacoding.feature_exam.presentation.ui.components.ExamScreen

@Composable
fun Navigation(
    viewModel: OrderSentenceViewModel
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LessensList.route) {
        composable(route = Screen.LessensList.route) {
            LessensList(navController, viewModel)
        }
        composable(route = Screen.LessenDetail.route) {
            LessonDetails(viewModel)
        }
        composable(route = Screen.Exam.route) {
            ExamScreen(viewModel)
        }
    }
}