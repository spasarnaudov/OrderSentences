package com.spascoding.englishstructure.feature_exam.data.repository

import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.remoteConfig
import com.spascoding.englishstructure.feature_exam.domain.repository.FirebaseRepository

class FirebaseRepositoryImpl: FirebaseRepository {

    private val firebaseRemoteConfig = Firebase.remoteConfig

    override fun getUnlockTensAccuracy(): Int {
        return firebaseRemoteConfig.getLong("UnlockTensAccuracy").toInt()
    }

    override fun getUnlockTensSentenceCount(): Int {
        return firebaseRemoteConfig.getLong("UnlockTensSentenceCount").toInt()
    }
}