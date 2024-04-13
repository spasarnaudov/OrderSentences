package com.sacoding.feature_exam.domain.model.sentence

import com.sacoding.feature_exam.data.data_source.Verbs
import com.sacoding.feature_exam.data.data_source.addPreposition
import com.sacoding.feature_exam.domain.Article
import com.sacoding.feature_exam.domain.SentenceType
import com.sacoding.feature_exam.domain.Tens
import com.sacoding.feature_exam.domain.model.noun.Noun
import com.sacoding.feature_exam.domain.model.noun.Pronoun
import com.sacoding.feature_exam.domain.model.noun.SingularNoun
import com.sacoding.feature_exam.domain.use_case.GenerateSentenceUseCase
import org.junit.Test

class PresentSimpleSentenceTest {

    @Test
    fun positive() {
        val iAmBulgarian = createPositiveSentence(Pronoun.I, SingularNoun(value = "Bulgarian").build())
        assert(iAmBulgarian == "I am Bulgarian.")

        val iAmAProgrammer = createPositiveSentence(Pronoun.I, SingularNoun(value = "programmer", article = Article.INDEFINITE).build())
        assert(iAmAProgrammer == "I am a programmer.")

        val iAmFromBulgaria = createPositiveSentence(Pronoun.I, SingularNoun(value = "Bulgaria", preposition = "from").build())
        assert(iAmFromBulgaria == "I am from Bulgaria.")

        val itIsMine = createPositiveSentence(Pronoun.IT, Pronoun.MINE.build())
        assert(itIsMine == "It is mine.")

        val thisIsMyBook = createPositiveSentence(Pronoun.THIS, "my book")
        assert(thisIsMyBook == "This is my book.")

        val theseAreMyKeys = createPositiveSentence(Pronoun.THESE, "my keys")
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
        val iAmBulgarian = createNegativeSentence(Pronoun.I, "Bulgarian")
        assert(iAmBulgarian == "I am not Bulgarian.")

        val iAmAProgrammer = createNegativeSentence(Pronoun.I, "a programmer")
        assert(iAmAProgrammer == "I am not a programmer.")

        val iAmFromBulgaria = createNegativeSentence(Pronoun.I, "Bulgaria".addPreposition("from"))
        assert(iAmFromBulgaria == "I am not from Bulgaria.")

        val itIsNotMine = createNegativeSentence(Pronoun.IT, "mine")
        assert(itIsNotMine == "It is not mine.")

        val thisIsNotMyBook = createNegativeSentence(Pronoun.THIS, "my book")
        assert(thisIsNotMyBook == "This is not my book.")

        val theseAreNotMyKeys = createNegativeSentence(Pronoun.THESE, "my keys")
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
        val amIBulgarian = createQuestionSentence(subject = Pronoun.I, questionWord = "", objectVal = "Bulgarian")
        assert(amIBulgarian == "Am I Bulgarian?")

        val amIAProgrammer = createQuestionSentence(subject = Pronoun.I, questionWord = "", objectVal = "a programmer")
        assert(amIAProgrammer == "Am I a programmer?")

        val amIFromBulgaria = createQuestionSentence(subject = Pronoun.I, questionWord = "", objectVal = "Bulgaria".addPreposition("from"))
        assert(amIFromBulgaria == "Am I from Bulgaria?")

        val whoAreYpuMeeting = createQuestionSentence(subject = Pronoun.YOU, questionWord = "Who", objectVal = "meeting")
        assert(whoAreYpuMeeting == "Who are you meeting?")

        val whereIsSheFrom = createQuestionSentence(subject = Pronoun.SHE, questionWord = "Where", objectVal = "from")
        assert(whereIsSheFrom == "Where is she from?")

        val whenAreTheyArriving = createQuestionSentence(subject = Pronoun.THEY, questionWord = "When", objectVal = "arriving")
        assert(whenAreTheyArriving == "When are they arriving?")

        val whyAmIATeacher = createQuestionSentence(subject = Pronoun.I, questionWord = "Why", objectVal = "a teacher")
        assert(whyAmIATeacher == "Why am I a teacher?")

        val isItMine = createQuestionSentence(subject = Pronoun.IT, questionWord = "", objectVal = "mine")
        assert(isItMine == "Is it mine?")

        val isThisMyBook = createQuestionSentence(Pronoun.THIS, questionWord = "", "my book")
        assert(isThisMyBook == "Is this my book?")

        val areTheseAreNotMyKeys = createQuestionSentence(Pronoun.THESE, questionWord = "", "my keys")
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