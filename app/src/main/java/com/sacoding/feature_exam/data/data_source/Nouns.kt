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

}