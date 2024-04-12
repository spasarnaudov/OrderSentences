package com.sacoding.feature_exam.domain.model.verb

import org.junit.Test

class RegularVerbTest {

    @Test
    fun threeForms() {
        threeFormVerbAssert(RegularVerb("talk"), "talk", "talked", "talked")
        threeFormVerbAssert(RegularVerb("like"), "like", "liked", "liked")
        threeFormVerbAssert(RegularVerb("cry"), "cry", "cried", "cried")
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
        thirdPerson(RegularVerb("start"), "starts")
        thirdPerson(RegularVerb("stand"), "stands")
        thirdPerson(RegularVerb("work"), "works")
        thirdPerson(RegularVerb("read"), "reads")

        thirdPerson(RegularVerb("catch"), "catches")
        thirdPerson(RegularVerb("smash"), "smashes")
        thirdPerson(RegularVerb("pass"), "passes")
        thirdPerson(RegularVerb("fix"), "fixes")
        thirdPerson(RegularVerb("buzz"), "buzzes")

        thirdPerson(RegularVerb("study"), "studies")
        thirdPerson(RegularVerb("hurry"), "hurries")
        thirdPerson(RegularVerb("carry"), "carries")

        thirdPerson(RegularVerb("stay"), "stays")
        thirdPerson(RegularVerb("enjoy"), "enjoys")
        thirdPerson(RegularVerb("decay"), "decays")

        thirdPerson(RegularVerb("go"), "goes")
        thirdPerson(RegularVerb("do"), "does")
        thirdPerson(RegularVerb("echo"), "echoes")
    }

    private fun thirdPerson(verb: Verb, thirdPersonPattern: String) {
        val thirdPerson = verb.thirdPerson()
        println(thirdPerson)
        assert(thirdPerson == thirdPersonPattern)
    }
}