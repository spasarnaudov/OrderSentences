package com.sacoding.feature_exam.data.data_source

import com.sacoding.feature_exam.domain.model.verb.Verb

object Verbs {

    val toBe = Verb("to be")

    //  Irregular verbs all three forms are the same

    val bet = Verb("bet")
    val burst = Verb("burst")
    val cast = Verb("cast")
    val cost = Verb("cost")
    val cut = Verb("cut")
    val hit = Verb("hit")
    val hurt = Verb("hurt")
    val let = Verb("let")
    val put = Verb("put")
    val quit = Verb("quit")
    val `set` = Verb("set")
    val shut = Verb("shut")
    val split = Verb("split")
    val spread = Verb("spread")

    //  Irregular verbs same past and past principle forms

    val bend = Verb("bend", "bent", "bent")
    val bleed = Verb("bleed", "bled", "bled")
    val `build` = Verb("build", "built", "built")
    val buy = Verb("buy", "bought", "bought")
    val `catch` = Verb("catch", "caught", "caught")
    val feed = Verb("feed", "fed", "fed")
    val feel = Verb("feel", "felt", "felt")
    val find = Verb("find", "found", "found")
    val `have` = Verb("have", "had", "had")
    val hold = Verb("hold", "held", "held")
    val `keep` = Verb("keep", "kept", "kept")
    val leave = Verb("leave", "left", "left")
    val lend = Verb("lend", "lent", "lent")
    val make = Verb("make", "made", "made")
    val meet = Verb("meet", "met", "met")
    val pay = Verb("pay", "paid", "paid")
    val read = Verb("read", "read", "read") //pronounced as "red"
    val say = Verb("say", "said", "said")
    val sell = Verb("sell", "sold", "sold")
    val send = Verb("send", "sent", "sent")
    val shoot = Verb("shoot", "shot", "shot")
    val sleep = Verb("sleep", "slept", "slept")
    val spend = Verb("spend", "spent", "spent")
    val stand = Verb("stand", "stood", "stood")
    val teach = Verb("teach", "taught", "taught")
    val tell = Verb("tell", "told", "told")
    val think = Verb("think", "thought", "thought")
    val understand = Verb("understand", "understood", "understood")
    val win = Verb("win", "won", "won")

    //  Irregular verbs same base and past principle forms

    val come = Verb("come", "came", "come")
    val run = Verb("run", "ran", "run")
    val become = Verb("become", "became", "become")
    val overcome = Verb("overcome", "overcame", "overcome")

    //  Irregular verbs all three forms are different

    val begin = Verb("begin", "began", "begun")
    val drink = Verb("drink", "drank", "drunk")
    val sing = Verb("sing", "sang", "sung")
    val swim = Verb("swim", "swam", "swum")
    val ring = Verb("ring", "rang", "rung")
    val go = Verb("go", "went", "gone")
    val ride = Verb("ride", "rode", "ridden")
    val write = Verb("write", "wrote", "written")
    val rise = Verb("rise", "rose", "risen")
    val drive = Verb("drive", "drove", "driven")
    val choose = Verb("choose", "chose", "chosen")
    val eat = Verb("eat", "ate", "eaten")
    val fall = Verb("fall", "fell", "fallen")
    val give = Verb("give", "gave", "given")
    val `see` = Verb("see", "saw", "seen")
    val `do` = Verb("do", "did", "done")
    val know = Verb("know", "knew", "known")
    val `throw` = Verb("throw", "threw", "thrown")
    val take = Verb("take", "took", "taken")

    //  Regular verbs

    val live = Verb("live")
    val love = Verb("love")
    val like = Verb("like")
    val hate = Verb("hate")
    val trust = Verb("trust")
    val cook = Verb("cook")
    val help = Verb("help")
    val respect = Verb("respect")
    val greet = Verb("greet")
    val learn = Verb("learn")
    val listen = Verb("listen")
    val support = Verb("support")
    val smile = Verb("smile")

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