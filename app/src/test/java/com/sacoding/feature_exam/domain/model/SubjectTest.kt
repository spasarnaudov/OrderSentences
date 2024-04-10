package com.sacoding.feature_exam.domain.model

import org.junit.Test

class SubjectTest {

    @Test
    fun testAYoungBoy() {
        val boy = SingularNoun("boy")
        val aYoungBoy = Subject(
            article = boy.getArticle(),
            adjective = Adjective(age = "young").build(),
            noun = boy.value,
        )
        println(aYoungBoy.build())
        assert(aYoungBoy.build() == "a young boy")

        val youngBoy = Subject(
            article = boy.getArticle(true),
            adjective = Adjective(age = "young").build(),
            noun = boy.value,
        )
        println(youngBoy.build())
        assert(youngBoy.build() == "the young boy")

        val boys = PluralNoun("boy")
        val aYoungBoys = Subject(
            article = boys.getArticle(),
            adjective = Adjective(age = "young").build(),
            noun = boys.value,
        )
        println(aYoungBoys.build())
        assert(aYoungBoys.build() == "young boys")

        val youngBoys = Subject(
            article = boys.getArticle(true),
            adjective = Adjective(age = "young").build(),
            noun = boys.value,
        )
        println(youngBoys.build())
        assert(youngBoys.build() == "the young boys")
    }

    @Test
    fun testUnTastyApple() {
        val apple = SingularNoun("apple")
        val aYoungBoy = Subject(
            article = apple.getArticle(),
            adjective = Adjective(age = "tasty").build(),
            noun = apple.value,
        )
        println(aYoungBoy.build())
        assert(aYoungBoy.build() == "an tasty apple")

        val youngBoy = Subject(
            article = apple.getArticle(true),
            adjective = Adjective(age = "tasty").build(),
            noun = apple.value,
        )
        println(youngBoy.build())
        assert(youngBoy.build() == "the tasty apple")

        val apples = PluralNoun("apple")
        val aYoungBoys = Subject(
            article = apples.getArticle(),
            adjective = Adjective(age = "tasty").build(),
            noun = apples.value,
        )
        println(aYoungBoys.build())
        assert(aYoungBoys.build() == "tasty apples")

        val youngBoys = Subject(
            article = apples.getArticle(true),
            adjective = Adjective(age = "tasty").build(),
            noun = apples.value,
        )
        println(youngBoys.build())
        assert(youngBoys.build() == "the tasty apples")
    }
}