package com.spascoding.feature_exam.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.repository.SharedPreferencesRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPreferencesRepositoryImpl @Inject constructor(@ApplicationContext context: Context): SharedPreferencesRepository {

    private val SELECTED_TENS = "selectedTens"

    private val preferences: SharedPreferences = context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

    override fun setSelectedTens(tens: Tens) {
        preferences.edit().putInt(SELECTED_TENS, tens.int).apply()
    }

    override fun getSelectedTens(): Tens {
        return Tens.fromInt(preferences.getInt(SELECTED_TENS, Tens.PRESENT_SIMPLE.int))
    }
}