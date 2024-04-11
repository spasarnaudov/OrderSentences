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

}