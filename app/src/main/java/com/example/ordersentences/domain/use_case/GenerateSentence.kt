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
import com.example.ordersentences.domain.model.SentenceType
import com.example.ordersentences.domain.model.Verb

class GenerateSentence {

    operator fun invoke(
        sentenceType: SentenceType,
        subject: String,
        verb: Verb,
        objectVal: String,
    ): Sentence {
        return when(sentenceType) {
            SentenceType.PASS_POSITIVE -> PastSimplePositiveSentence(subject, verb, objectVal)
            SentenceType.PASS_NEGATIVE -> PastSimpleNegativeSentence(subject, verb, objectVal)
            SentenceType.PASS_QUESTION -> PastSimpleQuestionSentence(subject, verb, objectVal)

            SentenceType.PRESENT_POSITIVE -> PresentSimplePositiveSentence(subject, verb, objectVal)
            SentenceType.PRESENT_NEGATIVE -> PresentSimpleNegativeSentence(subject, verb, objectVal)
            SentenceType.PRESENT_QUESTION -> PresentSimpleQuestionSentence(subject, verb, objectVal)

            SentenceType.PRESENT_CONTINUOUS_POSITIVE -> PresentContinuousPositiveSentence(subject, verb, objectVal)
            SentenceType.PRESENT_CONTINUOUS_NEGATIVE -> PresentContinuousNegativeSentence(subject, verb, objectVal)
            SentenceType.PRESENT_CONTINUOUS_QUESTION -> PresentContinuousQuestionSentence(subject, verb, objectVal)

            SentenceType.FUTURE_POSITIVE -> FutureSimplePositiveSentence(subject, verb, objectVal)
            SentenceType.FUTURE_NEGATIVE -> FutureSimpleNegativeSentence(subject, verb, objectVal)
            SentenceType.FUTURE_QUESTION -> FutureSimpleQuestionSentence(subject, verb, objectVal)
        }
    }

}