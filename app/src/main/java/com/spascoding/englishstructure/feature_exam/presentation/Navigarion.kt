package com.spascoding.englishstructure.feature_exam.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.spascoding.englishstructure.feature_exam.domain.enums.Tense
import com.spascoding.englishstructure.feature_exam.presentation.topic_detail_screen.ExamDetails
import com.spascoding.englishstructure.feature_exam.presentation.topics_screen.TopicsScreen
import com.spascoding.englishstructure.feature_exam.presentation.exam_screen.ExamScreen
import com.spascoding.englishstructure.feature_exam.presentation.tense_screen.TenseScreen

@Composable
fun Navigation(
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.TenseScreen.route) {
        composable(route = Screen.TenseScreen.route) {
            TenseScreen(navController)
        }
        composable(
            route = Screen.TopicsScreen.route + "?tense={tense}",
            arguments = listOf(
                navArgument(
                    name = "tense"
                ) {
                    type = NavType.IntType
                },
            )
        ) {
            TopicsScreen(navController)
        }
        composable(
            route = Screen.TopicDetailScreen.route +
                    "?tense={tense}&topic={topic}",
            arguments = listOf(
                navArgument(
                    name = "topic"
                ) {
                    type = NavType.StringType
                    defaultValue = ""
                },
                navArgument(
                    name = "tense"
                ) {
                    type = NavType.IntType
                    defaultValue = Tense.PRESENT_SIMPLE.int
                },
            )
        ) {
            ExamDetails()
        }
        composable(
            route = Screen.ExamScreen.route +
                    "?tense={tense}&topic={topic}",
            arguments = listOf(
                navArgument(
                    name = "topic"
                ) {
                    type = NavType.StringType
                    defaultValue = ""
                },
                navArgument(
                    name = "tense"
                ) {
                    type = NavType.IntType
                    defaultValue = Tense.PRESENT_SIMPLE.int
                },
            )
        ) {
            ExamScreen()
        }
    }
}