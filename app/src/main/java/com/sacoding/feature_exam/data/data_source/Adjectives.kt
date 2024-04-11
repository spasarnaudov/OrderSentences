package com.sacoding.feature_exam.data.data_source

import com.sacoding.feature_exam.domain.model.Adjective

object Adjectives {

    object Possessive {
        val singular = listOf(
            Adjective(possessiveDeterminer = "my"),
            Adjective(possessiveDeterminer = "your"),
            Adjective(possessiveDeterminer = "his"),
            Adjective(possessiveDeterminer = "her"),
            Adjective(possessiveDeterminer = "its"),
        )

        val plural = listOf(
            Adjective(possessiveDeterminer = "our"),
            Adjective(possessiveDeterminer = "your"),
            Adjective(possessiveDeterminer = "their"),
        )

        val name = listOf(
            Adjective(possessiveDeterminer = "John's"),
            Adjective(possessiveDeterminer = "Emily's"),
        )
    }

    val size = listOf(
        "small",
        "medium",
        "large",
        "tiny",
        "huge",
    )
    val taste = listOf(
        "delicious",
        "tasteful",
        "edible",
        "flavorful",
        "yummy",
        "scrumptious",
        "delectable",
        "appetizing",
        "good",
    )
}