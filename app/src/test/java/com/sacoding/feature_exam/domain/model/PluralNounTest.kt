package com.sacoding.feature_exam.domain.model

import org.junit.Test

class PluralNounTest {

    @Test
    fun test() {
        val boys = PluralNoun("boy")
        println(boys.getArticle())
        assert(boys.getArticle() == "")
        println(boys.value)
        assert(boys.value == "boys")
        println(boys.getArticle(true))
        assert(boys.getArticle(true) == "the")
    }
}