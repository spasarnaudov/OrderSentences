package com.spascoding.feature_exam.domain.model.sentence.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sentences")
data class Sentence(
    @PrimaryKey val value: String,
    val tens: Int,
    val examName: String,
    val useCount: Int = 0,
    val mistakeCount: Int = 0,
)