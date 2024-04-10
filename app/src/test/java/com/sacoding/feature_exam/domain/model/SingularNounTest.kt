package com.sacoding.feature_exam.domain.model

import org.junit.Test

class SingularNounTest {

    @Test
    fun test() {
        val boy = SingularNoun("boy")
        println(boy.getArticle())
        assert(boy.getArticle() == "a")
        println(boy.value)
        assert(boy.value == "boy")
        println(boy.getArticle(true))
        assert(boy.getArticle(true) == "the")

        val apple = SingularNoun("apple")
        println(apple.getArticle())
        assert(apple.getArticle() == "an")
        println(apple.value)
        assert(apple.value == "apple")
        println(apple.getArticle(true))
        assert(apple.getArticle(true) == "the")
    }
}