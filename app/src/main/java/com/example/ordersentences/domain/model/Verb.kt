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

fun Verb.getInfinitiveForSubject(subject: String): String {
    when(subject.lowercase()) {
        "i" -> return baseForm
        "you" -> return baseForm
        "we" -> return baseForm
        "they" -> return baseForm
    }
    return getInfinitiveThirdPerson()
}

private fun Verb.getInfinitiveThirdPerson(): String {
    val isSpecialCase =
        "go" == baseForm
                || "do" == baseForm
                || baseForm.endsWith("s", true)
    return if (isSpecialCase) "${baseForm}es" else "${baseForm}s"
}
