package com.example.ordersentences.domain.model

interface Sentence {
    fun positive(): String
    fun negative(): String
    fun question(): String
}