package com.spascoding.feature_exam.domain.use_case

import com.spascoding.feature_exam.data.data_source.Nouns
import com.spascoding.feature_exam.data.data_source.Verbs
import com.spascoding.feature_exam.data.data_source.Pronouns
import com.spascoding.feature_exam.domain.SentenceType
import com.spascoding.feature_exam.domain.Tens
import com.spascoding.feature_exam.domain.model.Exam
import com.spascoding.feature_exam.domain.model.noun.build
import org.junit.Test

class GenerateSentenceUseCaseTest {

    private fun check(sentences: List<String>, exam: Exam): Boolean {
        var counter = 0
        for (sentenceType in SentenceType.entries) {
            for (subject in exam.subjects) {
                for (verb in exam.verbs) {
                    for (objectVal in exam.objects) {
                        val sentence = GenerateSentenceUseCase().invoke(
                            sentenceType,
                            exam.tens,
                            subject,
                            verb,
                            objectVal
                        )
                        counter++
                        if (!sentences.contains(sentence)) {
                            return false
                        }
                    }
                }
            }
        }
        return counter == sentences.size
    }

    private fun print(exam: Exam) {
        for (sentenceType in SentenceType.entries) {
            for (subject in exam.subjects) {
                for (verb in exam.verbs) {
                    for (objectVal in exam.objects) {
                        val sentence = GenerateSentenceUseCase().invoke(
                            sentenceType,
                            exam.tens,
                            subject,
                            verb,
                            objectVal
                        )
                        println("\"$sentence\",")
                    }
                }
            }
        }
    }

    private fun whereAreYouLiveLessen(tens: Tens) : Exam {
        return Exam(
            tens = tens,
            subjects = Pronouns.singular.plus(Nouns.names),
            verbs = Verbs.countriesAndCities,
            objects = listOf("Australia"),
        )
    }

    @Test
    fun whereAreYouLivePresentSimple() {
        val sentences = listOf(
            "I live in Australia.",
            "you live in Australia.",
            "he lives in Australia.",
            "she lives in Australia.",
            "it lives in Australia.",
            "we live in Australia.",
            "you live in Australia.",
            "they live in Australia.",
            "John lives in Australia.",
            "Emily lives in Australia.",
            "I do not live in Australia.",
            "you do not live in Australia.",
            "he does not live in Australia.",
            "she does not live in Australia.",
            "it does not live in Australia.",
            "we do not live in Australia.",
            "you do not live in Australia.",
            "they do not live in Australia.",
            "John does not live in Australia.",
            "Emily does not live in Australia.",
            "do I live in Australia?",
            "do you live in Australia?",
            "does he live in Australia?",
            "does she live in Australia?",
            "does it live in Australia?",
            "do we live in Australia?",
            "do you live in Australia?",
            "do they live in Australia?",
            "does John live in Australia?",
            "does Emily live in Australia?",
        )
        val lessen = whereAreYouLiveLessen(Tens.PRESENT_SIMPLE)
        assert(check(sentences, lessen))
    }

    @Test
    fun whereAreYouFromPresentSimple() {
        val sentences = listOf(
            "I am from Australia.",
            "you are from Australia.",
            "he is from Australia.",
            "she is from Australia.",
            "it is from Australia.",
            "we are from Australia.",
            "you are from Australia.",
            "they are from Australia.",
            "John is from Australia.",
            "Emily is from Australia.",
            "I am not from Australia.",
            "you are not from Australia.",
            "he is not from Australia.",
            "she is not from Australia.",
            "it is not from Australia.",
            "we are not from Australia.",
            "you are not from Australia.",
            "they are not from Australia.",
            "John is not from Australia.",
            "Emily is not from Australia.",
            "am I from Australia?",
            "are you from Australia?",
            "is he from Australia?",
            "is she from Australia?",
            "is it from Australia?",
            "are we from Australia?",
            "are you from Australia?",
            "are they from Australia?",
            "is John from Australia?",
            "is Emily from Australia?",
        )
        val lessen = Exam(
            tens = Tens.PRESENT_SIMPLE,
            subjects = Pronouns.singular.plus(Nouns.names),
            verbs = listOf(Verbs.toBe),
            objects = Nouns.countries.build(),
        )
        assert(check(sentences, lessen))
    }

