package com.spascoding.feature_exam.domain.model

import com.spascoding.englishstructure.feature_exam.domain.model.Adjective
import org.junit.Test

class AdjectiveTest {

    @Test
    fun testBuild() {
        //It's a my great big old round white Korean plastic coffee cup.
        val adjective0 = Adjective(
            possessiveDeterminer = "my"
        )
        println(adjective0.build())
        assert(adjective0.build() == "my")

        val adjective1 = adjective0.copy(qualityOpinion = "great")
        println(adjective1.build())
        assert(adjective1.build() == "my great")

        val adjective2 = adjective1.copy(size = "big")
        println(adjective2.build())
        assert(adjective2.build() == "my great big")

        val adjective3 = adjective2.copy(age = "old")
        println(adjective3.build())
        assert(adjective3.build() == "my great big old")

        val adjective4 = adjective3.copy(shape = "round")
        println(adjective4.build())
        assert(adjective4.build() == "my great big old round")

        val adjective5 = adjective4.copy(color = "white")
        println(adjective5.build())
        assert(adjective5.build() == "my great big old round white")

        val adjective6 = adjective5.copy(origin = "Korean")
        println(adjective6.build())
        assert(adjective6.build() == "my great big old round white Korean")

        val adjective7 = adjective6.copy(material = "plastic")
        println(adjective7.build())
        assert(adjective7.build() == "my great big old round white Korean plastic")

        val adjective8 = adjective7.copy(purpose = "coffee")
        println(adjective8.build())
        assert(adjective8.build() == "my great big old round white Korean plastic coffee")
    }
}