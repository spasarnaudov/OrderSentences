package com.sacoding.feature_exam.presentation

sealed class Screen(val route: String) {
    object ExamList : Screen("exam_list")
    object ExamDetail : Screen("exam_details_screen")
    object ExamScreen : Screen("exam_screen")
}