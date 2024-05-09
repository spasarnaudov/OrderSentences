package com.spascoding.englishstructure.feature_exam.data.data_source

import com.spascoding.englishstructure.feature_exam.data.data_source.sentence_parts.Adjectives
import com.spascoding.englishstructure.feature_exam.data.data_source.sentence_parts.Nouns
import com.spascoding.englishstructure.feature_exam.data.data_source.sentence_parts.Pronouns
import com.spascoding.englishstructure.feature_exam.data.data_source.sentence_parts.Verbs
import com.spascoding.englishstructure.feature_exam.domain.enums.Article
import com.spascoding.englishstructure.feature_exam.domain.enums.Tense
import com.spascoding.englishstructure.feature_exam.domain.model.ExamPattern
import com.spascoding.englishstructure.feature_exam.domain.model.Preposition
import com.spascoding.englishstructure.feature_exam.domain.model.noun.addAdjective
import com.spascoding.englishstructure.feature_exam.domain.model.noun.addArticle
import com.spascoding.englishstructure.feature_exam.domain.model.noun.addPreposition
import com.spascoding.englishstructure.feature_exam.domain.model.noun.build
import com.spascoding.englishstructure.feature_exam.domain.model.noun.plural

object StudentBook {
    private const val HELLO = "hello"
    private const val ENTERTAINMENT = "entertainment"
    private const val TRAVEL = "travel"
    private const val KITCHEN = "kitchen"
    private const val RESTAURANT = "restaurant"
    private const val SCHOOL = "school"

    fun examPatterns(): List<ExamPattern> {
        return hello()
            .asSequence()
            .plus(entertainment())
            .plus(travel())
            .plus(kitchen())
            .plus(restaurant())
            .plus(school())
            .toList()
    }

    //Hello

    private fun hello(): List<ExamPattern> {
        return myNameIs(HELLO)
            .asSequence()
            .plus(iAmFrom(HELLO))
            .plus(myJob(HELLO))
            .toList()
    }

    private fun myNameIs(name: String): List<ExamPattern> {
        return listOf(
            ExamPattern(
                name = name,
                tenses = listOf(Tense.PRESENT_SIMPLE),
                subjects = listOf(Nouns.name).addAdjective(listOf(Adjectives.Possessive.MY, Adjectives.Possessive.YOUR)),
                verbs = listOf(Verbs.toBe),
                objects = Nouns.names.build(),
            ),
            ExamPattern(
                name = name,
                tenses = listOf(Tense.PRESENT_SIMPLE),
                subjects = listOf(Nouns.name).addAdjective(listOf(Adjectives.Possessive.HIS)),
                verbs = listOf(Verbs.toBe),
                objects = Nouns.manNames.build(),
            ),
            ExamPattern(
                name = name,
                tenses = listOf(Tense.PRESENT_SIMPLE),
                subjects = listOf(Nouns.name).addAdjective(listOf(Adjectives.Possessive.HER)),
                verbs = listOf(Verbs.toBe),
                objects = Nouns.womanNames.build(),
            ),
        )
    }

    private fun iAmFrom(name: String): List<ExamPattern> {
        return listOf(
            ExamPattern(
                name = name,
                tenses = listOf(Tense.PRESENT_SIMPLE),
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
                verbs = listOf(Verbs.toBe),
                objects = listOf(
                    Nouns.australia,
                    Nouns.canada,
                    Nouns.france,
                    Nouns.italy,
                    Nouns.japan,
                ).addPreposition(Preposition.FROM).build(),
            ),
        )
    }

    private fun myJob(name: String): List<ExamPattern> {
        val jobs = listOf(
            Nouns.doctor,
            Nouns.teacher,
            Nouns.musician,
            Nouns.actor,
        )
        return listOf(
            ExamPattern(
                name = name,
                tenses = listOf(Tense.PRESENT_SIMPLE),
                subjects = Pronouns.singular.plus(Nouns.names),
                verbs = listOf(Verbs.toBe),
                objects = jobs.addArticle(Article.INDEFINITE).build(),
            ),
            ExamPattern(
                name = name,
                tenses = listOf(Tense.PRESENT_SIMPLE),
                subjects = Pronouns.plural,
                verbs = listOf(Verbs.toBe),
                objects = jobs.plural().addArticle(Article.INDEFINITE).build(),
            ),
        )
    }

    //Entertainment

    private fun entertainment(): List<ExamPattern> {
        return music(ENTERTAINMENT)
            .asSequence()
            .plus(movie(ENTERTAINMENT))
            .plus(game(ENTERTAINMENT))
            .toList()
    }

    private fun music(name: String): List<ExamPattern> {
        val musicalInstruments = listOf(
            Nouns.drum.plural(),
            Nouns.guitar,
            Nouns.piano,
        )
        return listOf(
            //Play music
            ExamPattern(
                name = name,
                tenses = listOf(Tense.PRESENT_SIMPLE),
                subjects = Pronouns.singular.plus(Nouns.names),
                verbs = listOf(Verbs.play),
                objects = musicalInstruments.addArticle(Article.DEFINITE).build(),
            ),
            //Sing a song
            ExamPattern(
                name = name,
                tenses = listOf(Tense.PRESENT_SIMPLE),
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
                verbs = listOf(Verbs.sing),
                objects = listOf(Nouns.song).addArticle(Article.INDEFINITE).build(),
            ),
        )
    }

