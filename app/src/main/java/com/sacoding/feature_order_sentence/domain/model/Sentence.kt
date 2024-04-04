package com.sacoding.feature_order_sentence.domain.model

interface Sentence {
    fun positive(): String
    fun negative(): String
    fun question(): String
}