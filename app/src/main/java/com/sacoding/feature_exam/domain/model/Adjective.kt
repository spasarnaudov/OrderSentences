package com.sacoding.feature_exam.domain.model

val BLANK_ADJECTIVE = Adjective()

data class Adjective(
    val possessiveDeterminer: String = "",  //my, your, his, her, its, our, their, John's, Emily's
    val qualityOpinion: String = "",        //delicious, beautiful, good
    val size: String = "",                  //tall, short, big
    val age: String = "",                   //old, young, new, 20-year-old
    val shape: String = "",                 //round, square
    val color: String = "",                 //red green, blue
    val origin: String = "",                //Korean, Mexican, American
    val material: String = "",              //glass, gold, wooden
    val purpose: String = "",               //sport, coffee
) {
    fun build(): String {
        return buildString {
            if (possessiveDeterminer.isNotBlank())  append(possessiveDeterminer).append(" ")
            if (qualityOpinion.isNotBlank())        append(qualityOpinion).append(" ")
            if (size.isNotBlank())                  append(size).append(" ")
            if (age.isNotBlank())                   append(age).append(" ")
            if (shape.isNotBlank())                 append(shape).append(" ")
            if (color.isNotBlank())                 append(color).append(" ")
            if (origin.isNotBlank())                append(origin).append(" ")
            if (material.isNotBlank())              append(material).append(" ")
            if (purpose.isNotBlank())               append(purpose)
        }.trim()
    }

    fun isNotBlank(): Boolean {
        return this != BLANK_ADJECTIVE
    }
}