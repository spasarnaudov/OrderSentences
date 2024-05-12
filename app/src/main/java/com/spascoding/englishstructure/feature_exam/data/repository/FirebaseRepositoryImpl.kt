package com.spascoding.englishstructure.feature_exam.data.repository

import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.remoteConfig
import com.spascoding.englishstructure.feature_exam.domain.repository.ConfigRepository

class FirebaseRepositoryImpl: ConfigRepository {

    private val firebaseRemoteConfig = Firebase.remoteConfig

    override fun getUnlockTensAccuracy(value: String): Int {
        return firebaseRemoteConfig.getLong(value).toInt()
    }

    override fun getUnlockTensSentenceCount(value: String): Int {
        return firebaseRemoteConfig.getLong(value).toInt()
    }

    override fun getUnlockTopicAccuracy(value: String): Int {
        return firebaseRemoteConfig.getLong(value).toInt()
    }

    override fun getUnlockTopicSentenceCount(value: String): Int {
        return firebaseRemoteConfig.getLong(value).toInt()
    }

    override fun getAccuracySentencesCount(value: String): Int {
        return firebaseRemoteConfig.getLong(value).toInt()
    }

    override fun getHistorySentenceCount(value: String): Int {
        return firebaseRemoteConfig.getLong(value).toInt()
    }
}