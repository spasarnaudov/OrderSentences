package com.spascoding.feature_exam.data.data_source

import com.spascoding.feature_exam.domain.Article
import com.spascoding.feature_exam.domain.Tens
import com.spascoding.feature_exam.domain.model.Exam
import com.spascoding.feature_exam.domain.model.noun.addArticle
import com.spascoding.feature_exam.domain.model.noun.build

object StudentBook {
    object Beginner {           val exams = exams(Tens.PRESENT_SIMPLE, Tens.PAST_SIMPLE) }
    object Elementary {         val exams = exams(Tens.PRESENT_CONTINUOUS, Tens.PAST_CONTINUOUS, Tens.FUTURE_SIMPLE) }
    object Intermediate {       val exams = exams(Tens.PRESENT_PERFECT, Tens.FUTURE_CONTINUOUS) }
    object UpperIntermediate {  val exams = exams(Tens.PAST_PERFECT, Tens.FUTURE_PERFECT) }
    object Advanced {           val exams = exams(Tens.PRESENT_PERFECT_CONTINUOUS, Tens.PAST_PERFECT_CONTINUOUS) }
    object Proficient {         val exams = exams(Tens.FUTURE_PERFECT_CONTINUOUS) }

    fun exams(vararg tenses: Tens): List<Exam> {
        return playMusic(*tenses)
            .asSequence()
            .plus(playGame(*tenses))
            .plus(visitPlaces(*tenses))
            .plus(eat(*tenses))
            .plus(cook(*tenses))
            .plus(drink(*tenses))
            .plus(writeRead(*tenses))
            .plus(learn(*tenses))
            .toList()
    }

    private fun listOfExams(tenses: List<Tens> = Tens.entries, getExam: (tens: Tens) -> Exam): List<Exam> {
        val exams = mutableListOf<Exam>()

        for (tens in tenses) {
            exams.add(getExam.invoke(tens))
        }

        return exams
    }

//    Exams

    private val playMusic = listOfExams { tens -> playMusic(tens) }
    private fun playMusic(vararg tenses: Tens) = listOfExams(tenses.asList()) { tens -> playMusic(tens) }
    private fun playMusic(tens: Tens): Exam {
        return Exam(
            tens = tens,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
            verbs = listOf(Verbs.play),
            objects = Nouns.musicalInstruments.addArticle(Article.DEFINITE).build(),
        )
    }

    private val playGame = listOfExams { tens -> playGame(tens) }
    private fun playGame(vararg tenses: Tens) = listOfExams(tenses.asList()) { tens -> playGame(tens) }
    private fun playGame(tens: Tens): Exam {
        return Exam(
            tens = tens,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
            verbs = listOf(Verbs.play),
            objects = Nouns.games.build(),
        )
    }

    private val visitPlaces = listOfExams { tens -> visitPlaces(tens) }
    private fun visitPlaces(vararg tenses: Tens) = listOfExams(tenses.asList()) { tens -> visitPlaces(tens) }
    private fun visitPlaces(tens: Tens): Exam {
        return Exam(
            tens = tens,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
            verbs = listOf(Verbs.visit),
            objects = Nouns.places.addArticle(Article.DEFINITE).build(),
        )
    }

    private val eat = listOfExams { tens -> eat(tens) }
    private fun eat(vararg tenses: Tens) = listOfExams(tenses.asList()) { tens -> eat(tens) }
    private fun eat(tens: Tens): Exam {
        return Exam(
            tens = tens,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names).plus(Nouns.teacher.copy(article = Article.DEFINITE)),
            verbs = listOf(Verbs.eat),
            objects = Nouns.fruits.addArticle(Article.INDEFINITE).build(),
        )
    }

    private val cook = listOfExams { tens -> cook(tens) }
    private fun cook(vararg tenses: Tens) = listOfExams(tenses.asList()) { tens -> cook(tens) }
    private fun cook(tens: Tens): Exam {
        return Exam(
            tens = tens,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
            verbs = listOf(Verbs.cook),
            objects = Nouns.vegetablesForCook.addArticle(Article.INDEFINITE).build(),
        )
    }

    private val drink = listOfExams { tens -> drink(tens) }
    private fun drink(vararg tenses: Tens) = listOfExams(tenses.asList()) { tens -> drink(tens) }
    private fun drink(tens: Tens): Exam {
        return Exam(
            tens = tens,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
            verbs = listOf(Verbs.drink),
            objects = Nouns.drinks.addArticle(Article.INDEFINITE).build(),
        )
    }

    private val writeRead = listOfExams { tens -> writeRead(tens) }
    private fun writeRead(vararg tenses: Tens) = listOfExams(tenses.asList()) { tens -> writeRead(tens) }
    private fun writeRead(tens: Tens): Exam {
        return Exam(
            tens = tens,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
            verbs = listOf(Verbs.write, Verbs.read),
            objects = Nouns.writeReadMaterials.addArticle(Article.INDEFINITE).build(),
        )
    }

    private val learn = listOfExams { tens -> learn(tens) }
    private fun learn(vararg tenses: Tens) = listOfExams(tenses.asList()) { tens -> learn(tens) }
    private fun learn(tens: Tens): Exam {
        return Exam(
            tens = tens,
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