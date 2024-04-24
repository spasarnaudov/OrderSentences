package com.spascoding.feature_exam.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.presentation.exam_detail.ExamDetails
import com.spascoding.feature_exam.presentation.exam_list.ExamsList
import com.spascoding.feature_exam.presentation.exam_screen.ExamScreen

@Composable
fun Navigation(
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.ExamList.route) {
        composable(route = Screen.ExamList.route) {
            ExamsList(navController)
        }
        composable(
            route = Screen.ExamDetail.route +
                    "?tens={tens}&examName={examName}",
            arguments = listOf(
                navArgument(
                    name = "examName"
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
                    "?tens={tens}&examName={examName}",
            arguments = listOf(
                navArgument(
                    name = "examName"
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