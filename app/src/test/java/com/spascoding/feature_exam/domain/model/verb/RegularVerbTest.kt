package com.spascoding.feature_exam.domain.model.verb

import org.junit.Test

class RegularVerbTest {

    @Test
    fun threeForms() {
        threeFormVerbAssert(Verb("talk"), "talk", "talked", "talked")
        threeFormVerbAssert(Verb("like"), "like", "liked", "liked")
        threeFormVerbAssert(Verb("cry"), "cry", "cried", "cried")
    }

    private fun threeFormVerbAssert(verb: Verb, baseForm: String, pastTense: String, pastParticiple: String) {
        println(verb.baseForm)
        println(verb.pastTense)
        println(verb.pastParticiple)
        assert(verb.baseForm == baseForm)
        assert(verb.pastTense == pastTense)
        assert(verb.pastParticiple == pastParticiple)
    }

    @Test
    fun thirdPerson() {
        thirdPerson(Verb("start"), "starts")
        thirdPerson(Verb("stand"), "stands")
        thirdPerson(Verb("work"), "works")
        thirdPerson(Verb("read"), "reads")

        thirdPerson(Verb("catch"), "catches")
        thirdPerson(Verb("smash"), "smashes")
        thirdPerson(Verb("pass"), "passes")
        thirdPerson(Verb("fix"), "fixes")
        thirdPerson(Verb("buzz"), "buzzes")

        thirdPerson(Verb("study"), "studies")
        thirdPerson(Verb("hurry"), "hurries")
        thirdPerson(Verb("carry"), "carries")

        thirdPerson(Verb("stay"), "stays")
        thirdPerson(Verb("enjoy"), "enjoys")
        thirdPerson(Verb("decay"), "decays")

        thirdPerson(Verb("go"), "goes")
        thirdPerson(Verb("do"), "does")
        thirdPerson(Verb("echo"), "echoes")
    }

    private fun thirdPerson(verb: Verb, thirdPersonPattern: String) {
        val thirdPerson = verb.thirdPerson()
        println(thirdPerson)
        assert(thirdPerson == thirdPersonPattern)
    }
}