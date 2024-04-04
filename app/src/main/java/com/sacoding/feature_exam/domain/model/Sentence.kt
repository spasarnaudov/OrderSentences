package com.sacoding.feature_exam.domain.model

interface Sentence {
    fun positive(): String
    fun negative(): String
    fun question(): String
}