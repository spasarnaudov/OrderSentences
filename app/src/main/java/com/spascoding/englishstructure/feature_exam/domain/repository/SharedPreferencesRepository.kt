package com.spascoding.englishstructure.feature_exam.domain.repository

interface SharedPreferencesRepository {
    fun setAppVersion(version: String)
    fun getAppVersion(): String
}