package com.spascoding.englishstructure.feature_exam.domain.utils

import com.spascoding.englishstructure.feature_exam.domain.enums.Tens
import com.spascoding.englishstructure.feature_exam.domain.model.ExamPattern
import com.spascoding.englishstructure.feature_exam.domain.model.noun.Noun
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.Structure
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.entity.Sentence
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.future.FutureContinuousStructure
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.future.FuturePerfectContinuousStructure
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.future.FuturePerfectStructure
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.future.FutureSimpleStructure
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.past.PastContinuousStructure
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.past.PastPerfectContinuousStructure
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.past.PastPerfectStructure
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.past.PastSimpleStructure
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.present.PresentContinuousStructure
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.present.PresentPerfectContinuousStructure
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.present.PresentPerfectStructure
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.present.PresentSimpleStructure
import com.spascoding.englishstructure.feature_exam.domain.model.verb.Verb
import com.spascoding.englishstructure.feature_exam.presentation.utils.upperFirstLetter

class SentencesGenerator(
    private val tens: Tens,
    private val examPatterns: List<ExamPattern>
) {
    fun generate(): List<Sentence> {
        val sentences = mutableListOf<Sentence>()

        for (examPattern in examPatterns) {
            if (examPattern.tenses.contains(tens)) {
                val examName = examPattern.name
                for (subject in examPattern.subjects) {
                    for (verb in examPattern.verbs) {
                        for (objectVal in examPattern.objects) {
                            val structure = getStructure(subject, verb, objectVal)
                            sentences.add(Sentence(structure.positive().upperFirstLetter(), tens.int, examName))
                            sentences.add(Sentence(structure.negative().upperFirstLetter(), tens.int, examName))
                            sentences.add(Sentence(structure.question().upperFirstLetter(), tens.int, examName))
                        }
                    }
                }
            }
        }

        return sentences
    }

    private fun getStructure(
        subject: Noun,
        verb: Verb,
        objectVal: String,
    ): Structure {
        return when (tens) {
            Tens.PAST_SIMPLE -> PastSimpleStructure(subject, verb, objectVal)
            Tens.PAST_CONTINUOUS -> PastContinuousStructure(subject, verb, objectVal)
            Tens.PAST_PERFECT -> PastPerfectStructure(subject, verb, objectVal)
            Tens.PAST_PERFECT_CONTINUOUS -> PastPerfectContinuousStructure(subject, verb, objectVal)

            Tens.PRESENT_SIMPLE -> PresentSimpleStructure(subject, verb, objectVal)
            Tens.PRESENT_CONTINUOUS -> PresentContinuousStructure(subject, verb, objectVal)
            Tens.PRESENT_PERFECT -> PresentPerfectStructure(subject, verb, objectVal)
            Tens.PRESENT_PERFECT_CONTINUOUS -> PresentPerfectContinuousStructure(
                subject,
                verb,
                objectVal
            )

            Tens.FUTURE_SIMPLE -> FutureSimpleStructure(subject, verb, objectVal)
            Tens.FUTURE_CONTINUOUS -> FutureContinuousStructure(subject, verb, objectVal)
            Tens.FUTURE_PERFECT -> FuturePerfectStructure(subject, verb, objectVal)
            Tens.FUTURE_PERFECT_CONTINUOUS -> FuturePerfectContinuousStructure(
                subject,
                verb,
                objectVal
            )
        }
    }
}