package com.example.ordersentences.domain

fun String.upperFirstLetter(): String {
    return this[0].uppercase().plus(subSequence(1, length))
}

fun String.removeNonWordSymbols(): String {
    return replace(Regex("\\W+"), " ").trim()
}