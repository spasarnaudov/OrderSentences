package com.spascoding.feature_exam.domain.repository

import com.spascoding.feature_exam.domain.enums.Tens

interface SharedPreferencesRepository {

    fun setSelectedTens(tens: Tens)
    fun getSelectedTens(): Tens
    fun setInitialDataVersion(version: Int)
    fun getInitialDataVersion(): Int
}