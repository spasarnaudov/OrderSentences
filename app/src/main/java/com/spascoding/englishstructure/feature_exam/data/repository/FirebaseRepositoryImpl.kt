package com.spascoding.englishstructure.feature_exam.data.repository

import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.remoteConfig
import com.spascoding.englishstructure.feature_exam.domain.repository.ConfigRepository

class FirebaseRepositoryImpl: ConfigRepository {

    private val firebaseRemoteConfig = Firebase.remoteConfig

    override fun getRecentSentenceCount(value: String): Int {
        return firebaseRemoteConfig.getLong(value).toInt()
    }
}