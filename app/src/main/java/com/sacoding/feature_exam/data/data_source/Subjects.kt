package com.sacoding.feature_exam.data.data_source

import com.sacoding.feature_exam.domain.model.Adjective
import com.sacoding.feature_exam.domain.model.SingularNoun
import com.sacoding.feature_exam.domain.model.Subject
import com.sacoding.feature_exam.domain.model.build

object Subjects {

    val robin = SingularNoun("Robin")
    val eagle = SingularNoun("Eagle")

    val birds = listOf(
        Subject(
            article = robin.getArticle(),
            adjective = "little",
            noun = robin.value
        ).build(),
        Subject(
            article = eagle.getArticle(),
            adjective = Adjective(
                age =  "old"
            ).build(),
            noun = eagle.value
        ).build(),
    )
}