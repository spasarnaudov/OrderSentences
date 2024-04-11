package com.sacoding.feature_exam.domain.model

import com.sacoding.feature_exam.domain.Article
import org.junit.Test

class SingularNounTest {

    @Test
    fun test() {
        val boy = SingularNoun("boy")
        println(boy.getArticle(Article.INDEFINITE))
        assert(boy.getArticle(Article.INDEFINITE) == "a")
        println(boy.value)
        assert(boy.value == "boy")
        println(boy.getArticle(Article.DEFINITE))
        assert(boy.getArticle(Article.DEFINITE) == "the")

        val apple = SingularNoun("apple")
        println(apple.getArticle(Article.INDEFINITE))
        assert(apple.getArticle(Article.INDEFINITE) == "an")
        println(apple.value)
        assert(apple.value == "apple")
        println(apple.getArticle(Article.DEFINITE))
        assert(apple.getArticle(Article.DEFINITE) == "the")
    }
}