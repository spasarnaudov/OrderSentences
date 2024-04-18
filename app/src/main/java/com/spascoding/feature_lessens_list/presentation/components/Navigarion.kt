package com.spascoding.feature_lessens_list.presentation.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.spascoding.feature_exam.presentation.ExamViewModel
import com.spascoding.feature_exam.presentation.Screen
import com.spascoding.feature_exam.presentation.ui.components.ExamScreen

@Composable
fun Navigation(
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.ExamList.route) {
        composable(route = Screen.ExamList.route) {
            ExamsList(navController)
        }
        composable(route = Screen.ExamDetail.route) {
            ExamDetails()
        }
        composable(route = Screen.ExamScreen.route) {
            ExamScreen()
        }
    }
}