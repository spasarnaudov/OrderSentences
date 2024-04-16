package com.spascoding.feature_exam.domain.model

import androidx.annotation.StringRes
import com.spascoding.feature_exam.domain.Level
import com.spascoding.feature_exam.domain.SentenceType
import com.spascoding.feature_exam.domain.Tens
import com.spascoding.feature_exam.domain.model.noun.Noun
import com.spascoding.feature_exam.domain.model.verb.Verb
import com.spascoding.feature_exam.domain.use_case.GenerateSentenceUseCase

data class Exam(
    @StringRes val name: Int,
    val level: Level,
    val sentenceTypes: List<SentenceType> = SentenceType.entries,
    val tens: Tens,
    val subjects: List<Noun>,
    val verbs: List<Verb>,
    val objects: List<String>
)

fun Exam.info() : List<String> {
    val list = mutableListOf<String>()

    for (sentenceType in sentenceTypes) {
        for (subject in subjects) {
            for (verb in verbs) {
                for (objectVal in objects) {
                    val sentence = GenerateSentenceUseCase().invoke(
                        sentenceType,
                        tens,
                        subject,
                        verb,
                        objectVal
                    )
                    list.add(sentence)
                }
            }
        }
    }

    return list
}