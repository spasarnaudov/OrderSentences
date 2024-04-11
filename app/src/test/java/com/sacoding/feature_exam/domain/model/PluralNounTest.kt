package com.sacoding.feature_exam.domain.model

import com.sacoding.feature_exam.domain.Article
import org.junit.Test

class PluralNounTest {

    @Test
    fun test() {
        val boys = PluralNoun("boy")
        println(boys.getArticle(Article.INDEFINITE))
        assert(boys.getArticle(Article.INDEFINITE) == "")
        println(boys.value)
        assert(boys.value == "boys")
        println(boys.getArticle(Article.DEFINITE))
        assert(boys.getArticle(Article.DEFINITE) == "the")
    }
}