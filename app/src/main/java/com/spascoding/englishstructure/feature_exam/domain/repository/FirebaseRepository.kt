package com.spascoding.englishstructure.feature_exam.domain.repository

interface FirebaseRepository {
    fun getUnlockTensAccuracy(): Int
    fun getUnlockTensSentenceCount(): Int
    fun getUnlockTopicAccuracy(): Int
    fun getUnlockTopicSentenceCount(): Int
    fun getAccuracySentencesCount(): Int
}