package com.example.ordersentences.domain.use_case

class GetInfinitiveVerb(private val subject: String, private val verb: String) {
    override fun toString(): String {
        if (verb.isBlank()) {
            return ""
        }
        when(subject.lowercase()) {
            "i" -> return verb
            "you" -> return verb
            "we" -> return verb
            "they" -> return verb
        }
        return getVerb()
    }

    private fun getVerb(): String {
        val isSpecialCase =
            "go" == verb
            || "do" == verb
            || verb.endsWith("s", true)
        return if (isSpecialCase) "${verb}es" else "${verb}s"
    }
}