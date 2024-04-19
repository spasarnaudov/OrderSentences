package com.spascoding.feature_exam.domain.model.noun

import com.spascoding.feature_exam.data.data_source.Nouns
import com.spascoding.feature_exam.domain.enums.Article
import com.spascoding.feature_exam.domain.model.Adjective
import org.junit.Test

class CommonNounTest {

    @Test
    fun boyArticle() {
        val boy = Nouns.boy
        println(boy.build())
        assert(boy.build() == "boy")

        val aBoy = Nouns.boy.copy(article = Article.INDEFINITE)
        println(aBoy.build())
        assert(aBoy.build() == "a boy")

        val theBoy = Nouns.boy.copy(article = Article.DEFINITE)
        println(theBoy.build())
        assert(theBoy.build() == "the boy")

        val littleBoy = Nouns.boy.copy(adjectiveBefore = Adjective(size = "little"))
        println(littleBoy.build())
        assert(littleBoy.build() == "little boy")

        val aLittleBoy = Nouns.boy.copy(
            article = Article.INDEFINITE,
            adjectiveBefore = Adjective(size = "little")
        )
        println(aLittleBoy.build())
        assert(aLittleBoy.build() == "a little boy")

        val theLittleBoy = Nouns.boy.copy(
            article = Article.DEFINITE,
            adjectiveBefore = Adjective(size = "little")
        )
        println(theLittleBoy.build())
        assert(theLittleBoy.build() == "the little boy")
    }

    @Test
    fun appleArticle() {
        val apple = Nouns.apple
        println(apple.build())
        assert(apple.build() == "apple")

        val anApple = Nouns.apple.copy(article = Article.INDEFINITE)
        println(anApple.build())
        assert(anApple.build() == "an apple")

        val theApple = Nouns.apple.copy(article = Article.DEFINITE)
        println(theApple.build())
        assert(theApple.build() == "the apple")

        val greenApple = Nouns.apple.copy(adjectiveBefore = Adjective(color = "green"))
        println(greenApple.build())
        assert(greenApple.build() == "green apple")

        val anGreenApple = Nouns.apple.copy(
            article = Article.INDEFINITE,
            adjectiveBefore = Adjective(color = "green")
        )
        println(anGreenApple.build())
        assert(anGreenApple.build() == "an green apple")

        val theGreenApple = Nouns.apple.copy(
            article = Article.DEFINITE,
            adjectiveBefore = Adjective(color = "green")
        )
        println(theGreenApple.build())
        assert(theGreenApple.build() == "the green apple")
    }

    @Test
    fun boysArticle() {
        val boys = Nouns.boy.plural()
        println(boys.build())
        assert(boys.build() == "boys")

        val aBoys = Nouns.boy.plural().copy(
            article = Article.INDEFINITE
        )
        println(aBoys.build())
        assert(aBoys.build() == "boys")

        val theBoys = Nouns.boy.plural().copy(
            article = Article.DEFINITE
        )
        println(theBoys.build())
        assert(theBoys.build() == "the boys")

        val littleBoy = Nouns.boy.plural().copy(
            adjectiveBefore = Adjective(size = "little")
        )
        println(littleBoy.build())
        assert(littleBoy.build() == "little boys")

        val aLittleBoys = Nouns.boy.plural().copy(
            article = Article.INDEFINITE,
            adjectiveBefore = Adjective(size = "little")
        )
        println(aLittleBoys.build())
        assert(aLittleBoys.build() == "little boys")

        val theLittleBoy = Nouns.boy.plural().copy(
            article = Article.DEFINITE,
            adjectiveBefore = Adjective(size = "little")
        )
        println(theLittleBoy.build())
        assert(theLittleBoy.build() == "the little boys")
    }

    @Test
    fun applesArticle() {
        val apple = Nouns.apple.plural()
        println(apple.build())
        assert(apple.build() == "apples")

        val apples = Nouns.apple.plural().copy(
            article = Article.INDEFINITE
        )
        println(apples.build())
        assert(apples.build() == "apples")

        val theApples = Nouns.apple.plural().copy(
            article = Article.DEFINITE
        )
        println(theApples.build())
        assert(theApples.build() == "the apples")

        val greenApples = Nouns.apple.plural().copy(
            adjectiveBefore = Adjective(color = "green")
        )
        println(greenApples.build())
        assert(greenApples.build() == "green apples")

        val anApple = Nouns.apple.plural().copy(
            article = Article.INDEFINITE,
            adjectiveBefore = Adjective(color = "green")
        )
        println(anApple.build())
        assert(anApple.build() == "green apples")

        val theGreenApple = Nouns.apple.plural().copy(
            article = Article.DEFINITE,
            adjectiveBefore = Adjective(color = "green")
        )
        println(theGreenApple.build())
        assert(theGreenApple.build() == "the green apples")
    }

    @Test
    fun singularToPlural() {

        //  ends with ch
        val bench = Nouns.bench.plural()
        println(bench.build())
        assert(bench.build() == "benches")

        //  ends with sh
        val dish = Nouns.dish.plural()
        println(dish.build())
        assert(dish.build() == "dishes")

        //  ends with s
        val bus = Nouns.bus.plural()
        println(bus.build())
        assert(bus.build() == "buses")

        //  ends with ss
        val kiss = Nouns.kiss.plural()
        println(kiss.build())
        assert(kiss.build() == "kisses")

        //  ends with x
        val box = Nouns.box.plural()
        println(box.build())
        assert(box.build() == "boxes")

        //  ends with z
        val buzz = Nouns.buzz.plural()
        println(buzz.build())
        assert(buzz.build() == "buzzes")

        //  ends with f
        val shelf = Nouns.shelf.plural()
        println(shelf.build())
        assert(shelf.build() == "shelves")

        //  ends with fe
        val wife = Nouns.wife.plural()
        println(wife.build())
        assert(wife.build() == "wives")

        //  ends with vowel + o
        val radio = Nouns.radio.plural()
        println(radio.build())
        assert(radio.build() == "radios")

        //  ends with consonant + o
        val potato = Nouns.potato.plural()
        println(potato.build())
        assert(potato.build() == "potatoes")

        //  ends with vowel + y
        val day = Nouns.day.plural()
        println(day.build())
        assert(day.build() == "days")

        //  ends with consonant + y
        val city = Nouns.city.plural()
        println(city.build())
        assert(city.build() == "cities")




        val car = Nouns.car.plural()
        println(car.build())
        assert(car.build() == "cars")
    }

}