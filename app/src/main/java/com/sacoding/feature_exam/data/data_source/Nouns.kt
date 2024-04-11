package com.sacoding.feature_exam.data.data_source

import com.sacoding.feature_exam.domain.Article
import com.sacoding.feature_exam.domain.model.Adjective
import com.sacoding.feature_exam.domain.model.SingularNoun

object Nouns {

    val singular = listOf(
        SingularNoun(
            article = Article.DEFINITE,
            adjective = Adjective(size = "little"),
            value = "boy"
        )
    )

    val countries = listOf(
        SingularNoun(value = "Australia"),
        SingularNoun(value = "Brazil"),
        SingularNoun(value = "Canada"),
        SingularNoun(value = "China"),
        SingularNoun(value = "France"),
        SingularNoun(value = "Germany"),
        SingularNoun(value = "India"),
        SingularNoun(value = "Indonesia"),
        SingularNoun(value = "Italy"),
        SingularNoun(value = "Japan"),
        SingularNoun(value = "Mexico"),
        SingularNoun(value = "Netherlands"),
        SingularNoun(value = "Russia"),
        SingularNoun(value = "Saudi Arabia"),
        SingularNoun(value = "South Korea"),
        SingularNoun(value = "Spain"),
        SingularNoun(value = "Sweden"),
        SingularNoun(value = "Switzerland"),
        SingularNoun(value = "Turkey"),
        SingularNoun(value = "The United Kingdom"),
        SingularNoun(value = "The United States")
    )

    val cities = listOf(
        SingularNoun(value = "Amsterdam"),
        SingularNoun(value = "Bangkok"),
        SingularNoun(value = "Cairo"),
        SingularNoun(value = "Dublin"),
        SingularNoun(value = "Edinburgh"),
        SingularNoun(value = "Florence"),
        SingularNoun(value = "Geneva"),
        SingularNoun(value = "Hong Kong"),
        SingularNoun(value = "Istanbul"),
        SingularNoun(value =  "Jakarta"),
        SingularNoun(value = "Kyoto"),
        SingularNoun(value = "London"),
        SingularNoun(value = "Moscow"),
        SingularNoun(value = "New York"),
        SingularNoun(value = "Oslo"),
        SingularNoun(value = "Paris"),
        SingularNoun(value = "Quebec City"),
        SingularNoun(value = "Rome"),
        SingularNoun(value = "Sydney"),
        SingularNoun(value = "Tokyo"),
        SingularNoun(value = "Utrecht"),
        SingularNoun(value = "Vienna"),
        SingularNoun(value = "Warsaw"),
        SingularNoun(value = "Xian"),
        SingularNoun(value = "York"),
        SingularNoun(value = "Zurich")
    )

    val nationals = listOf(
        SingularNoun(value = "Australian"),
        SingularNoun(value = "Brazilian"),
        SingularNoun(value = "Canadian"),
        SingularNoun(value = "Chinese"),
        SingularNoun(value = "French"),
        SingularNoun(value = "German"),
        SingularNoun(value = "Indian"),
        SingularNoun(value = "Indonesian"),
        SingularNoun(value = "Italian"),
        SingularNoun(value = "Japanese"),
        SingularNoun(value = "Mexican"),
        SingularNoun(value = "Dutch"),
        SingularNoun(value = "Russian"),
        SingularNoun(value = "Saudi Arabian"),
        SingularNoun(value = "South Korean"),
        SingularNoun(value = "Spanish"),
        SingularNoun(value = "Swedish"),
        SingularNoun(value = "Swiss"),
        SingularNoun(value = "Turkish"),
        SingularNoun(value = "British"),
        SingularNoun(value = "American")
    )

    val jobs = listOf(
        SingularNoun(value = "doctor"),
        SingularNoun(value = "nurse"),
        SingularNoun(value = "dentist"),
        SingularNoun(value = "software developer"),
        SingularNoun(value = "designer"),
        SingularNoun(value = "teacher"),
        SingularNoun(value = "professor"),
        SingularNoun(value = "mechanic"),
        SingularNoun(value = "electrician"),
        SingularNoun(value = "accountant"),
        SingularNoun(value = "musician"),
        SingularNoun(value = "actor"),
        SingularNoun(value = "chef"),
        SingularNoun(value = "lawyer"),
        SingularNoun(value = "biologist"),
    )

    val thinks = listOf(
        SingularNoun(value = "book"),
        SingularNoun(value = "laptop"),
        SingularNoun(value = "phone"),
        SingularNoun(value = "car"),
        SingularNoun(value = "house"),
        SingularNoun(value = "key"),
        SingularNoun(value = "desk"),
        SingularNoun(value = "pen"),
    )

}