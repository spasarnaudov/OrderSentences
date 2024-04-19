package com.spascoding.feature_exam.domain.model

import com.spascoding.feature_exam.domain.enums.SentenceType
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.noun.Noun
import com.spascoding.feature_exam.domain.model.verb.Verb
import com.spascoding.feature_exam.domain.utils.GenerateSentence

data class Exam(
    val tens: Tens,
    val subjects: List<Noun>,
    val verbs: List<Verb>,
    val objects: List<String>
)

fun Exam.info() : List<String> {
    val list = mutableListOf<String>()

    for (sentenceType in SentenceType.entries) {
        for (subject in subjects) {
            for (verb in verbs) {
                for (objectVal in objects) {
                    val sentence = GenerateSentence().invoke(
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