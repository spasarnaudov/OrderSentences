package com.sacoding.feature_exam.domain.model

import com.sacoding.feature_exam.domain.Article
import com.sacoding.feature_exam.domain.NounAdapter
import com.sacoding.feature_exam.domain.model.noun.MultiSubjectPronoun
import com.sacoding.feature_exam.domain.model.noun.PluralPronoun
import com.sacoding.feature_exam.domain.model.noun.SingularNoun
import com.sacoding.feature_exam.domain.model.noun.SingularPronoun
import com.sacoding.feature_exam.domain.model.noun.SubjectPronoun
import org.junit.Test

class SubjectTest {

    @Test
    fun testAYoungBoy() {
        val boy = SingularNoun(
            article = Article.DEFINITE,
            adjective = Adjective("little"),
            value = "boy"
        )
        val i = SingularPronoun(SingularPronoun.Values.I)
        val they = PluralPronoun(PluralPronoun.Values.THEY)
        val john = SubjectPronoun("John")
        val multiSubjectPronoun = MultiSubjectPronoun(listOf(boy, john, they, i))
        val subject = NounAdapter(listOf(multiSubjectPronoun))
        println(subject.build())
    }
}