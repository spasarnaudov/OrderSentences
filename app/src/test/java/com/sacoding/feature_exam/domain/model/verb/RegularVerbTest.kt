package com.sacoding.feature_exam.domain.model.verb

import org.junit.Test

class RegularVerbTest {

    @Test
    fun testThreeForms() {
        testVerb(RegularVerb("talk"), "talk", "talked", "talked")
        testVerb(RegularVerb("like"), "like", "liked", "liked")
        testVerb(RegularVerb("cry"), "cry", "cried", "cried")
    }

    private fun testVerb(verb: Verb, baseForm: String, pastTense: String, pastParticiple: String) {
        println(verb.baseForm)
        println(verb.pastTense)
        println(verb.pastParticiple)
        assert(verb.baseForm == baseForm)
        assert(verb.pastTense == pastTense)
        assert(verb.pastParticiple == pastParticiple)
    }
}