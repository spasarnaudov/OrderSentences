package com.example.ordersentences.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "verbs")
data class Verb(
    val baseForm: String,
    val pastTense: String,
    val pastParticiple: String,
    val useCount: Int = 0,
    val mistakeCount: Int = 0,
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
)
