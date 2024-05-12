package com.spascoding.englishstructure.feature_exam.domain.repository

interface ConfigRepository {
    fun getUnlockTensAccuracy(value: String = "UnlockTenseAccuracy"): Int
    fun getUnlockTensSentenceCount(value: String = "UnlockTenseSentenceCount"): Int
    fun getUnlockTopicAccuracy(value: String = "UnlockTopicAccuracy"): Int
    fun getUnlockTopicSentenceCount(value: String = "UnlockTopicSentenceCount"): Int
    fun getAccuracySentencesCount(value: String = "AccuracySentencesCount"): Int
    fun getHistorySentenceCount(value: String = "HistorySentenceCount"): Int
}