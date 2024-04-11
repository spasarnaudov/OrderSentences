package com.sacoding.feature_exam.domain.model

import com.sacoding.feature_exam.domain.Article
import org.junit.Test

class PluralNounTest {

    @Test
    fun boy() {
        val boy = PluralNoun(value = "boy")
        println(boy.build())
        assert(boy.build() == "boys")
    }

    @Test
    fun aBoy() {
        val aBoy = PluralNoun(
            article = Article.INDEFINITE,
            value = "boy"
        )
        println(aBoy.build())
        assert(aBoy.build() == "boys")
    }

    @Test
    fun theBoy() {
        val theBoy = PluralNoun(
            article = Article.DEFINITE,
            value = "boy"
        )
        println(theBoy.build())
        assert(theBoy.build() == "the boys")
    }

    @Test
    fun apple() {
        val apple = PluralNoun(value = "apple")
        println(apple.build())
        assert(apple.build() == "apples")
    }

    @Test
    fun anApple() {
        val anApple = PluralNoun(
            article = Article.INDEFINITE,
            value = "apple"
        )
        println(anApple.build())
        assert(anApple.build() == "apples")
    }

    @Test
    fun theApple() {
        val theApple = PluralNoun(
            article = Article.DEFINITE,
            value = "apple"
        )
        println(theApple.build())
        assert(theApple.build() == "the apples")
    }

    @Test
    fun littleBoy() {
        val boy = PluralNoun(
            adjective = Adjective(size = "little"),
            value = "boy"
        )
        println(boy.build())
        assert(boy.build() == "little boys")
    }

    @Test
    fun aLittleBoy() {
        val aBoy = PluralNoun(
            article = Article.INDEFINITE,
            adjective = Adjective(size = "little"),
            value = "boy"
        )
        println(aBoy.build())
        assert(aBoy.build() == "little boys")
    }

    @Test
    fun theLittleBoy() {
        val theBoy = PluralNoun(
            article = Article.DEFINITE,
            adjective = Adjective(size = "little"),
            value = "boy"
        )
        println(theBoy.build())
        assert(theBoy.build() == "the little boys")
    }

    @Test
    fun greenApple() {
        val apple = PluralNoun(
            adjective = Adjective(color = "green"),
            value = "apple"
        )
        println(apple.build())
        assert(apple.build() == "green apples")
    }

    @Test
    fun anGreenApple() {
        val anApple = PluralNoun(
            article = Article.INDEFINITE,
            adjective = Adjective(color = "green"),
            value = "apple"
        )
        println(anApple.build())
        assert(anApple.build() == "green apples")
    }

    @Test
    fun theGreenApple() {
        val theApple = PluralNoun(
            article = Article.DEFINITE,
            adjective = Adjective(color = "green"),
            value = "apple"
        )
        println(theApple.build())
        assert(theApple.build() == "the green apples")
    }
}