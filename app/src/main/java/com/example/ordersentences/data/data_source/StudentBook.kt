package com.example.ordersentences.data.data_source

import com.example.ordersentences.domain.SentenceType
import com.example.ordersentences.domain.Tens
import com.example.ordersentences.domain.model.Lessen

object StudentBook {
    val lessens = listOf(
        Lessen(
            sentenceType = SentenceType.POSITIVE,
            tens = Tens.PRESENT_SIMPLE,
            verbs = Dictionary.levelOneVerbs,
            objectVals = Dictionary.objectsFood,
            subjects = Dictionary.subjects.plus(Dictionary.subjectsNames)
        )
    )
}