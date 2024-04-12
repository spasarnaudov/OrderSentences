package com.sacoding.feature_exam.domain.use_case

import com.sacoding.feature_exam.domain.model.sentence.FutureSimpleSentence
import com.sacoding.feature_exam.domain.model.sentence.PastSimpleSentence
import com.sacoding.feature_exam.domain.model.sentence.PresentContinuousSentence
import com.sacoding.feature_exam.domain.model.sentence.PresentSimpleSentence
import com.sacoding.feature_exam.domain.SentenceType
import com.sacoding.feature_exam.domain.Tens
import com.sacoding.feature_exam.domain.model.noun.Noun
import com.sacoding.feature_exam.domain.model.sentence.FutureContinuousSentence
import com.sacoding.feature_exam.domain.model.sentence.FuturePerfectContinuousSentence
import com.sacoding.feature_exam.domain.model.sentence.FuturePerfectSentence
import com.sacoding.feature_exam.domain.model.sentence.PastContinuousSentence
import com.sacoding.feature_exam.domain.model.sentence.PastPerfectContinuousSentence
import com.sacoding.feature_exam.domain.model.sentence.PastPerfectSentence
import com.sacoding.feature_exam.domain.model.sentence.PresentPerfectContinuousSentence
import com.sacoding.feature_exam.domain.model.sentence.PresentPerfectSentence
import com.sacoding.feature_exam.domain.model.verb.Verb
import com.sacoding.feature_exam.presentation.utils.upperFirstLetter

class GenerateSentenceUseCase {

    operator fun invoke(
        sentenceType: SentenceType,
        tens: Tens,
        subject: Noun,
        questionWord: String,
        verb: Verb,
        objectVal: String,
    ): String {
        val sentence = when(tens) {
            Tens.PAST_SIMPLE -> PastSimpleSentence(subject, verb, objectVal)
            Tens.PAST_CONTINUOUS -> PastContinuousSentence(subject, verb, objectVal)
            Tens.PAST_PERFECT -> PastPerfectSentence(subject, verb, objectVal)
            Tens.PAST_PERFECT_CONTINUOUS -> PastPerfectContinuousSentence(subject, verb, objectVal)

            Tens.PRESENT_SIMPLE -> PresentSimpleSentence(subject, questionWord, verb, objectVal)
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