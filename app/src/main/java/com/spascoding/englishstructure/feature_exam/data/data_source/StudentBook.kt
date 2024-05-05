package com.spascoding.englishstructure.feature_exam.data.data_source

import com.spascoding.englishstructure.feature_exam.data.data_source.sentence_parts.Adjectives
import com.spascoding.englishstructure.feature_exam.data.data_source.sentence_parts.Nouns
import com.spascoding.englishstructure.feature_exam.data.data_source.sentence_parts.Pronouns
import com.spascoding.englishstructure.feature_exam.data.data_source.sentence_parts.Verbs
import com.spascoding.englishstructure.feature_exam.domain.enums.Article
import com.spascoding.englishstructure.feature_exam.domain.enums.Tens
import com.spascoding.englishstructure.feature_exam.domain.model.ExamPattern
import com.spascoding.englishstructure.feature_exam.domain.model.Preposition
import com.spascoding.englishstructure.feature_exam.domain.model.noun.addAdjective
import com.spascoding.englishstructure.feature_exam.domain.model.noun.addArticle
import com.spascoding.englishstructure.feature_exam.domain.model.noun.addPreposition
import com.spascoding.englishstructure.feature_exam.domain.model.noun.build

object StudentBook {
    private const val HELLO = "hello"
    private const val MUSIC = "music"
    private const val GAME = "game"
    private const val TRAVEL = "travel"
    private const val KITCHEN = "kitchen"
    private const val SCHOOL = "school"

    fun examPatterns(): List<ExamPattern> {
        return hello()
            .asSequence()
            .plus(music())
            .plus(game())
            .plus(travel())
            .plus(kitchen())
            .plus(school())
            .toList()
    }

//    Exams

    private fun hello(): List<ExamPattern> {
        return listOf(
            //My name is
            ExamPattern(
                name = HELLO,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = listOf(Nouns.name).addAdjective(Adjectives.Possessive.singular),
                verbs = listOf(Verbs.toBe),
                objects = Nouns.names.build(),
            ),
            //I am from
            ExamPattern(
                name = HELLO,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
                verbs = listOf(Verbs.toBe),
                objects = Nouns.countries.addPreposition(Preposition.FROM).build(),
            ),
            //My job
            ExamPattern(
                name = HELLO,
                tenses = listOf(Tens.PRESENT_SIMPLE),
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
                verbs = listOf(Verbs.toBe),
                objects = Nouns.jobs.addArticle(Article.INDEFINITE).build(),
            ),
        )
    }

    private fun music(): List<ExamPattern> {
        return listOf(
            //Play music
            ExamPattern(
                name = MUSIC,
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
                verbs = listOf(Verbs.play),
                objects = Nouns.musicalInstruments.addArticle(Article.DEFINITE).build(),
            ),
            //Sing a song
            ExamPattern(
                name = MUSIC,
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
                verbs = listOf(Verbs.sing),
                objects = listOf(Nouns.song).build(),
            ),
        )
    }

    private fun game(): List<ExamPattern> {
        return listOf(
            //Play game
            ExamPattern(
                name = GAME,
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
                verbs = listOf(Verbs.play),
                objects = Nouns.games.build(),
            ),
        )
    }

    private fun travel(): List<ExamPattern> {
        return listOf(
            //Visit places
            ExamPattern(
                name = TRAVEL,
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
                verbs = listOf(Verbs.visit),
                objects = Nouns.places.addArticle(Article.DEFINITE).build(),
            ),
            //Walk
            ExamPattern(
                name = TRAVEL,
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
                verbs = listOf(Verbs.walk),
                objects = listOf(Nouns.school).addPreposition(Preposition.TO).build(),
            )
        )
    }

    private fun kitchen(): List<ExamPattern> {
        return listOf(
            //Eat
            ExamPattern(
                name = KITCHEN,
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
                verbs = listOf(Verbs.eat),
                objects = Nouns.fruits.addArticle(Article.INDEFINITE).build(),
            ),
            //Cook
            ExamPattern(
                name = KITCHEN,
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
                verbs = listOf(Verbs.cook),
                objects = Nouns.vegetablesForCook.addArticle(Article.INDEFINITE).build(),
            ),
            //Drink
            ExamPattern(
                name = KITCHEN,
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
                verbs = listOf(Verbs.drink),
                objects = Nouns.drinks.addArticle(Article.INDEFINITE).build(),
            ),
        )
    }

    private fun school(): List<ExamPattern> {
        return listOf(
            //Write, read
            ExamPattern(
                name = SCHOOL,
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
                verbs = listOf(Verbs.write, Verbs.read),
                objects = Nouns.writeReadMaterials.addArticle(Article.INDEFINITE).build(),
            ),
            //Learn, study, teach
            ExamPattern(
                name = SCHOOL,
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
                verbs = listOf(Verbs.learn, Verbs.study, Verbs.teach),
                objects = Nouns.languages.plus(Nouns.schoolSubjects).addArticle(Article.INDEFINITE).build(),
            ),
            //I paint
            ExamPattern(
                name = SCHOOL,
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
                verbs = listOf(Verbs.paint),
                objects = listOf(Nouns.picture).addArticle(Article.INDEFINITE).build(),
            )
        )
    }

    /*private val theCatSleepsOnTheSofa = listOfExams { tens -> theCatSleepsOnTheSofa(tens) }
    private fun theCatSleepsOnTheSofa(tens: Tens): Exam {
        return Exam(
            tens = tens,
            subjects = Nouns.pets.addArticle(Article.DEFINITE),
            verbs = listOf(Verbs.sleep),
            objects = listOf(Nouns.sofa).addPreposition(Preposition.ON).addArticle(Article.DEFINITE).build(),
        )
    }

    private val iWalkToSchool = listOfExams { tens -> iWalkToSchool(tens) }
    private fun iWalkToSchool(tens: Tens): Exam {
        return Exam(
            tens = tens,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names).plus(Nouns.teacher.copy(article = Article.DEFINITE)),
            verbs = listOf(Verbs.walk),
            objects = listOf(Nouns.school).addPreposition(Preposition.TO).build(),
        )
    }

    private val iWatchMovie = listOfExams { tens -> iWatchMovie(tens) }
    private fun iWatchMovie(tens: Tens): Exam {
        return Exam(
            tens = tens,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names).plus(Nouns.teacher.copy(article = Article.DEFINITE)),
            verbs = listOf(Verbs.watch),
            objects = listOf(Nouns.movie).build(),
        )
    }*/
}