package com.sacoding.feature_exam.domain.model.sentence

import com.sacoding.feature_exam.data.data_source.Verbs
import com.sacoding.feature_exam.data.data_source.addPreposition
import com.sacoding.feature_exam.domain.Article
import com.sacoding.feature_exam.domain.SentenceType
import com.sacoding.feature_exam.domain.Tens
import com.sacoding.feature_exam.domain.model.noun.DemonstrativePronoun
import com.sacoding.feature_exam.domain.model.noun.Noun
import com.sacoding.feature_exam.domain.model.noun.PluralPronoun
import com.sacoding.feature_exam.domain.model.noun.SingularNoun
import com.sacoding.feature_exam.domain.model.noun.SingularPossessivePronoun
import com.sacoding.feature_exam.domain.model.noun.SingularPronoun
import com.sacoding.feature_exam.domain.use_case.GenerateSentenceUseCase
import org.junit.Test

class PresentSimpleSentenceTest {

    @Test
    fun positive() {
        val iAmBulgarian = createPositiveSentence(SingularPronoun.I, SingularNoun(value = "Bulgarian").build())
        assert(iAmBulgarian == "I am Bulgarian.")

        val iAmAProgrammer = createPositiveSentence(SingularPronoun.I, SingularNoun(value = "programmer", article = Article.INDEFINITE).build())
        assert(iAmAProgrammer == "I am a programmer.")

        val iAmFromBulgaria = createPositiveSentence(SingularPronoun.I, SingularNoun(value = "Bulgaria", preposition = "from").build())
        assert(iAmFromBulgaria == "I am from Bulgaria.")

        val itIsMine = createPositiveSentence(SingularPronoun.IT, SingularPossessivePronoun.MINE.build())
        assert(itIsMine == "It is mine.")

        val thisIsMyBook = createPositiveSentence(DemonstrativePronoun.THIS, "my book")
        assert(thisIsMyBook == "This is my book.")

        val theseAreMyKeys = createPositiveSentence(DemonstrativePronoun.THESE, "my keys")
        assert(theseAreMyKeys == "These are my keys.")
    }

    private fun createPositiveSentence(subject: Noun, objectVal: String): String {
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
        val iAmBulgarian = createNegativeSentence(SingularPronoun.I, "Bulgarian")
        assert(iAmBulgarian == "I am not Bulgarian.")

        val iAmAProgrammer = createNegativeSentence(SingularPronoun.I, "a programmer")
        assert(iAmAProgrammer == "I am not a programmer.")

        val iAmFromBulgaria = createNegativeSentence(SingularPronoun.I, "Bulgaria".addPreposition("from"))
        assert(iAmFromBulgaria == "I am not from Bulgaria.")

        val itIsNotMine = createNegativeSentence(SingularPronoun.IT, "mine")
        assert(itIsNotMine == "It is not mine.")

        val thisIsNotMyBook = createNegativeSentence(DemonstrativePronoun.THIS, "my book")
        assert(thisIsNotMyBook == "This is not my book.")

        val theseAreNotMyKeys = createNegativeSentence(DemonstrativePronoun.THESE, "my keys")
        assert(theseAreNotMyKeys == "These are not my keys.")
    }

    private fun createNegativeSentence(subject: Noun, objectVal: String): String {
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
        val amIBulgarian = createQuestionSentence(subject = SingularPronoun.I, questionWord = "", objectVal = "Bulgarian")
        assert(amIBulgarian == "Am I Bulgarian?")

        val amIAProgrammer = createQuestionSentence(subject = SingularPronoun.I, questionWord = "", objectVal = "a programmer")
        assert(amIAProgrammer == "Am I a programmer?")

        val amIFromBulgaria = createQuestionSentence(subject = SingularPronoun.I, questionWord = "", objectVal = "Bulgaria".addPreposition("from"))
        assert(amIFromBulgaria == "Am I from Bulgaria?")

        val whoAreYpuMeeting = createQuestionSentence(subject = SingularPronoun.YOU, questionWord = "Who", objectVal = "meeting")
        assert(whoAreYpuMeeting == "Who are you meeting?")

        val whereIsSheFrom = createQuestionSentence(subject = SingularPronoun.SHE, questionWord = "Where", objectVal = "from")
        assert(whereIsSheFrom == "Where is she from?")

        val whenAreTheyArriving = createQuestionSentence(subject = PluralPronoun.THEY, questionWord = "When", objectVal = "arriving")
        assert(whenAreTheyArriving == "When are they arriving?")

        val whyAmIATeacher = createQuestionSentence(subject = SingularPronoun.I, questionWord = "Why", objectVal = "a teacher")
        assert(whyAmIATeacher == "Why am I a teacher?")

        val isItMine = createQuestionSentence(subject = SingularPronoun.IT, questionWord = "", objectVal = "mine")
        assert(isItMine == "Is it mine?")

        val isThisMyBook = createQuestionSentence(DemonstrativePronoun.THIS, questionWord = "", "my book")
        assert(isThisMyBook == "Is this my book?")

        val areTheseAreNotMyKeys = createQuestionSentence(DemonstrativePronoun.THESE, questionWord = "", "my keys")
        assert(areTheseAreNotMyKeys == "Are these my keys?")
    }

    private fun createQuestionSentence(subject: Noun, questionWord: String, objectVal: String): String {
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