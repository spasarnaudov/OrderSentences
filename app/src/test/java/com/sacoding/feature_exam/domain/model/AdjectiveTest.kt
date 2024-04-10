package com.sacoding.feature_exam.domain.model

import org.junit.Test

class AdjectiveTest {

    @Test
    fun testBuild() {
        //It's a great big old round white Korean plastic coffee cup.
        val adjective1 = Adjective(
            qualityOpinion = "great"
        ).build()
        println(adjective1)
        assert(adjective1 == "great")

        val adjective2 = Adjective(
            qualityOpinion = "great",
            size = "big"
        ).build()
        println(adjective2)
        assert(adjective2 == "great big")

        val adjective3 = Adjective(
            qualityOpinion = "great",
            size = "big",
            age = "old"
        ).build()
        println(adjective3)
        assert(adjective3 == "great big old")

        val adjective4 = Adjective(
            qualityOpinion = "great",
            size = "big",
            age = "old",
            shape = "round"
        ).build()
        println(adjective4)
        assert(adjective4 == "great big old round")

        val adjective5 = Adjective(
            qualityOpinion = "great",
            size = "big",
            age = "old",
            shape = "round",
            color = "white"
        ).build()
        println(adjective5)
        assert(adjective5 == "great big old round white")

        val adjective6 = Adjective(
            qualityOpinion = "great",
            size = "big",
            age = "old",
            shape = "round",
            color = "white",
            origin = "Korean"
        ).build()
        println(adjective6)
        assert(adjective6 == "great big old round white Korean")

        val adjective7 = Adjective(
            qualityOpinion = "great",
            size = "big",
            age = "old",
            shape = "round",
            color = "white",
            origin = "Korean",
            material = "plastic"
        ).build()
        println(adjective7)
        assert(adjective7 == "great big old round white Korean plastic")

        val adjective8 = Adjective(
            qualityOpinion = "great",
            size = "big",
            age = "old",
            shape = "round",
            color = "white",
            origin = "Korean",
            material = "plastic",
            purpose = "coffee"
        ).build()
        println(adjective8)
        assert(adjective8 == "great big old round white Korean plastic coffee")
    }
}