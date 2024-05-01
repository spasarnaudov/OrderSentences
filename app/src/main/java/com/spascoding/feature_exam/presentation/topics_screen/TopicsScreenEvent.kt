package com.spascoding.feature_exam.presentation.topics_screen

sealed interface TopicsScreenEvent {
    data class SelectTopic(val topicName: String) : TopicsScreenEvent
    data class SelectTopicInfo(val topicName: String) : TopicsScreenEvent
}