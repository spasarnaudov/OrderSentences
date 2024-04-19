package com.spascoding.feature_exam.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.spascoding.feature_exam.domain.Tens
import com.spascoding.feature_exam.domain.repository.SharedPreferencesRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPreferencesRepositoryImpl @Inject constructor(@ApplicationContext context: Context): SharedPreferencesRepository {

    private val preferences: SharedPreferences = context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

    override fun setSelectedTens(tens: Tens) {
        preferences.edit().putInt("selectedTens", tens.int).apply()
    }

    override fun getSelectedTens(): Tens {
        return Tens.fromInt(preferences.getInt("selectedTens", Tens.PRESENT_SIMPLE.int))
    }
}