package com.spascoding.feature_exam.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.presentation.exam_detail.ExamDetails
import com.spascoding.feature_exam.presentation.topics_screen.TopicsScreen
import com.spascoding.feature_exam.presentation.exam_screen.ExamScreen
import com.spascoding.feature_exam.presentation.tens_screen.TensScreen

@Composable
fun Navigation(
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.TensScreen.route) {
        composable(route = Screen.TensScreen.route) {
            TensScreen(navController)
        }
        composable(route = Screen.TopicsScreen.route) {
            TopicsScreen(navController)
        }
        composable(
            route = Screen.ExamDetail.route +
                    "?tens={tens}&topic={topic}",
            arguments = listOf(
                navArgument(
                    name = "topic"
                ) {
                    type = NavType.StringType
                    defaultValue = ""
                },
                navArgument(
                    name = "tens"
                ) {
                    type = NavType.IntType
                    defaultValue = Tens.PRESENT_SIMPLE.int
                },
            )
        ) {
            ExamDetails()
        }
        composable(
            route = Screen.ExamScreen.route +
                    "?tens={tens}&topic={topic}",
            arguments = listOf(
                navArgument(
                    name = "topic"
                ) {
                    type = NavType.StringType
                    defaultValue = ""
                },
                navArgument(
                    name = "tens"
                ) {
                    type = NavType.IntType
                    defaultValue = Tens.PRESENT_SIMPLE.int
                },
            )
        ) {
            ExamScreen()
        }
    }
}