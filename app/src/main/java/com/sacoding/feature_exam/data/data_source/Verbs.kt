package com.sacoding.feature_exam.data.data_source

import com.sacoding.feature_exam.domain.model.verb.IrregularVerb
import com.sacoding.feature_exam.domain.model.verb.RegularVerb
import com.sacoding.feature_exam.domain.model.verb.Verb

object Verbs {

    val toBe = IrregularVerb("to be", "", "")

    //  Irregular verbs all three forms are the same

    val bet = IrregularVerb("bet")
    val burst = IrregularVerb("burst")
    val cast = IrregularVerb("cast")
    val cost = IrregularVerb("cost")
    val cut = IrregularVerb("cut")
    val hit = IrregularVerb("hit")
    val hurt = IrregularVerb("hurt")
    val let = IrregularVerb("let")
    val put = IrregularVerb("put")
    val quit = IrregularVerb("quit")
    val `set` = IrregularVerb("set")
    val shut = IrregularVerb("shut")
    val split = IrregularVerb("split")
    val spread = IrregularVerb("spread")

    //  Irregular verbs same past and past principle forms

    val bend = IrregularVerb("bend", "bent", "bent")
    val bleed = IrregularVerb("bleed", "bled", "bled")
    val `build` = IrregularVerb("build", "built", "built")
    val buy = IrregularVerb("buy", "bought", "bought")
    val `catch` = IrregularVerb("catch", "caught", "caught")
    val feed = IrregularVerb("feed", "fed", "fed")
    val feel = IrregularVerb("feel", "felt", "felt")
    val find = IrregularVerb("find", "found", "found")
    val `have` = IrregularVerb("have", "had", "had")
    val hold = IrregularVerb("hold", "held", "held")
    val `keep` = IrregularVerb("keep", "kept", "kept")
    val leave = IrregularVerb("leave", "left", "left")
    val lend = IrregularVerb("lend", "lent", "lent")
    val make = IrregularVerb("make", "made", "made")
    val meet = IrregularVerb("meet", "met", "met")
    val pay = IrregularVerb("pay", "paid", "paid")
    val read = IrregularVerb("read", "read", "read") //pronounced as "red"
    val say = IrregularVerb("say", "said", "said")
    val sell = IrregularVerb("sell", "sold", "sold")
    val send = IrregularVerb("send", "sent", "sent")
    val shoot = IrregularVerb("shoot", "shot", "shot")
    val sleep = IrregularVerb("sleep", "slept", "slept")
    val spend = IrregularVerb("spend", "spent", "spent")
    val stand = IrregularVerb("stand", "stood", "stood")
    val teach = IrregularVerb("teach", "taught", "taught")
    val tell = IrregularVerb("tell", "told", "told")
    val think = IrregularVerb("think", "thought", "thought")
    val understand = IrregularVerb("understand", "understood", "understood")
    val win = IrregularVerb("win", "won", "won")

    //  Irregular verbs same base and past principle forms

    val come = IrregularVerb("come", "came", "come")
    val run = IrregularVerb("run", "ran", "run")
    val become = IrregularVerb("become", "became", "become")
    val overcome = IrregularVerb("overcome", "overcame", "overcome")

    //  Irregular verbs all three forms are different

    val begin = IrregularVerb("begin", "began", "begun")
    val drink = IrregularVerb("drink", "drank", "drunk")
    val sing = IrregularVerb("sing", "sang", "sung")
    val swim = IrregularVerb("swim", "swam", "swum")
    val ring = IrregularVerb("ring", "rang", "rung")
    val go = IrregularVerb("go", "went", "gone")
    val ride = IrregularVerb("ride", "rode", "ridden")
    val write = IrregularVerb("write", "wrote", "written")
    val rise = IrregularVerb("rise", "rose", "risen")
    val drive = IrregularVerb("drive", "drove", "driven")
    val choose = IrregularVerb("choose", "chose", "chosen")
    val eat = IrregularVerb("eat", "ate", "eaten")
    val fall = IrregularVerb("fall", "fell", "fallen")
    val give = IrregularVerb("give", "gave", "given")
    val `see` = IrregularVerb("see", "saw", "seen")
    val `do` = IrregularVerb("do", "did", "done")
    val know = IrregularVerb("know", "knew", "known")
    val `throw` = IrregularVerb("throw", "threw", "thrown")
    val take = IrregularVerb("take", "took", "taken")

    //  Regular verbs

    val live = RegularVerb("live")
    val love = RegularVerb("love")
    val like = RegularVerb("like")
    val hate = RegularVerb("hate")
    val trust = RegularVerb("trust")
    val cook = RegularVerb("cook")
    val help = RegularVerb("help")
    val respect = RegularVerb("respect")
    val greet = RegularVerb("greet")
    val learn = RegularVerb("learn")
    val listen = RegularVerb("listen")
    val support = RegularVerb("support")

    val countriesAndCities: List<Verb> = listOf(
        live,
    )

    val mutualOrReciprocalActions = listOf(
        help,
        understand,
        respect,
        trust,
        greet,
        learn,
        listen,
        support,
    )
}