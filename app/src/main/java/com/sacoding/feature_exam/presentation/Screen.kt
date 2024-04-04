package com.sacoding.feature_exam.presentation

sealed class Screen(val route: String) {
    object LessensList : Screen("lessen_screen")
    object LessenDetail : Screen("lessen_details_screen")
    object Exam : Screen("exam_screen")
}