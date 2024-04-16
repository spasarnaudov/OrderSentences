package com.spascoding.feature_exam.domain.model.sentence

import com.spascoding.feature_exam.data.data_source.Nouns
import com.spascoding.feature_exam.data.data_source.Verbs
import com.spascoding.feature_exam.domain.Article
import com.spascoding.feature_exam.domain.SentenceType
import com.spascoding.feature_exam.domain.Tens
import com.spascoding.feature_exam.domain.model.Adjective
import com.spascoding.feature_exam.domain.model.noun.Noun
import com.spascoding.feature_exam.domain.model.noun.Pronoun
import com.spascoding.feature_exam.domain.use_case.GenerateSentenceUseCase
import org.junit.Test

class PresentSimpleSentenceTest {

    @Test
    fun positive() {
        val iAmBulgarian = createPositiveSentence(Pronoun.I, Nouns.bulgarian.build())
        assert(iAmBulgarian == "I am Bulgarian.")

        val iAmAProgrammer = createPositiveSentence(Pronoun.I, Nouns.programmer.copy(article = Article.INDEFINITE).build())
        assert(iAmAProgrammer == "I am a programmer.")

        val iAmFromBulgaria = createPositiveSentence(Pronoun.I, Nouns.bulgaria.copy(preposition = "from").build())
        assert(iAmFromBulgaria == "I am from Bulgaria.")

        val itIsMine = createPositiveSentence(Pronoun.IT, Pronoun.MINE.build())
        assert(itIsMine == "It is mine.")

        val thisIsMyBook = createPositiveSentence(Pronoun.THIS, Nouns.book.copy(adjective = Adjective.MY).build())
        assert(thisIsMyBook == "This is my book.")

        val theseAreMyKeys = createPositiveSentence(Pronoun.THESE, Nouns.key.plural().copy(adjective = Adjective.MY).build())
        assert(theseAreMyKeys == "These are my keys.")
    }

    private fun createPositiveSentence(noun: Noun, objectVal: String): String {
        val sentence = GenerateSentenceUseCase().invoke(
            sentenceType = SentenceType.POSITIVE,
            tens = Tens.PRESENT_SIMPLE,
            subject = noun,
            verb = Verbs.toBe,
            objectVal = objectVal,
        )
        println(sentence)
        return sentence
    }

    @Test
    fun negative() {
        val iAmNotBulgarian = createNegativeSentence(Pronoun.I, Nouns.bulgarian.build())
        assert(iAmNotBulgarian == "I am not Bulgarian.")

        val iAmNotAProgrammer = createNegativeSentence(Pronoun.I, Nouns.programmer.copy(article = Article.INDEFINITE).build())
        assert(iAmNotAProgrammer == "I am not a programmer.")

        val iAmNotFromBulgaria = createNegativeSentence(Pronoun.I, Nouns.bulgaria.copy(preposition = "from").build())
        assert(iAmNotFromBulgaria == "I am not from Bulgaria.")

        val itIsNotMine = createNegativeSentence(Pronoun.IT, Pronoun.MINE.build())
        assert(itIsNotMine == "It is not mine.")

        val thisIsNotMyBook = createNegativeSentence(Pronoun.THIS, Nouns.book.copy(adjective = Adjective.MY).build())
        assert(thisIsNotMyBook == "This is not my book.")

        val theseAreNotMyKeys = createNegativeSentence(Pronoun.THESE, Nouns.key.plural().copy(adjective = Adjective.MY).build())
        assert(theseAreNotMyKeys == "These are not my keys.")
    }

    private fun createNegativeSentence(noun: Noun, objectVal: String): String {
        val sentence = GenerateSentenceUseCase().invoke(
            sentenceType = SentenceType.NEGATIVE,
            tens = Tens.PRESENT_SIMPLE,
            subject = noun,
            verb = Verbs.toBe,
            objectVal = objectVal,
        )
        println(sentence)
        return sentence
    }

    @Test
    fun question() {
        val amIBulgarian = createQuestionSentence(subject = Pronoun.I, questionWord = "", objectVal = Nouns.bulgarian.build())
        assert(amIBulgarian == "Am I Bulgarian?")

        val amIAProgrammer = createQuestionSentence(subject = Pronoun.I, questionWord = "", objectVal = Nouns.programmer.copy(article = Article.INDEFINITE).build())
        assert(amIAProgrammer == "Am I a programmer?")

        val amIFromBulgaria = createQuestionSentence(subject = Pronoun.I, questionWord = "", objectVal = Nouns.bulgaria.copy(preposition = "from").build())
        assert(amIFromBulgaria == "Am I from Bulgaria?")

        val whoAreYpuMeeting = createQuestionSentence(subject = Pronoun.YOU, questionWord = "Who", objectVal = "meeting")
        assert(whoAreYpuMeeting == "Who are you meeting?")

        val whereIsSheFrom = createQuestionSentence(subject = Pronoun.SHE, questionWord = "Where", objectVal = "from")
        assert(whereIsSheFrom == "Where is she from?")

        val whenAreTheyArriving = createQuestionSentence(subject = Pronoun.THEY, questionWord = "When", objectVal = "arriving")
        assert(whenAreTheyArriving == "When are they arriving?")

        val whyAmIATeacher = createQuestionSentence(subject = Pronoun.I, questionWord = "Why", objectVal = Nouns.teacher.copy(article = Article.INDEFINITE).build())
        assert(whyAmIATeacher == "Why am I a teacher?")

        val isItMine = createQuestionSentence(subject = Pronoun.IT, questionWord = "", objectVal = Pronoun.MINE.build())
        assert(isItMine == "Is it mine?")

        val isThisMyBook = createQuestionSentence(Pronoun.THIS, questionWord = "", Nouns.book.copy(adjective = Adjective.MY).build())
        assert(isThisMyBook == "Is this my book?")

        val areTheseAreNotMyKeys = createQuestionSentence(Pronoun.THESE, questionWord = "", Nouns.key.plural().copy(adjective = Adjective.MY).build())
        assert(areTheseAreNotMyKeys == "Are these my keys?")
    }

    private fun createQuestionSentence(subject: Noun, questionWord: String, objectVal: String): String {
        val sentence = GenerateSentenceUseCase().invoke(
            sentenceType = SentenceType.QUESTION,
            tens = Tens.PRESENT_SIMPLE,
            subject = subject,
            verb = Verbs.toBe,
            objectVal = objectVal,
        )
        println(sentence)
        return sentence
    }
}