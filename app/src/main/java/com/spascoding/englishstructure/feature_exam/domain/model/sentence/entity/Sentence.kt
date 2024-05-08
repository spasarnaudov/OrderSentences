package com.spascoding.englishstructure.feature_exam.domain.model.sentence.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sentences")
data class Sentence(
    @PrimaryKey val value: String,
    val tense: Int,
    val topic: String,
    val userValue: String = "",
    val userValueTime: Long = 0,
    val usedCount: Int = 0,
    val mistakeCount: Int = 0,
)