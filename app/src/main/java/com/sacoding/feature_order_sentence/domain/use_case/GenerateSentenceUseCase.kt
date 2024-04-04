package com.sacoding.feature_order_sentence.domain.use_case

import com.sacoding.feature_order_sentence.domain.model.FutureSimpleSentence
import com.sacoding.feature_order_sentence.domain.model.PastSimpleSentence
import com.sacoding.feature_order_sentence.domain.model.PresentContinuousSentence
import com.sacoding.feature_order_sentence.domain.model.PresentSimpleSentence
import com.sacoding.feature_order_sentence.domain.SentenceType
import com.sacoding.feature_order_sentence.domain.Tens
import com.sacoding.feature_order_sentence.domain.model.FutureContinuousSentence
import com.sacoding.feature_order_sentence.domain.model.FuturePerfectContinuousSentence
import com.sacoding.feature_order_sentence.domain.model.FuturePerfectSentence
import com.sacoding.feature_order_sentence.domain.model.PastContinuousSentence
import com.sacoding.feature_order_sentence.domain.model.PastPerfectContinuousSentence
import com.sacoding.feature_order_sentence.domain.model.PastPerfectSentence
import com.sacoding.feature_order_sentence.domain.model.PresentPerfectContinuousSentence
import com.sacoding.feature_order_sentence.domain.model.PresentPerfectSentence
import com.sacoding.feature_order_sentence.domain.model.Verb

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
                sentence.positive()
            }
            SentenceType.NEGATIVE -> {
                sentence.negative()
            }
            SentenceType.QUESTION -> {
                sentence.question()
            }
        }
    }

}