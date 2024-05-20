package com.spascoding.englishstructure.feature_exam.data.repository

import android.content.Context
import com.spascoding.englishstructure.feature_exam.data.repository.utils.getValue
import com.spascoding.englishstructure.feature_exam.domain.repository.ConfigRepository

class ConfigAppRepositoryImpl(
    private val context: Context
): ConfigRepository {

    override fun getRecentSentenceCount(value: String): Int {
        return getValue(context, value).toInt()
    }
}