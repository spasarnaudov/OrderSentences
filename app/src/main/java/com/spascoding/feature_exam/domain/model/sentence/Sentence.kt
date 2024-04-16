package com.spascoding.feature_exam.domain.model.sentence

/**
 * Article Noun Verb Preposition Article Noun
 *   The   cat  sat      on        the   mat.
 */
interface Sentence {
    fun positive(): String
    fun negative(): String
    fun question(): String
}