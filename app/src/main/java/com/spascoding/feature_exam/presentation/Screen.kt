package com.spascoding.feature_exam.presentation

sealed class Screen(val route: String) {
    object TensScreen : Screen("tens_screen")
    object TopicsScreen : Screen("topics_screen")
    object ExamDetail : Screen("exam_details_screen")
    object ExamScreen : Screen("exam_screen")
}