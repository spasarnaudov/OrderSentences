package com.sacoding.feature_exam.domain.model

import org.junit.Test

class NounTest {

    @Test
    fun addArticle() {
        val boy = Noun("boy").addArticle()
        println(boy.singular)
        println(boy.plural)
        assert(boy.singular == "a boy")
        assert(boy.plural == "boys")

        val apple = Noun("apple").addArticle()
        println(apple.singular)
        println(apple.plural)
        assert(apple.singular == "an apple")
        assert(apple.plural == "apples")
    }

    @Test
    fun toPlural() {
        val boy = Noun("boy")
        println(boy.plural)
        assert(boy.plural == "boys")

        val box = Noun("box", "boxes")
        println(box.plural)
        assert(box.plural == "boxes")

        val city = Noun("city", "cities")
        println(city.plural)
        assert(city.plural == "cities")

        val man = Noun("man", "men")
        println(man.plural)
        assert(man.plural == "men")
    }

}