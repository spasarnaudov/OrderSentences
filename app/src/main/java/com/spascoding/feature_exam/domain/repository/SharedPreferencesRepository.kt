package com.spascoding.feature_exam.domain.repository

import com.spascoding.feature_exam.domain.Tens

interface SharedPreferencesRepository {

    fun setSelectedTens(tens: Tens)
    fun getSelectedTens(): Tens

}