    @Test
    fun sheIsAmericanPresentSimple() {
        val sentences = listOf(
            "I am Australian.",
            "you are Australian.",
            "he is Australian.",
            "she is Australian.",
            "it is Australian.",
            "we are Australian.",
            "you are Australian.",
            "they are Australian.",
            "John is Australian.",
            "Emily is Australian.",
            "I am not Australian.",
            "you are not Australian.",
            "he is not Australian.",
            "she is not Australian.",
            "it is not Australian.",
            "we are not Australian.",
            "you are not Australian.",
            "they are not Australian.",
            "John is not Australian.",
            "Emily is not Australian.",
            "am I Australian?",
            "are you Australian?",
            "is he Australian?",
            "is she Australian?",
            "is it Australian?",
            "are we Australian?",
            "are you Australian?",
            "are they Australian?",
            "is John Australian?",
            "is Emily Australian?",
        )
        val lessen = Exam(
            tens = Tens.PRESENT_SIMPLE,
            subjects = Pronouns.singular.plus(Nouns.names),
            verbs = listOf(Verbs.toBe),
            objects = Nouns.nationals.build(),
        )
        print(lessen)
        assert(check(sentences, lessen))
    }

    @Test
    fun whereAreYouLivePresentContinues() {
        val sentences = listOf(
            "I am living in Australia.",
            "you are living in Australia.",
            "he is living in Australia.",
            "she is living in Australia.",
            "it is living in Australia.",
            "we are living in Australia.",
            "you are living in Australia.",
            "they are living in Australia.",
            "John is living in Australia.",
            "Emily is living in Australia.",
            "I am not living in Australia.",
            "you are not living in Australia.",
            "he is not living in Australia.",
            "she is not living in Australia.",
            "it is not living in Australia.",
            "we are not living in Australia.",
            "you are not living in Australia.",
            "they are not living in Australia.",
            "John is not living in Australia.",
            "Emily is not living in Australia.",
            "am I living in Australia?",
            "are you living in Australia?",
            "is he living in Australia?",
            "is she living in Australia?",
            "is it living in Australia?",
            "are we living in Australia?",
            "are you living in Australia?",
            "are they living in Australia?",
            "is John living in Australia?",
            "is Emily living in Australia?",
        )
        val lessen = whereAreYouLiveLessen(Tens.PRESENT_CONTINUOUS)
        assert(check(sentences, lessen))
    }

    @Test
    fun whereAreYouLivePresentPerfect() {
        val sentences = listOf(
            "I have lived in Australia.",
            "you have lived in Australia.",
            "he has lived in Australia.",
            "she has lived in Australia.",
            "it has lived in Australia.",
            "we have lived in Australia.",
            "you have lived in Australia.",
            "they have lived in Australia.",
            "John has lived in Australia.",
            "Emily has lived in Australia.",
            "I have not lived in Australia.",
            "you have not lived in Australia.",
            "he has not lived in Australia.",
            "she has not lived in Australia.",
            "it has not lived in Australia.",
            "we have not lived in Australia.",
            "you have not lived in Australia.",
            "they have not lived in Australia.",
            "John has not lived in Australia.",
            "Emily has not lived in Australia.",
            "have I lived in Australia?",
            "have you lived in Australia?",
            "has he lived in Australia?",
            "has she lived in Australia?",
            "has it lived in Australia?",
            "have we lived in Australia?",
            "have you lived in Australia?",
            "have they lived in Australia?",
            "has John lived in Australia?",
            "has Emily lived in Australia?",
        )
        val lessen = whereAreYouLiveLessen(Tens.PRESENT_PERFECT)
        assert(check(sentences, lessen))
    }

    @Test
    fun whereAreYouLivePresentPerfectContinuous() {
        val sentences = listOf(
            "I have been living in Australia.",
            "you have been living in Australia.",
            "he has been living in Australia.",
            "she has been living in Australia.",
            "it has been living in Australia.",
            "we have been living in Australia.",
            "you have been living in Australia.",
            "they have been living in Australia.",
            "John has been living in Australia.",
            "Emily has been living in Australia.",
            "I have not been living in Australia.",
            "you have not been living in Australia.",
            "he has not been living in Australia.",
            "she has not been living in Australia.",
            "it has not been living in Australia.",
            "we have not been living in Australia.",
            "you have not been living in Australia.",
            "they have not been living in Australia.",
            "John has not been living in Australia.",
            "Emily has not been living in Australia.",
            "have I been living in Australia?",
            "have you been living in Australia?",
            "has he been living in Australia?",
            "has she been living in Australia?",
            "has it been living in Australia?",
            "have we been living in Australia?",
            "have you been living in Australia?",
            "have they been living in Australia?",
            "has John been living in Australia?",
            "has Emily been living in Australia?",
        )
        val lessen = whereAreYouLiveLessen(Tens.PRESENT_PERFECT_CONTINUOUS)
        assert(check(sentences, lessen))
    }

