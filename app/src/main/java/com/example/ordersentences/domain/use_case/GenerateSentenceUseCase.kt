package com.example.ordersentences.domain.use_case

import com.example.ordersentences.domain.model.FutureSimpleNegativeSentence
import com.example.ordersentences.domain.model.FutureSimplePositiveSentence
import com.example.ordersentences.domain.model.FutureSimpleQuestionSentence
import com.example.ordersentences.domain.model.PastSimpleNegativeSentence
import com.example.ordersentences.domain.model.PastSimplePositiveSentence
import com.example.ordersentences.domain.model.PastSimpleQuestionSentence
import com.example.ordersentences.domain.model.PresentContinuousNegativeSentence
import com.example.ordersentences.domain.model.PresentContinuousPositiveSentence
import com.example.ordersentences.domain.model.PresentContinuousQuestionSentence
import com.example.ordersentences.domain.model.PresentSimpleNegativeSentence
import com.example.ordersentences.domain.model.PresentSimplePositiveSentence
import com.example.ordersentences.domain.model.PresentSimpleQuestionSentence
import com.example.ordersentences.domain.model.Sentence
import com.example.ordersentences.domain.SentenceType
import com.example.ordersentences.domain.Tens
import com.example.ordersentences.domain.model.Verb

class GenerateSentenceUseCase {

    operator fun invoke(
        sentenceType: SentenceType,
        tens: Tens,
        subject: String,
        verb: Verb,
        objectVal: String,
    ): Sentence {
        return when(sentenceType) {
            SentenceType.POSITIVE -> {
                when(tens) {
                    Tens.PASS -> PastSimplePositiveSentence(subject, verb, objectVal)
                    Tens.PRESENT -> PresentSimplePositiveSentence(subject, verb, objectVal)
                    Tens.PRESENT_CONTINUOUS -> PresentContinuousPositiveSentence(subject, verb, objectVal)
                    Tens.FUTURE -> FutureSimplePositiveSentence(subject, verb, objectVal)
                }
            }
            SentenceType.NEGATIVE -> {
                when(tens) {
                    Tens.PASS -> PastSimpleNegativeSentence(subject, verb, objectVal)
                    Tens.PRESENT -> PresentSimpleNegativeSentence(subject, verb, objectVal)
                    Tens.PRESENT_CONTINUOUS -> PresentContinuousNegativeSentence(subject, verb, objectVal)
                    Tens.FUTURE -> FutureSimpleNegativeSentence(subject, verb, objectVal)
                }
            }
            SentenceType.QUESTION -> {
                when(tens) {
                    Tens.PASS -> PastSimpleQuestionSentence(subject, verb, objectVal)
                    Tens.PRESENT -> PresentSimpleQuestionSentence(subject, verb, objectVal)
                    Tens.PRESENT_CONTINUOUS -> PresentContinuousQuestionSentence(subject, verb, objectVal)
                    Tens.FUTURE -> FutureSimpleQuestionSentence(subject, verb, objectVal)
                }

            }
        }
    }

}