package com.spascoding.englishstructure.feature_exam.domain.model

data class TopicInfo(
    val topic: String = "",
    val accuracy: Float = 0f,
    val sentenceCount: Int = 0,
)

fun List<TopicInfo>.contains(topic: String): Boolean {
    for (tenseInfo in this) {
        if (tenseInfo.topic == topic) {
            return true
        }
    }
    return false
}

fun List<TopicInfo>.getTenseInfo(topic: String): TopicInfo {
    for (tenseInfo in this) {
        if (tenseInfo.topic == topic) {
            return tenseInfo
        }
    }
    return TopicInfo()
}
