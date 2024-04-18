package com.spascoding.feature_exam.data.data_source

import com.spascoding.feature_exam.domain.Article
import com.spascoding.feature_exam.domain.Tens
import com.spascoding.feature_exam.domain.model.Exam
import com.spascoding.feature_exam.domain.model.Preposition
import com.spascoding.feature_exam.domain.model.noun.addArticle
import com.spascoding.feature_exam.domain.model.noun.addPreposition
import com.spascoding.feature_exam.domain.model.noun.build

object StudentBook {
    object Beginner {
        val exams = learn
//                .asSequence()
//                .plus(playMusic)
//                .plus(playGame)
//                .plus(visitPlaces)
//                .plus(eat)
//                .plus(cook)
//                .plus(drink)
//                .plus(writeRead)
//                .plus(learn)
//                .toList()
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
    private fun playMusic(tens: Tens): Exam {
        return Exam(
            tens = tens,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
            verbs = listOf(Verbs.play),
            objects = Nouns.musicalInstruments.addArticle(Article.DEFINITE).build(),
        )
    }

    private val playGame = listOfExams { tens -> playGame(tens) }
    private fun playGame(tens: Tens): Exam {
        return Exam(
            tens = tens,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
            verbs = listOf(Verbs.play),
            objects = Nouns.games.build(),
        )
    }

    private val visitPlaces = listOfExams { tens -> visitPlaces(tens) }
    private fun visitPlaces(tens: Tens): Exam {
        return Exam(
            tens = tens,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
            verbs = listOf(Verbs.visit),
            objects = Nouns.places.addArticle(Article.DEFINITE).build(),
        )
    }

    private val eat = listOfExams { tens -> eat(tens) }
    private fun eat(tens: Tens): Exam {
        return Exam(
            tens = tens,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names).plus(Nouns.teacher.copy(article = Article.DEFINITE)),
            verbs = listOf(Verbs.eat),
            objects = Nouns.fruits.addArticle(Article.INDEFINITE).build(),
        )
    }

    private val cook = listOfExams { tens -> cook(tens) }
    private fun cook(tens: Tens): Exam {
        return Exam(
            tens = tens,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
            verbs = listOf(Verbs.cook),
            objects = Nouns.vegetablesForCook.addArticle(Article.INDEFINITE).build(),
        )
    }

    private val drink = listOfExams { tens -> drink(tens) }
    private fun drink(tens: Tens): Exam {
        return Exam(
            tens = tens,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
            verbs = listOf(Verbs.drink),
            objects = Nouns.drinks.addArticle(Article.INDEFINITE).build(),
        )
    }

    private val writeRead = listOfExams { tens -> writeRead(tens) }
    private fun writeRead(tens: Tens): Exam {
        return Exam(
            tens = tens,
            subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
            verbs = listOf(Verbs.write, Verbs.read),
            objects = Nouns.writeReadMaterials.addArticle(Article.INDEFINITE).build(),
        )
    }

    private val learn = listOfExams { tens -> learn(tens) }
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