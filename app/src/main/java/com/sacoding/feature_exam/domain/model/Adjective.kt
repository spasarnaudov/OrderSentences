package com.sacoding.feature_exam.domain.model

data class Adjective(
    val qualityOpinion: String = "",    //delicious, beautiful, good
    val size: String = "",              //tall, short, big
    val age: String = "",               //old, young, new, 20-year-old
    val shape: String = "",             //round, square
    val color: String = "",             //red green, blue
    val origin: String = "",            //Korean, Mexican, American
    val material: String = "",          //glass, gold, wooden
    val purpose: String = "",           //sport, coffee
)

fun Adjective.build(): String {
    return buildString {
        if (qualityOpinion.isNotBlank())    append(qualityOpinion).append(" ")
        if (size.isNotBlank())              append(size).append(" ")
        if (age.isNotBlank())               append(age).append(" ")
        if (shape.isNotBlank())             append(shape).append(" ")
        if (color.isNotBlank())             append(color).append(" ")
        if (origin.isNotBlank())            append(origin).append(" ")
        if (material.isNotBlank())          append(material).append(" ")
        if (purpose.isNotBlank())           append(purpose).append(" ")
    }.trim()
}