    @Test
    fun whereAreYouLivePastSimple() {
        val sentences = listOf(
            "I lived in Australia.",
            "you lived in Australia.",
            "he lived in Australia.",
            "she lived in Australia.",
            "it lived in Australia.",
            "we lived in Australia.",
            "you lived in Australia.",
            "they lived in Australia.",
            "John lived in Australia.",
            "Emily lived in Australia.",
            "I did not live in Australia.",
            "you did not live in Australia.",
            "he did not live in Australia.",
            "she did not live in Australia.",
            "it did not live in Australia.",
            "we did not live in Australia.",
            "you did not live in Australia.",
            "they did not live in Australia.",
            "John did not live in Australia.",
            "Emily did not live in Australia.",
            "did I live in Australia?",
            "did you live in Australia?",
            "did he live in Australia?",
            "did she live in Australia?",
            "did it live in Australia?",
            "did we live in Australia?",
            "did you live in Australia?",
            "did they live in Australia?",
            "did John live in Australia?",
            "did Emily live in Australia?",
        )
        val lessen = whereAreYouLiveLessen(Tens.PAST_SIMPLE)
        assert(check(sentences, lessen))
    }

    @Test
    fun whereAreYouLivePastContinues() {
        val sentences = listOf(
            "I was living in Australia.",
            "you were living in Australia.",
            "he was living in Australia.",
            "she was living in Australia.",
            "it was living in Australia.",
            "we were living in Australia.",
            "you were living in Australia.",
            "they were living in Australia.",
            "John was living in Australia.",
            "Emily was living in Australia.",
            "I was not living in Australia.",
            "you were not living in Australia.",
            "he was not living in Australia.",
            "she was not living in Australia.",
            "it was not living in Australia.",
            "we were not living in Australia.",
            "you were not living in Australia.",
            "they were not living in Australia.",
            "John was not living in Australia.",
            "Emily was not living in Australia.",
            "was I living in Australia?",
            "were you living in Australia?",
            "was he living in Australia?",
            "was she living in Australia?",
            "was it living in Australia?",
            "were we living in Australia?",
            "were you living in Australia?",
            "were they living in Australia?",
            "was John living in Australia?",
            "was Emily living in Australia?",
        )
        val lessen = whereAreYouLiveLessen(Tens.PAST_CONTINUOUS)
        assert(check(sentences, lessen))
    }

    @Test
    fun whereAreYouLivePastPerfect() {
        val sentences = listOf(
            "I had lived in Australia.",
            "you had lived in Australia.",
            "he had lived in Australia.",
            "she had lived in Australia.",
            "it had lived in Australia.",
            "we had lived in Australia.",
            "you had lived in Australia.",
            "they had lived in Australia.",
            "John had lived in Australia.",
            "Emily had lived in Australia.",
            "I had not lived in Australia.",
            "you had not lived in Australia.",
            "he had not lived in Australia.",
            "she had not lived in Australia.",
            "it had not lived in Australia.",
            "we had not lived in Australia.",
            "you had not lived in Australia.",
            "they had not lived in Australia.",
            "John had not lived in Australia.",
            "Emily had not lived in Australia.",
            "had I lived in Australia?",
            "had you lived in Australia?",
            "had he lived in Australia?",
            "had she lived in Australia?",
            "had it lived in Australia?",
            "had we lived in Australia?",
            "had you lived in Australia?",
            "had they lived in Australia?",
            "had John lived in Australia?",
            "had Emily lived in Australia?",
        )
        val lessen = whereAreYouLiveLessen(Tens.PAST_PERFECT)
        assert(check(sentences, lessen))
    }

    @Test
    fun whereAreYouLivePastPerfectContinuous() {
        val sentences = listOf(
            "I had been living in Australia.",
            "you had been living in Australia.",
            "he had been living in Australia.",
            "she had been living in Australia.",
            "it had been living in Australia.",
            "we had been living in Australia.",
            "you had been living in Australia.",
            "they had been living in Australia.",
            "John had been living in Australia.",
            "Emily had been living in Australia.",
            "I had not been living in Australia.",
            "you had not been living in Australia.",
            "he had not been living in Australia.",
            "she had not been living in Australia.",
            "it had not been living in Australia.",
            "we had not been living in Australia.",
            "you had not been living in Australia.",
            "they had not been living in Australia.",
            "John had not been living in Australia.",
            "Emily had not been living in Australia.",
            "had I been living in Australia?",
            "had you been living in Australia?",
            "had he been living in Australia?",
            "had she been living in Australia?",
            "had it been living in Australia?",
            "had we been living in Australia?",
            "had you been living in Australia?",
            "had they been living in Australia?",
            "had John been living in Australia?",
            "had Emily been living in Australia?",
        )
        val lessen = whereAreYouLiveLessen(Tens.PAST_PERFECT_CONTINUOUS)
        assert(check(sentences, lessen))
    }

