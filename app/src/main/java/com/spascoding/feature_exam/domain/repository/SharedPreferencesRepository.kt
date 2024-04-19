package com.spascoding.feature_exam.domain.repository

import com.spascoding.feature_exam.domain.enums.Tens

interface SharedPreferencesRepository {

    fun setSelectedTens(tens: Tens)
    fun getSelectedTens(): Tens

}