    private fun movie(name: String): List<ExamPattern> {
        return listOf(
            //Watch movie
            ExamPattern(
                name = name,
                tenses = listOf(Tense.PRESENT_SIMPLE),
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
                verbs = listOf(Verbs.watch),
                objects = listOf(Nouns.movie).addArticle(Article.INDEFINITE).build(),
            ),
        )
    }

    private fun game(name: String): List<ExamPattern> {
        val sports = listOf(
            Nouns.basketball,
            Nouns.football,
            Nouns.soccer,
            Nouns.tennis,
            Nouns.volleyball,
        )
        return listOf(
            ExamPattern(
                name = name,
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
                verbs = listOf(Verbs.play),
                objects = sports.build(),
            ),
        )
    }

    //Travel

    private fun travel(): List<ExamPattern> {
        return visit(TRAVEL)
            .asSequence()
            .plus(waitingTransport(TRAVEL))
            .toList()
    }

    private fun visit(name: String): List<ExamPattern> {
        val placesTravel = listOf(
            Nouns.gallery,
            Nouns.castle,
            Nouns.museum,
        )
        return listOf(
            ExamPattern(
                name = name,
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
                verbs = listOf(Verbs.visit),
                objects = placesTravel.addArticle(Article.INDEFINITE).build(),
            ),
        )
    }

    private fun waitingTransport(name: String): List<ExamPattern> {
        val transport = listOf(
            Nouns.bus,
            Nouns.taxi,
            Nouns.train,
        )
        return listOf(
            ExamPattern(
                name = name,
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
                verbs = listOf(Verbs.wait),
                objects = transport.addArticle(Article.INDEFINITE).addPreposition(Preposition.FOR).build(),
            )
        )
    }

    //Kitchen

    private fun kitchen(): List<ExamPattern> {
        return cook(KITCHEN)
            .asSequence()
            .plus(wash(KITCHEN))
            .toList()
    }

    private fun cook(name: String): List<ExamPattern> {
        val food = listOf(
            Nouns.pizza,
            Nouns.chicken,
            Nouns.fish,
        )
        return listOf(
            ExamPattern(
                name = name,
                subjects = Pronouns.singular.plus(Nouns.names),
                verbs = listOf(Verbs.cook),
                objects = food.addArticle(Article.INDEFINITE).build(),
            ),
        )
    }

    private fun wash(name: String): List<ExamPattern> {
        return listOf(
            ExamPattern(
                name = name,
                subjects = Pronouns.singular.plus(Nouns.names),
                verbs = listOf(Verbs.wash),
                objects = listOf(Nouns.dishes).addArticle(Article.DEFINITE).build(),
            ),
        )
    }

    //Restaurant

    private fun restaurant(): List<ExamPattern> {
        return eat(RESTAURANT)
            .asSequence()
            .plus(drink(RESTAURANT))
            .toList()
    }

    private fun eat(name: String): List<ExamPattern> {
        val food = listOf(
            Nouns.pizza,
            Nouns.chicken,
            Nouns.fish,
        )
        return listOf(
            ExamPattern(
                name = name,
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
                verbs = listOf(Verbs.eat),
                objects = food.addArticle(Article.INDEFINITE).build(),
            ),
        )
    }

    private fun drink(name: String): List<ExamPattern> {
        val drinks = listOf(
            Nouns.beer,
            Nouns.water,
            Nouns.wine,
        )
        return listOf(
            ExamPattern(
                name = name,
                subjects = Pronouns.singular.plus(Pronouns.plural).plus(Nouns.names),
                verbs = listOf(Verbs.drink),
                objects = drinks.addArticle(Article.INDEFINITE).build(),
            ),
        )
    }

    //School

    private fun school(): List<ExamPattern> {
        return study(SCHOOL)
            .asSequence()
            .plus(paint(SCHOOL))
            .toList()
    }

    private fun study(name: String): List<ExamPattern> {
        val schoolSubjects = listOf(
            Nouns.history,
            Nouns.music,
            Nouns.science,
        )
        return listOf(
            ExamPattern(
                name = name,
                subjects = Pronouns.singular.plus(Nouns.names),
                verbs = listOf(Verbs.study),
                objects = schoolSubjects.addArticle(Article.INDEFINITE).build(),
            ),
        )
    }

    private fun paint(name: String): List<ExamPattern> {
        return listOf(
            ExamPattern(
                name = name,
                subjects = Pronouns.singular.plus(Nouns.names),
                verbs = listOf(Verbs.paint),
                objects = listOf(Nouns.picture).addArticle(Article.INDEFINITE).build(),
            )
        )
    }
}