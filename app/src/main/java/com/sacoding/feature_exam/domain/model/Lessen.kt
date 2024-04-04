package com.sacoding.feature_exam.domain.model

import com.sacoding.feature_exam.data.data_source.addPreposition
import com.sacoding.feature_exam.domain.Level
import com.sacoding.feature_exam.domain.SentenceType
import com.sacoding.feature_exam.domain.Tens
import com.sacoding.feature_exam.domain.use_case.GenerateSentenceUseCase

data class Lessen(
    val name: String,
    val level: Level,
    val sentenceTypes: List<SentenceType>,
    val tenses: List<Tens>,
    val subjects: List<String>,
    val verbs: List<Verb>,
    val prepositions: List<String> = listOf(),
    val objectVals: List<String>
)

fun Lessen.info() : List<String> {
    val list = mutableListOf<String>()

    for (sentenceType in sentenceTypes) {
        for (tens in tenses) {
            for (subject in subjects) {
                for (verb in verbs) {
                    for (objectVal in objectVals) {
                        if (prepositions.isEmpty()) {
                            val sentence = GenerateSentenceUseCase().invoke(
                                sentenceType,
                                tens,
                                subject,
                                verb,
                                objectVal
                            )
                            list.add(sentence)
                        } else {
                            for (preposition in prepositions) {
                                val sentence = GenerateSentenceUseCase().invoke(
                                    sentenceType,
                                    tens,
                                    subject,
                                    verb,
                                    objectVal.addPreposition(preposition)
                                )
                                list.add(sentence)
                            }
                        }
                    }
                }
            }
        }
    }

    return list
}