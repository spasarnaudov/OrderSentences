package com.spascoding.englishstructure.feature_exam.presentation.utils

import android.content.Context
import android.content.pm.PackageManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import kotlin.random.Random

fun String.upperFirstLetter(): String {
    return this[0].uppercase().plus(subSequence(1, length))
}

fun String.removeNonWordSymbols(): String {
    return replace(Regex("\\W+"), " ").trim()
}

fun String.shuffleSentence(
    separator: String = " "
): String {
    val words = separateMarks().split(" ")
    return words.sattoloShuffle().joinToString(separator = separator)
}

private fun <T> Iterable<T>.sattoloShuffle(): List<T> {
    val list = this.toMutableList()
    for (i in list.size - 1 downTo 1) {
        val j = Random.nextInt(i)
        val temp = list[i]
        list[i] = list[j]
        list[j] = temp
    }
    return list.toList() // Convert back to an immutable list
}

fun String.separateMarks(): String {
    // This regex looks for a question mark that follows a word character (letter or digit)
    // and replaces it with a space followed by the question mark.
    return replace(Regex("(\\w)([?,.])"), "$1 $2")
}

fun scratchWords(
    textToScratch: String,
    shuffledSentence: String
): AnnotatedString {
    val wordsToScratch = textToScratch.separateMarks().split(" ")
    val allWords = shuffledSentence.separateMarks().split(" ")

    return buildAnnotatedString {

        allWords.map { word ->
            if (wordsToScratch.contains(word)) {
                withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough, color = Color.Gray)) {
                    append(word)
                }
            } else {
                append(word.replace("/", " / "))
            }
        }
    }
}