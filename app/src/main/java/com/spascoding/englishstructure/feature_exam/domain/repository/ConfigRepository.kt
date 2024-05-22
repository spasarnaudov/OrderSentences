package com.spascoding.englishstructure.feature_exam.domain.repository

interface ConfigRepository {
    fun getRecentSentenceCount(value: String = "RecentSentenceCount"): Int
}