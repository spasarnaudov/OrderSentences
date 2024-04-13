package com.sacoding.feature_exam.domain.model.noun

import org.junit.Test

class MultiSubjectPronounTest {

    @Test
    fun testBuild() {
        val subjectPronouns = mutableListOf(
            Pronoun.YOU,
            Pronoun("Emily"),
        )
        val twoSubjectPronoun = MultiSubjectPronoun(subjectPronouns).build()
        println(twoSubjectPronoun)
        assert(twoSubjectPronoun == "${Pronoun.YOU.value} and Emily")

        subjectPronouns.add(Pronoun("John"))

        val threeSubjectPronoun = MultiSubjectPronoun(subjectPronouns).build()
        println(threeSubjectPronoun)
        assert(threeSubjectPronoun == "${Pronoun.YOU.value}, Emily and John")
    }
}