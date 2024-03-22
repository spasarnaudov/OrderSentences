package com.example.ordersentences.domain.use_case

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle

class ScratchWordsUseCase {

    operator fun invoke(sourceWords: String, targetText: String): AnnotatedString {

        val wordsToScratch = sourceWords.split(" ")
        val targetWords = targetText.split(" ")

        return buildAnnotatedString {

            targetWords.map { word ->
                if (wordsToScratch.contains(word)) {
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                        append(word)
                    }
                } else {
                    append(word.replace("/", " / "))
                }
            }
        }
    }

}