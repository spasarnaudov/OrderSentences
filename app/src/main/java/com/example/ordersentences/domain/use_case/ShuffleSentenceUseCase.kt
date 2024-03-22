package com.example.ordersentences.domain.use_case

import kotlin.random.Random

class ShuffleSentenceUseCase(
    private val separator: String = " "
) {

    operator fun invoke(sentence: String): String {
        val words = sentence.split(" ")
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

//    TEST
//    for (i in 1 until 1000000) {
//        val sentence = "Will John buy fish?"
//        val shuffledSentence = ShuffleSentenceUseCase().invoke(sentence)
//        if (sentence == shuffledSentence) {
//            println()
//            println(removeNonWordSymbols(sentence))
//            println(removeNonWordSymbols(shuffledSentence))
//        }
//    }

}
