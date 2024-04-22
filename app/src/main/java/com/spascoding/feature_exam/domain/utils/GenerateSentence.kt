package com.spascoding.feature_exam.domain.utils

import com.spascoding.feature_exam.domain.model.sentence.future.FutureSimpleStructure
import com.spascoding.feature_exam.domain.model.sentence.past.PastSimpleStructure
import com.spascoding.feature_exam.domain.model.sentence.present.PresentContinuousStructure
import com.spascoding.feature_exam.domain.model.sentence.present.PresentSimpleStructure
import com.spascoding.feature_exam.domain.enums.SentenceType
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.noun.Noun
import com.spascoding.feature_exam.domain.model.sentence.future.FutureContinuousStructure
import com.spascoding.feature_exam.domain.model.sentence.future.FuturePerfectContinuousStructure
import com.spascoding.feature_exam.domain.model.sentence.future.FuturePerfectStructure
import com.spascoding.feature_exam.domain.model.sentence.past.PastContinuousStructure
import com.spascoding.feature_exam.domain.model.sentence.past.PastPerfectContinuousStructure
import com.spascoding.feature_exam.domain.model.sentence.past.PastPerfectStructure
import com.spascoding.feature_exam.domain.model.sentence.present.PresentPerfectContinuousStructure
import com.spascoding.feature_exam.domain.model.sentence.present.PresentPerfectStructure
import com.spascoding.feature_exam.domain.model.verb.Verb
import com.spascoding.feature_exam.presentation.utils.upperFirstLetter

class GenerateSentence {

    operator fun invoke(
        sentenceType: SentenceType,
        tens: Tens,
        subject: Noun,
        verb: Verb,
        objectVal: String,
    ): String {
        val sentence = when(tens) {
            Tens.PAST_SIMPLE -> PastSimpleStructure(subject, verb, objectVal)
            Tens.PAST_CONTINUOUS -> PastContinuousStructure(subject, verb, objectVal)
            Tens.PAST_PERFECT -> PastPerfectStructure(subject, verb, objectVal)
            Tens.PAST_PERFECT_CONTINUOUS -> PastPerfectContinuousStructure(subject, verb, objectVal)

            Tens.PRESENT_SIMPLE -> PresentSimpleStructure(subject, verb, objectVal)
            Tens.PRESENT_CONTINUOUS -> PresentContinuousStructure(subject, verb, objectVal)
            Tens.PRESENT_PERFECT -> PresentPerfectStructure(subject, verb, objectVal)
            Tens.PRESENT_PERFECT_CONTINUOUS -> PresentPerfectContinuousStructure(subject, verb, objectVal)

            Tens.FUTURE_SIMPLE -> FutureSimpleStructure(subject, verb, objectVal)
            Tens.FUTURE_CONTINUOUS -> FutureContinuousStructure(subject, verb, objectVal)
            Tens.FUTURE_PERFECT -> FuturePerfectStructure(subject, verb, objectVal)
            Tens.FUTURE_PERFECT_CONTINUOUS -> FuturePerfectContinuousStructure(subject, verb, objectVal)
        }

        return when(sentenceType) {
            SentenceType.POSITIVE -> {
                sentence.positive().upperFirstLetter()
            }
            SentenceType.NEGATIVE -> {
                sentence.negative().upperFirstLetter()
            }
            SentenceType.QUESTION -> {
                sentence.question().upperFirstLetter()
            }
        }
    }

}