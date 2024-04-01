package com.example.ordersentences.domain.use_case

import com.example.ordersentences.domain.model.FutureSimpleSentence
import com.example.ordersentences.domain.model.PastSimpleSentence
import com.example.ordersentences.domain.model.PresentContinuousSentence
import com.example.ordersentences.domain.model.PresentSimpleSentence
import com.example.ordersentences.domain.SentenceType
import com.example.ordersentences.domain.Tens
import com.example.ordersentences.domain.model.FutureContinuousSentence
import com.example.ordersentences.domain.model.FuturePerfectContinuousSentence
import com.example.ordersentences.domain.model.FuturePerfectSentence
import com.example.ordersentences.domain.model.PastContinuousSentence
import com.example.ordersentences.domain.model.PastPerfectContinuousSentence
import com.example.ordersentences.domain.model.PastPerfectSentence
import com.example.ordersentences.domain.model.PresentPerfectContinuousSentence
import com.example.ordersentences.domain.model.PresentPerfectSentence
import com.example.ordersentences.domain.model.Verb

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