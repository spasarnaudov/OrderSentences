package com.example.ordersentences.data.data_source

import com.example.ordersentences.domain.Level
import com.example.ordersentences.domain.SentenceType
import com.example.ordersentences.domain.Tens
import com.example.ordersentences.domain.model.Lessen

object StudentBook {
    val presentSimpleLessens = listOf(
        Lessen(
            name = "Where are you live?",
            level = Level.BEGINNER,
            sentenceTypes = SentenceType.entries,
            tenses = listOf(Tens.PRESENT_SIMPLE),
            subjects = Subjects.pronouns.plus(Subjects.names),
            verbs = Verbs.countriesAndCities,
            prepositions = Prepositions.enclosedSpaces,
            objectVals = Objects.countries.plus(Objects.cities),
        ),
    )
}