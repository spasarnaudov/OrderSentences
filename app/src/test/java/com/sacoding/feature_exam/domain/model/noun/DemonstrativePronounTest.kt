package com.sacoding.feature_exam.domain.model.noun

import org.junit.Test

class DemonstrativePronounTest {

    @Test
    fun positive() {
        val john = DemonstrativePronoun("John").build()
        println(john)
        assert(john == "John's")
    }

}