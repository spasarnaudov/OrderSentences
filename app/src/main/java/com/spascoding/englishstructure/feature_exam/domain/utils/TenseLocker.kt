package com.spascoding.englishstructure.feature_exam.domain.utils

import com.spascoding.englishstructure.feature_exam.domain.enums.Tense
import com.spascoding.englishstructure.feature_exam.domain.model.TenseAccuracyInfo
import com.spascoding.englishstructure.feature_exam.domain.model.getElementByTense
import com.spascoding.englishstructure.feature_exam.domain.repository.FirebaseRepository

class TenseLocker(
    private val firebaseRepository: FirebaseRepository
) {
    fun isLocked(currentTense: Tense, tenseAccuracyInfos: List<TenseAccuracyInfo>): Boolean {
        if (Tense.PRESENT_SIMPLE == currentTense) {
            return false
        }
        return foundNotSuccessTense(currentTense, tenseAccuracyInfos)
    }

    private fun foundNotSuccessTense(
        currentTense: Tense,
        tenseAccuracyInfos: List<TenseAccuracyInfo>
    ): Boolean {
        for (tense in Tense.entries.sortedBy { it.int }) {
            if (tense.int < currentTense.int) {
                val tenseAccuracyInfo = tenseAccuracyInfos.getElementByTense(tense) ?: return true
                if (isSentenceNotSuccess(tenseAccuracyInfo)) {
                    return true
                }
            }
        }
        return false
    }

    private fun isSentenceNotSuccess(tenseAccuracyInfo: TenseAccuracyInfo): Boolean {
        for (topicAccuracyInfo in tenseAccuracyInfo.topicsAccuracyInfo) {
            if (topicAccuracyInfo.accuracy() < firebaseRepository.getUnlockTopicAccuracy()
            || topicAccuracyInfo.sentencesCount < firebaseRepository.getUnlockTopicSentenceCount()
            ) {
                return true
            }
        }
//        return tensAccuracyInfo.accuracy() < firebaseRepository.getUnlockTensAccuracy()
//            || tensAccuracyInfo.sentencesCount < firebaseRepository.getUnlockTensSentenceCount()
        return false
    }
}