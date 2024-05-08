package com.spascoding.englishstructure.feature_exam.data.repository

import android.content.Context
import com.spascoding.englishstructure.feature_exam.data.repository.utils.getValue
import com.spascoding.englishstructure.feature_exam.domain.repository.ConfigRepository

class ConfigAppRepositoryImpl(
    private val context: Context
): ConfigRepository {

    override fun getUnlockTensAccuracy(value: String): Int {
        return getValue(context, value).toInt()
    }

    override fun getUnlockTensSentenceCount(value: String): Int {
        return getValue(context, value).toInt()
    }

    override fun getUnlockTopicAccuracy(value: String): Int {
        return getValue(context, value).toInt()
    }

    override fun getUnlockTopicSentenceCount(value: String): Int {
        return getValue(context, value).toInt()
    }

    override fun getAccuracySentencesCount(value: String): Int {
        return getValue(context, value).toInt()
    }
}