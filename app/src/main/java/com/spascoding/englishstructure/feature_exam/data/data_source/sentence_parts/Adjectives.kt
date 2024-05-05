package com.spascoding.englishstructure.feature_exam.data.data_source.sentence_parts

import com.spascoding.englishstructure.feature_exam.domain.model.Adjective

object Adjectives {

    object Possessive {
        val MY = Adjective(possessiveDeterminer = "my")
        val YOUR = Adjective(possessiveDeterminer = "your")
        val HIS = Adjective(possessiveDeterminer = "his")
        val HER = Adjective(possessiveDeterminer = "her")
        val ITS = Adjective(possessiveDeterminer = "its")
        val OUR = Adjective(possessiveDeterminer = "our")
        val THEIR = Adjective(possessiveDeterminer = "their")

        val singular = listOf(
            MY,
            YOUR,
            HIS,
            HER,
            ITS,
        )

        val plural = listOf(
            OUR,
            YOUR,
            THEIR,
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