package com.sacoding.feature_exam.domain.model

/**
 * Article Noun Verb Preposition Article Noun
 *   The   cat  sat      on        the   mat.
 */
interface Sentence {
    fun positive(): String
    fun negative(): String
    fun question(): String
}