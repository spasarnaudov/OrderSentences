package com.spascoding.feature_exam.domain.utils

import com.spascoding.feature_exam.domain.model.sentence.future.FutureSimpleSentence
import com.spascoding.feature_exam.domain.model.sentence.past.PastSimpleSentence
import com.spascoding.feature_exam.domain.model.sentence.present.PresentContinuousSentence
import com.spascoding.feature_exam.domain.model.sentence.present.PresentSimpleSentence
import com.spascoding.feature_exam.domain.enums.SentenceType
import com.spascoding.feature_exam.domain.enums.Tens
import com.spascoding.feature_exam.domain.model.noun.Noun
import com.spascoding.feature_exam.domain.model.sentence.future.FutureContinuousSentence
import com.spascoding.feature_exam.domain.model.sentence.future.FuturePerfectContinuousSentence
import com.spascoding.feature_exam.domain.model.sentence.future.FuturePerfectSentence
import com.spascoding.feature_exam.domain.model.sentence.past.PastContinuousSentence
import com.spascoding.feature_exam.domain.model.sentence.past.PastPerfectContinuousSentence
import com.spascoding.feature_exam.domain.model.sentence.past.PastPerfectSentence
import com.spascoding.feature_exam.domain.model.sentence.present.PresentPerfectContinuousSentence
import com.spascoding.feature_exam.domain.model.sentence.present.PresentPerfectSentence
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
            Tens.PAST_SIMPLE -> PastSimpleSentence(subject, verb, objectVal)
            Tens.PAST_CONTINUOUS -> PastContinuousSentence(subject, verb, objectVal)
            Tens.PAST_PERFECT -> PastPerfectSentence(subject, verb, objectVal)
            Tens.PAST_PERFECT_CONTINUOUS -> PastPerfectContinuousSentence(subject, verb, objectVal)

            Tens.PRESENT_SIMPLE -> PresentSimpleSentence(subject, verb, objectVal)
            Tens.PRESENT_CONTINUOUS -> PresentContinuousSentence(subject, verb, objectVal)
            Tens.PRESENT_PERFECT -> PresentPerfectSentence(subject, verb, objectVal)
            Tens.PRESENT_PERFECT_CONTINUOUS -> PresentPerfectContinuousSentence(subject, verb, objectVal)

            Tens.FUTURE_SIMPLE -> FutureSimpleSentence(subject, verb, objectVal)
            Tens.FUTURE_CONTINUOUS -> FutureContinuousSentence(subject, verb, objectVal)
            Tens.FUTURE_PERFECT -> FuturePerfectSentence(subject, verb, objectVal)
            Tens.FUTURE_PERFECT_CONTINUOUS -> FuturePerfectContinuousSentence(subject, verb, objectVal)
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