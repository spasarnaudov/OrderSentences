package com.sacoding.feature_exam.domain.model.noun

import com.sacoding.feature_exam.domain.Article
import com.sacoding.feature_exam.domain.Plurality
import com.sacoding.feature_exam.domain.model.Adjective
import com.sacoding.feature_exam.domain.model.BLANK_ADJECTIVE
import com.sacoding.feature_exam.listVowels

data class CommonNoun(
    private val value: String,
    override val countable: Boolean,
    override val plurality: Plurality,
    private val irregular: Boolean = false,
    private val preposition: String = "",
    private val article: Article = Article.NONE,
    private val adjective: Adjective = BLANK_ADJECTIVE,
): Noun(
    countable = countable,
    plurality = plurality,
) {

    override fun build(): String {
        return buildString {
            if (preposition.isNotBlank()) {
                append(preposition).append(" ")
            }
            if (article != Article.NONE) {
                val articleVal = getArticle(article)
                if (articleVal.isNotBlank()) {
                    append(articleVal).append(" ")
                }
            }
            if (adjective.isNotBlank()) {
                append(adjective.build()).append(" ")
            }
            append(value)
        }
    }

    private fun getArticle(article: Article): String {
        return if (article == Article.DEFINITE) {
            "the"
        } else if (countable) {
            if (plurality == Plurality.SINGULAR) {
                if (startsWithVowel()) {
                    "an"
                } else {
                    "a"
                }
            } else {
                ""
            }
        } else {
            ""
        }
    }

    private fun startsWithVowel(): Boolean {
        return listVowels.contains(value.lowercase()[0].toString())
    }

    fun plural(): CommonNoun {
        if (plurality == Plurality.PLURAL) {
            return this
        }

        if (irregular) {
            return this
        }

        if (value.endsWith("ch")
            || value.endsWith("sh")
            || value.endsWith("s")
            || value.endsWith("ss")
            || value.endsWith("x")
            || value.endsWith("z")
        ) {
            return copy(
                value = "${value}es",
                plurality = Plurality.PLURAL
            )
        }

        if (value.endsWith("f")) {
            return this.copy(
                value = "${value.substring(0, value.length-1)}ves",
                plurality = Plurality.PLURAL
            )
        }

        if (value.endsWith("fe")) {
            return this.copy(
                value = "${value.substring(0, value.length-2)}ves",
                plurality = Plurality.PLURAL
            )
        }

        if (value.endsWith("o")) {
            val penultimate = value.lowercase()[value.length-2]
            return if (listVowels.contains(penultimate.toString())) {
                copy(
                    value = "${value}s",
                    plurality = Plurality.PLURAL
                )
            } else {
                copy(
                    value = "${value}es",
                    plurality = Plurality.PLURAL
                )
            }
        }

        if (value.endsWith("y")) {
            val penultimate = value.lowercase()[value.length-2]
            return if (listVowels.contains(penultimate.toString())) {
                copy(
                    value = "${value}s",
                    plurality = Plurality.PLURAL
                )
            } else {
                copy(
                    value = "${value.substring(0, value.length-1)}ies",
                    plurality = Plurality.PLURAL
                )
            }
        }

        return copy(
            value = "${value}s",
            plurality = Plurality.PLURAL
        )
    }
}

fun List<CommonNoun>.addArticle(article: Article): List<CommonNoun> {
    val list = mutableListOf<CommonNoun>()
    for (item in this) {
        list.add(item.copy(article = article))
    }
    return list
}

fun List<CommonNoun>.addPossessiveAdjective(adjectives: List<Adjective>): List<CommonNoun> {
    val list = mutableListOf<CommonNoun>()
    for (item in this) {
        for (adjective in adjectives) {
            list.add(item.copy(adjective = adjective))
        }
    }
    return list
}

fun List<CommonNoun>.plural(): List<CommonNoun> {
    val list = mutableListOf<CommonNoun>()
    for (item in this) {
        list.add(item.plural())
    }
    return list
}
