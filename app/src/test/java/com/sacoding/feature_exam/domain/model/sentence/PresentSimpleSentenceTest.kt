package com.sacoding.feature_exam.domain.model.sentence

import com.sacoding.feature_exam.data.data_source.Verbs
import com.sacoding.feature_exam.data.data_source.addPreposition
import com.sacoding.feature_exam.domain.SentenceType
import com.sacoding.feature_exam.domain.Tens
import com.sacoding.feature_exam.domain.use_case.GenerateSentenceUseCase
import org.junit.Test

class PresentSimpleSentenceTest {

    @Test
    fun positive() {
        val iAmBulgarian = createPositiveSentence("I", "Bulgarian")
        assert(iAmBulgarian == "I am Bulgarian.")

//        val iAmAProgrammer = createPositiveSentence("I", "programmer".addArticle())
//        assert(iAmAProgrammer == "I am a programmer.")

        val iAmFromBulgaria = createPositiveSentence("I", "Bulgaria".addPreposition("from"))
        assert(iAmFromBulgaria == "I am from Bulgaria.")

        val itIsMine = createPositiveSentence("it", "mine")
        assert(itIsMine == "It is mine.")

        val thisIsMyBook = createPositiveSentence("This", "my book")
        assert(thisIsMyBook == "This is my book.")

        val theseAreMyKeys = createPositiveSentence("These", "my keys")
        assert(theseAreMyKeys == "These are my keys.")
    }

    private fun createPositiveSentence(subject: String, objectVal: String): String {
        val sentence = GenerateSentenceUseCase().invoke(
            sentenceType = SentenceType.POSITIVE,
            tens = Tens.PRESENT_SIMPLE,
            subject = subject,
            questionWord = "",
            verb = Verbs.toBe,
            objectVal = objectVal,
        )
        println(sentence)
        return sentence
    }

    @Test
    fun negative() {
        val iAmBulgarian = createNegativeSentence("I", "Bulgarian")
        assert(iAmBulgarian == "I am not Bulgarian.")

//        val iAmAProgrammer = createNegativeSentence("I", "programmer".addArticle())
//        assert(iAmAProgrammer == "I am not a programmer.")

        val iAmFromBulgaria = createNegativeSentence("I", "Bulgaria".addPreposition("from"))
        assert(iAmFromBulgaria == "I am not from Bulgaria.")

        val itIsNotMine = createNegativeSentence("it", "mine")
        assert(itIsNotMine == "It is not mine.")

        val thisIsNotMyBook = createNegativeSentence("This", "my book")
        assert(thisIsNotMyBook == "This is not my book.")

        val theseAreNotMyKeys = createNegativeSentence("These", "my keys")
        assert(theseAreNotMyKeys == "These are not my keys.")
    }

    private fun createNegativeSentence(subject: String, objectVal: String): String {
        val sentence = GenerateSentenceUseCase().invoke(
            sentenceType = SentenceType.NEGATIVE,
            tens = Tens.PRESENT_SIMPLE,
            subject = subject,
            questionWord = "",
            verb = Verbs.toBe,
            objectVal = objectVal,
        )
        println(sentence)
        return sentence
    }

    @Test
    fun question() {
        val amIBulgarian = createQuestionSentence(subject = "I", questionWord = "", objectVal = "Bulgarian")
        assert(amIBulgarian == "Am I Bulgarian?")

//        val amIAProgrammer = createQuestionSentence(subject = "I", questionWord = "", objectVal = "programmer".addArticle())
//        assert(amIAProgrammer == "Am I a programmer?")

        val amIFromBulgaria = createQuestionSentence(subject = "I", questionWord = "", objectVal = "Bulgaria".addPreposition("from"))
        assert(amIFromBulgaria == "Am I from Bulgaria?")

        val whoAreYpuMeeting = createQuestionSentence(subject = "you", questionWord = "Who", objectVal = "meeting")
        assert(whoAreYpuMeeting == "Who are you meeting?")

        val whereIsSheFrom = createQuestionSentence(subject = "she", questionWord = "Where", objectVal = "from")
        assert(whereIsSheFrom == "Where is she from?")

        val whenAreTheyArriving = createQuestionSentence(subject = "they", questionWord = "When", objectVal = "arriving")
        assert(whenAreTheyArriving == "When are they arriving?")

//        val whyAmIATeacher = createQuestionSentence(subject = "I", questionWord = "Why", objectVal = "teacher".addArticle())
//        assert(whyAmIATeacher == "Why am I a teacher?")

        val isItMine = createQuestionSentence(subject = "it", questionWord = "", objectVal = "mine")
        assert(isItMine == "Is it mine?")

        val isThisMyBook = createQuestionSentence("this", questionWord = "", "my book")
        assert(isThisMyBook == "Is this my book?")

        val areTheseAreNotMyKeys = createQuestionSentence("these", questionWord = "", "my keys")
        assert(areTheseAreNotMyKeys == "Are these my keys?")
    }

    private fun createQuestionSentence(subject: String, questionWord: String, objectVal: String): String {
        val sentence = GenerateSentenceUseCase().invoke(
            sentenceType = SentenceType.QUESTION,
            tens = Tens.PRESENT_SIMPLE,
            subject = subject,
            questionWord = questionWord,
            verb = Verbs.toBe,
            objectVal = objectVal,
        )
        println(sentence)
        return sentence
    }
}