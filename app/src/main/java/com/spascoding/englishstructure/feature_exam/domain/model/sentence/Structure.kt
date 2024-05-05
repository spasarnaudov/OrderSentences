package com.spascoding.englishstructure.feature_exam.domain.model.sentence

interface Structure {
    fun positive(): String
    fun negative(): String
    fun question(): String
}