package com.sacoding.feature_exam.domain.model

import androidx.annotation.StringRes
import com.sacoding.feature_exam.data.data_source.addPreposition
import com.sacoding.feature_exam.domain.Level
import com.sacoding.feature_exam.domain.SentenceType
import com.sacoding.feature_exam.domain.Tens
import com.sacoding.feature_exam.domain.model.verb.Verb
import com.sacoding.feature_exam.domain.use_case.GenerateSentenceUseCase

data class Exam(
    @StringRes val name: Int,
    val level: Level,
    val sentenceTypes: List<SentenceType> = SentenceType.entries,
    val tenses: List<Tens>,
    val subjects: List<String>,
    val questionWord: String = "",
    val verbs: List<Verb>,
    val prepositions: List<String> = listOf(),
    val objectVals: List<String>
)

fun Exam.info() : List<String> {
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
                                questionWord,
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
                                    questionWord,
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