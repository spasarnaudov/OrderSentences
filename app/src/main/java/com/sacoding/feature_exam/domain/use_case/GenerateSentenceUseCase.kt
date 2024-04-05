package com.sacoding.feature_exam.domain.use_case

import com.sacoding.feature_exam.domain.model.FutureSimpleSentence
import com.sacoding.feature_exam.domain.model.PastSimpleSentence
import com.sacoding.feature_exam.domain.model.PresentContinuousSentence
import com.sacoding.feature_exam.domain.model.PresentSimpleSentence
import com.sacoding.feature_exam.domain.SentenceType
import com.sacoding.feature_exam.domain.Tens
import com.sacoding.feature_exam.domain.model.FutureContinuousSentence
import com.sacoding.feature_exam.domain.model.FuturePerfectContinuousSentence
import com.sacoding.feature_exam.domain.model.FuturePerfectSentence
import com.sacoding.feature_exam.domain.model.PastContinuousSentence
import com.sacoding.feature_exam.domain.model.PastPerfectContinuousSentence
import com.sacoding.feature_exam.domain.model.PastPerfectSentence
import com.sacoding.feature_exam.domain.model.PresentPerfectContinuousSentence
import com.sacoding.feature_exam.domain.model.PresentPerfectSentence
import com.sacoding.feature_exam.domain.model.Verb
import com.sacoding.feature_exam.presentation.utils.upperFirstLetter

class GenerateSentenceUseCase {

    operator fun invoke(
        sentenceType: SentenceType,
        tens: Tens,
        subject: String,
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