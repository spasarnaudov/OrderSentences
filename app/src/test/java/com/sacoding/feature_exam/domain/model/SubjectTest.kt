package com.sacoding.feature_exam.domain.model

import com.sacoding.feature_exam.domain.Article
import org.junit.Test

class SubjectTest {

    @Test
    fun testAYoungBoy() {
        val boy = SingularNoun("boy")
        val youngBoy = createYoungBoy(noun = boy)
        assert(youngBoy.build() == "young boy")

        val aYoungBoy = createYoungBoy(article = Article.INDEFINITE, noun = boy)
        assert(aYoungBoy.build() == "a young boy")

        val theYoungBoy = createYoungBoy(article = Article.DEFINITE, noun = boy)
        assert(theYoungBoy.build() == "the young boy")

        val boys = PluralNoun("boy")
        val youngBoys = createYoungBoy(noun = boys)
        assert(youngBoys.build() == "young boys")

        val aYoungBoys = createYoungBoy(article = Article.INDEFINITE, noun = boys)
        assert(aYoungBoys.build() == "young boys")

        val theYoungBoys = createYoungBoy(article = Article.DEFINITE, noun = boys)
        assert(theYoungBoys.build() == "the young boys")
    }

    private fun createYoungBoy(article: Article = Article.NONE, noun: Noun): Subject {
        val youngBoy = Subject(
            article = article,
            adjective = Adjective(age = "young"),
            noun = noun,
        )
        println(youngBoy.build())
        return youngBoy
    }

    @Test
    fun testUnTastyApple() {
        val apple = SingularNoun("apple")

        val tastyApple = createTastyApple(noun = apple)
        assert(tastyApple.build() == "tasty apple")

        val anTastyApple = createTastyApple(article = Article.INDEFINITE, noun = apple)
        assert(anTastyApple.build() == "an tasty apple")

        val theTastyApple = createTastyApple(article = Article.DEFINITE, noun = apple)
        assert(theTastyApple.build() == "the tasty apple")

        val apples = PluralNoun("apple")

        val tastyApples = createTastyApple(noun = apples)
        assert(tastyApples.build() == "tasty apples")

        val anTastyApples = createTastyApple(article = Article.INDEFINITE, noun = apples)
        assert(anTastyApples.build() == "tasty apples")

        val theTastyApples = createTastyApple(article = Article.DEFINITE, noun = apples)
        assert(theTastyApples.build() == "the tasty apples")
    }

    private fun createTastyApple(article: Article = Article.NONE, noun: Noun): Subject {
        val tastyApple = Subject(
            article = article,
            adjective = Adjective(age = "tasty"),
            noun = noun,
        )
        println(tastyApple.build())
        return tastyApple
    }
}