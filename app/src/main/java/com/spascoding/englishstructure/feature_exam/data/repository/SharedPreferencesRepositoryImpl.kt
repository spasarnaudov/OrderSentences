package com.spascoding.englishstructure.feature_exam.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.spascoding.englishstructure.feature_exam.domain.repository.SharedPreferencesRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPreferencesRepositoryImpl @Inject constructor(@ApplicationContext context: Context): SharedPreferencesRepository {

    private val preferences: SharedPreferences = context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

    override fun setAppVersion(version: String) {
        preferences.edit().putString("APP_VERSION", version).apply()
    }

    override fun getAppVersion(): String {
        return preferences.getString("APP_VERSION", "").toString()
    }
}