package com.spascoding.englishstructure.feature_exam.domain.utils

import com.spascoding.englishstructure.feature_exam.domain.enums.Tens
import com.spascoding.englishstructure.feature_exam.domain.model.TensAccuracyInfo
import com.spascoding.englishstructure.feature_exam.domain.model.getElementByTens
import com.spascoding.englishstructure.feature_exam.domain.repository.FirebaseRepository

class TensLocker(
    private val firebaseRepository: FirebaseRepository
) {
    fun isLocked(currentTens: Tens, tensAccuracyInfos: List<TensAccuracyInfo>): Boolean {
        if (Tens.PRESENT_SIMPLE == currentTens) {
            return false
        }
        return foundNotSuccessTens(currentTens, tensAccuracyInfos)
    }

    private fun foundNotSuccessTens(
        currentTens: Tens,
        tensAccuracyInfos: List<TensAccuracyInfo>
    ): Boolean {
        for (tens in Tens.entries.sortedBy { it.int }) {
            if (tens.int < currentTens.int) {
                val tensAccuracyInfo = tensAccuracyInfos.getElementByTens(tens) ?: return true
                if (isSentenceNotSuccess(tensAccuracyInfo)) {
                    return true
                }
            }
        }
        return false
    }

    private fun isSentenceNotSuccess(tensAccuracyInfo: TensAccuracyInfo): Boolean {
        return tensAccuracyInfo.accuracy() < firebaseRepository.getUnlockTensAccuracy()
            || tensAccuracyInfo.sentencesCount < firebaseRepository.getUnlockTensSentenceCount()
    }
}