    @Test
    fun whereAreYouLiveFutureSimple() {
        val sentences = listOf(
            "I will live in Australia.",
            "you will live in Australia.",
            "he will live in Australia.",
            "she will live in Australia.",
            "it will live in Australia.",
            "we will live in Australia.",
            "you will live in Australia.",
            "they will live in Australia.",
            "John will live in Australia.",
            "Emily will live in Australia.",
            "I will not live in Australia.",
            "you will not live in Australia.",
            "he will not live in Australia.",
            "she will not live in Australia.",
            "it will not live in Australia.",
            "we will not live in Australia.",
            "you will not live in Australia.",
            "they will not live in Australia.",
            "John will not live in Australia.",
            "Emily will not live in Australia.",
            "will I live in Australia?",
            "will you live in Australia?",
            "will he live in Australia?",
            "will she live in Australia?",
            "will it live in Australia?",
            "will we live in Australia?",
            "will you live in Australia?",
            "will they live in Australia?",
            "will John live in Australia?",
            "will Emily live in Australia?",
        )
        val lessen = whereAreYouLiveLessen(Tens.FUTURE_SIMPLE)
        assert(check(sentences, lessen))
    }

    @Test
    fun whereAreYouLiveFutureContinuous() {
        val sentences = listOf(
            "I will be living in Australia.",
            "you will be living in Australia.",
            "he will be living in Australia.",
            "she will be living in Australia.",
            "it will be living in Australia.",
            "we will be living in Australia.",
            "you will be living in Australia.",
            "they will be living in Australia.",
            "John will be living in Australia.",
            "Emily will be living in Australia.",
            "I will not be living in Australia.",
            "you will not be living in Australia.",
            "he will not be living in Australia.",
            "she will not be living in Australia.",
            "it will not be living in Australia.",
            "we will not be living in Australia.",
            "you will not be living in Australia.",
            "they will not be living in Australia.",
            "John will not be living in Australia.",
            "Emily will not be living in Australia.",
            "will I be living in Australia?",
            "will you be living in Australia?",
            "will he be living in Australia?",
            "will she be living in Australia?",
            "will it be living in Australia?",
            "will we be living in Australia?",
            "will you be living in Australia?",
            "will they be living in Australia?",
            "will John be living in Australia?",
            "will Emily be living in Australia?",
        )
        val lessen = whereAreYouLiveLessen(Tens.FUTURE_CONTINUOUS)
        assert(check(sentences, lessen))
    }

    @Test
    fun whereAreYouLiveFuturePerfect() {
        val sentences = listOf(
            "I will have lived in Australia.",
            "you will have lived in Australia.",
            "he will have lived in Australia.",
            "she will have lived in Australia.",
            "it will have lived in Australia.",
            "we will have lived in Australia.",
            "you will have lived in Australia.",
            "they will have lived in Australia.",
            "John will have lived in Australia.",
            "Emily will have lived in Australia.",
            "I will not have lived in Australia.",
            "you will not have lived in Australia.",
            "he will not have lived in Australia.",
            "she will not have lived in Australia.",
            "it will not have lived in Australia.",
            "we will not have lived in Australia.",
            "you will not have lived in Australia.",
            "they will not have lived in Australia.",
            "John will not have lived in Australia.",
            "Emily will not have lived in Australia.",
            "will I have lived in Australia?",
            "will you have lived in Australia?",
            "will he have lived in Australia?",
            "will she have lived in Australia?",
            "will it have lived in Australia?",
            "will we have lived in Australia?",
            "will you have lived in Australia?",
            "will they have lived in Australia?",
            "will John have lived in Australia?",
            "will Emily have lived in Australia?",
        )
        val lessen = whereAreYouLiveLessen(Tens.FUTURE_PERFECT)
        assert(check(sentences, lessen))
    }

    @Test
    fun whereAreYouLiveFuturePerfectContinuous() {
        val sentences = listOf(
            "I will have been living in Australia.",
            "you will have been living in Australia.",
            "he will have been living in Australia.",
            "she will have been living in Australia.",
            "it will have been living in Australia.",
            "we will have been living in Australia.",
            "you will have been living in Australia.",
            "they will have been living in Australia.",
            "John will have been living in Australia.",
            "Emily will have been living in Australia.",
            "I will not have been living in Australia.",
            "you will not have been living in Australia.",
            "he will not have been living in Australia.",
            "she will not have been living in Australia.",
            "it will not have been living in Australia.",
            "we will not have been living in Australia.",
            "you will not have been living in Australia.",
            "they will not have been living in Australia.",
            "John will not have been living in Australia.",
            "Emily will not have been living in Australia.",
            "will I have been living in Australia?",
            "will you have been living in Australia?",
            "will he have been living in Australia?",
            "will she have been living in Australia?",
            "will it have been living in Australia?",
            "will we have been living in Australia?",
            "will you have been living in Australia?",
            "will they have been living in Australia?",
            "will John have been living in Australia?",
            "will Emily have been living in Australia?",
        )
        val lessen = whereAreYouLiveLessen(Tens.FUTURE_PERFECT_CONTINUOUS)
        assert(check(sentences, lessen))
    }

}