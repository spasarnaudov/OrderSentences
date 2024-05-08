package com.spascoding.feature_exam.domain.model

import com.spascoding.englishstructure.feature_exam.domain.enums.Tense
import com.spascoding.englishstructure.feature_exam.domain.model.TenseAccuracyInfo
import org.junit.Test

import org.junit.Assert.*

class TenseAccuracyInfoTest {

    private val testTenseAccuracyInfo = TenseAccuracyInfo(
        tense = Tense.PRESENT_SIMPLE,
        mistakesCount = 20,
        usedCount = 100,
        sentencesCount = 0,
        topicsAccuracyInfo = listOf(),
    )

    @Test
    fun accuracy() {

    }

    @Test
    fun compareTo() {
        val tense_75 = TenseAccuracyInfo(Tense.PRESENT_SIMPLE, 25, 100, 0, listOf())
        val tense_80 = TenseAccuracyInfo(Tense.PRESENT_SIMPLE, 20, 100, 0, listOf())
        val tense_85 = TenseAccuracyInfo(Tense.PRESENT_SIMPLE, 15, 100, 0, listOf())

        //Smaller

        smaller(tense_75, testTenseAccuracyInfo)
        smaller(testTenseAccuracyInfo, tense_85)

        //Equal

        equal(tense_80, testTenseAccuracyInfo)
        equal(testTenseAccuracyInfo, tense_80)

        //Bigger

        bigger(tense_85, testTenseAccuracyInfo)
        bigger(testTenseAccuracyInfo, tense_75)
    }

    private fun smaller(tensAccuracyInfo1: TenseAccuracyInfo, tensAccuracyInfo2: TenseAccuracyInfo) {
        assertTrue(tensAccuracyInfo1 < tensAccuracyInfo2)
        assertFalse(tensAccuracyInfo1 > tensAccuracyInfo2)
        assertTrue(tensAccuracyInfo1 <= tensAccuracyInfo2)
        assertFalse(tensAccuracyInfo1 >= tensAccuracyInfo2)
        assertFalse(tensAccuracyInfo1 == tensAccuracyInfo2)
        assertTrue(tensAccuracyInfo1 != tensAccuracyInfo2)
    }

    private fun equal(tensAccuracyInfo1: TenseAccuracyInfo, tensAccuracyInfo2: TenseAccuracyInfo) {
        assertFalse(tensAccuracyInfo1 < tensAccuracyInfo2)
        assertFalse(tensAccuracyInfo1 > tensAccuracyInfo2)
        assertTrue(tensAccuracyInfo1 <= tensAccuracyInfo2)
        assertTrue(tensAccuracyInfo1 >= tensAccuracyInfo2)
        assertTrue(tensAccuracyInfo1 == tensAccuracyInfo2)
        assertFalse(tensAccuracyInfo1 != tensAccuracyInfo2)
    }

    private fun bigger(tensAccuracyInfo1: TenseAccuracyInfo, tensAccuracyInfo2: TenseAccuracyInfo) {
        assertFalse(tensAccuracyInfo1 < tensAccuracyInfo2)
        assertTrue(tensAccuracyInfo1 > tensAccuracyInfo2)
        assertFalse(tensAccuracyInfo1 <= tensAccuracyInfo2)
        assertTrue(tensAccuracyInfo1 >= tensAccuracyInfo2)
        assertFalse(tensAccuracyInfo1 == tensAccuracyInfo2)
        assertTrue(tensAccuracyInfo1 != tensAccuracyInfo2)
    }
}