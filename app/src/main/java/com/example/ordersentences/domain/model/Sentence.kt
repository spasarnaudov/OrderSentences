package com.example.ordersentences.domain.model

interface Sentence {
    fun buildSentence(): String
}

object Verbs {
    val verbDo = Verb("do", "did", "done")
}