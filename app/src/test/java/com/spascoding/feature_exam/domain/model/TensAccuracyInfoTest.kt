package com.spascoding.feature_exam.domain.model

import com.spascoding.englishstructure.feature_exam.domain.enums.Tens
import com.spascoding.englishstructure.feature_exam.domain.model.TensAccuracyInfo
import org.junit.Test

import org.junit.Assert.*

class TensAccuracyInfoTest {

    private val testTensAccuracyInfo = TensAccuracyInfo(
        tens = Tens.PRESENT_SIMPLE,
        mistakesCount = 20,
        usedCount = 100,
        sentencesCount = 0,
    )

    @Test
    fun accuracy() {

    }

    @Test
    fun compareTo() {
        val tens_75 = TensAccuracyInfo(Tens.PRESENT_SIMPLE, 25, 100, 0)
        val tens_80 = TensAccuracyInfo(Tens.PRESENT_SIMPLE, 20, 100, 0)
        val tens_85 = TensAccuracyInfo(Tens.PRESENT_SIMPLE, 15, 100, 0)

        //Smaller

        smaller(tens_75, testTensAccuracyInfo)
        smaller(testTensAccuracyInfo, tens_85)

        //Equal

        equal(tens_80, testTensAccuracyInfo)
        equal(testTensAccuracyInfo, tens_80)

        //Bigger

        bigger(tens_85, testTensAccuracyInfo)
        bigger(testTensAccuracyInfo, tens_75)
    }

    private fun smaller(tensAccuracyInfo1: TensAccuracyInfo, tensAccuracyInfo2: TensAccuracyInfo) {
        assertTrue(tensAccuracyInfo1 < tensAccuracyInfo2)
        assertFalse(tensAccuracyInfo1 > tensAccuracyInfo2)
        assertTrue(tensAccuracyInfo1 <= tensAccuracyInfo2)
        assertFalse(tensAccuracyInfo1 >= tensAccuracyInfo2)
        assertFalse(tensAccuracyInfo1 == tensAccuracyInfo2)
        assertTrue(tensAccuracyInfo1 != tensAccuracyInfo2)
    }

    private fun equal(tensAccuracyInfo1: TensAccuracyInfo, tensAccuracyInfo2: TensAccuracyInfo) {
        assertFalse(tensAccuracyInfo1 < tensAccuracyInfo2)
        assertFalse(tensAccuracyInfo1 > tensAccuracyInfo2)
        assertTrue(tensAccuracyInfo1 <= tensAccuracyInfo2)
        assertTrue(tensAccuracyInfo1 >= tensAccuracyInfo2)
        assertTrue(tensAccuracyInfo1 == tensAccuracyInfo2)
        assertFalse(tensAccuracyInfo1 != tensAccuracyInfo2)
    }

    private fun bigger(tensAccuracyInfo1: TensAccuracyInfo, tensAccuracyInfo2: TensAccuracyInfo) {
        assertFalse(tensAccuracyInfo1 < tensAccuracyInfo2)
        assertTrue(tensAccuracyInfo1 > tensAccuracyInfo2)
        assertFalse(tensAccuracyInfo1 <= tensAccuracyInfo2)
        assertTrue(tensAccuracyInfo1 >= tensAccuracyInfo2)
        assertFalse(tensAccuracyInfo1 == tensAccuracyInfo2)
        assertTrue(tensAccuracyInfo1 != tensAccuracyInfo2)
    }
}