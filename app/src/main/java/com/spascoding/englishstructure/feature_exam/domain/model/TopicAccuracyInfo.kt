package com.spascoding.englishstructure.feature_exam.domain.model

import com.spascoding.englishstructure.feature_exam.domain.utils.Accuracy

data class TopicAccuracyInfo(
    val topic: String,
    val mistakesCount: Int,
    val usedCount: Int,
    val sentencesCount: Int,
) {
    fun accuracy(): Int {
        return Accuracy(mistakesCount, usedCount).calculate()
    }

    operator fun compareTo(tenseAccuracyInfo: TenseAccuracyInfo): Int {
        return accuracy() - tenseAccuracyInfo.accuracy()
    }
}

fun List<TopicAccuracyInfo>.getElementByTopic(topic: String): TopicAccuracyInfo? {
    for (item in this) {
        if (item.topic == topic) {
            return item
        }
    }
    return null
}