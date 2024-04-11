package com.sacoding.feature_exam.domain.model

import com.sacoding.feature_exam.domain.Article
import org.junit.Test

class SingularNounTest {

    @Test
    fun boyWithPreposition() {
        val boy = SingularNoun(
            adjective = Adjective(size = "little"),
            value = "boy",
            preposition = "for"
        )
        println(boy.build())
        assert(boy.build() == "for little boy")
    }

    @Test
    fun boy() {
        val boy = SingularNoun(
            adjective = Adjective(size = "little"),
            value = "boy"
        )
        println(boy.build())
        assert(boy.build() == "little boy")
    }

    @Test
    fun aBoy() {
        val aBoy = SingularNoun(
            article = Article.INDEFINITE,
            adjective = Adjective(size = "little"),
            value = "boy"
        )
        println(aBoy.build())
        assert(aBoy.build() == "a little boy")
    }

    @Test
    fun theBoy() {
        val theBoy = SingularNoun(
            article = Article.DEFINITE,
            adjective = Adjective(size = "little"),
            value = "boy"
        )
        println(theBoy.build())
        assert(theBoy.build() == "the little boy")
    }

    @Test
    fun apple() {
        val apple = SingularNoun(
            adjective = Adjective(color = "green"),
            value = "apple"
        )
        println(apple.build())
        assert(apple.build() == "green apple")
    }

    @Test
    fun anApple() {
        val anApple = SingularNoun(
            article = Article.INDEFINITE,
            adjective = Adjective(color = "green"),
            value = "apple"
        )
        println(anApple.build())
        assert(anApple.build() == "an green apple")
    }

    @Test
    fun theApple() {
        val theApple = SingularNoun(
            article = Article.DEFINITE,
            adjective = Adjective(color = "green"),
            value = "apple"
        )
        println(theApple.build())
        assert(theApple.build() == "the green apple")
    }

    @Test
    fun littleBoy() {
        val boy = SingularNoun(
            adjective = Adjective(size = "little"),
            value = "boy"
        )
        println(boy.build())
        assert(boy.build() == "little boy")
    }

    @Test
    fun aLittleBoy() {
        val aBoy = SingularNoun(
            article = Article.INDEFINITE,
            adjective = Adjective(size = "little"),
            value = "boy"
        )
        println(aBoy.build())
        assert(aBoy.build() == "a little boy")
    }

    @Test
    fun theLittleBoy() {
        val theBoy = SingularNoun(
            article = Article.DEFINITE,
            adjective = Adjective(size = "little"),
            value = "boy"
        )
        println(theBoy.build())
        assert(theBoy.build() == "the little boy")
    }

    @Test
    fun greenApple() {
        val apple = SingularNoun(
            adjective = Adjective(color = "green"),
            value = "apple"
        )
        println(apple.build())
        assert(apple.build() == "green apple")
    }

    @Test
    fun anGreenApple() {
        val anApple = SingularNoun(
            article = Article.INDEFINITE,
            adjective = Adjective(color = "green"),
            value = "apple"
        )
        println(anApple.build())
        assert(anApple.build() == "an green apple")
    }

    @Test
    fun theGreenApple() {
        val theApple = SingularNoun(
            article = Article.DEFINITE,
            adjective = Adjective(color = "green"),
            value = "apple"
        )
        println(theApple.build())
        assert(theApple.build() == "the green apple")
    }
}