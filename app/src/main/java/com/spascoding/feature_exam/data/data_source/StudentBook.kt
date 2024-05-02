package com.spascoding.feature_exam.data.data_source

import com.spascoding.feature_exam.domain.enums.Article
import com.spascoding.feature_exam.domain.model.ExamPattern
import com.spascoding.feature_exam.domain.model.noun.addArticle
import com.spascoding.feature_exam.domain.model.noun.build

object StudentBook {
    val musicPattern = "music"
    val gamePattern = "game"
    val travelPattern = "travel"
    val kitchenPattern = "kitchen"
    val schoolPattern = "school"

    fun examPatterns(): List<ExamPattern> {
        return listOf(
            playMusic(),
            playGame(),
            visitPlaces(),
            eat(),
            cook(),
            drink(),
            writeRead(),
            learn(),
        )
    }

//    Exams

    private fun playMusic(): ExamPattern {
        return ExamPattern(
            name = musicPattern,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
            verbs = listOf(Verbs.play),
            objects = Nouns.musicalInstruments.addArticle(Article.DEFINITE).build(),
        )
    }

    private fun playGame(): ExamPattern {
        return ExamPattern(
            name = gamePattern,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
            verbs = listOf(Verbs.play),
            objects = Nouns.games.build(),
        )
    }

    private fun visitPlaces(): ExamPattern {
        return ExamPattern(
            name = travelPattern,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
            verbs = listOf(Verbs.visit),
            objects = Nouns.places.addArticle(Article.DEFINITE).build(),
        )
    }

    private fun eat(): ExamPattern {
        return ExamPattern(
            name = kitchenPattern,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names).plus(Nouns.teacher.copy(article = Article.DEFINITE)),
            verbs = listOf(Verbs.eat),
            objects = Nouns.fruits.addArticle(Article.INDEFINITE).build(),
        )
    }

    private fun cook(): ExamPattern {
        return ExamPattern(
            name = kitchenPattern,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
            verbs = listOf(Verbs.cook),
            objects = Nouns.vegetablesForCook.addArticle(Article.INDEFINITE).build(),
        )
    }

    private fun drink(): ExamPattern {
        return ExamPattern(
            name = kitchenPattern,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
            verbs = listOf(Verbs.drink),
            objects = Nouns.drinks.addArticle(Article.INDEFINITE).build(),
        )
    }

    private fun writeRead(): ExamPattern {
        return ExamPattern(
            name = schoolPattern,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
            verbs = listOf(Verbs.write, Verbs.read),
            objects = Nouns.writeReadMaterials.addArticle(Article.INDEFINITE).build(),
        )
    }

    private fun learn(): ExamPattern {
        return ExamPattern(
            name = schoolPattern,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
            verbs = listOf(Verbs.learn, Verbs.study, Verbs.teach),
            objects = Nouns.nationals.plus(Nouns.schoolSubjects).addArticle(Article.INDEFINITE).build(),
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

    private val iSingASong = listOfExams { tens -> iSingASong(tens) }
    private fun iSingASong(tens: Tens): Exam {
        return Exam(
            tens = tens,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
            verbs = listOf(Verbs.sing),
            objects = listOf(Nouns.song).build(),
        )
    }

    private val iPaintAPicture = listOfExams { tens -> iPaintAPicture(tens) }
    private fun iPaintAPicture(tens: Tens): Exam {
        return Exam(
            tens = tens,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names).plus(Nouns.teacher.copy(article = Article.DEFINITE)),
            verbs = listOf(Verbs.paint),
            objects = listOf(Nouns.picture).addArticle(Article.INDEFINITE).build(),
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