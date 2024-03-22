package com.example.ordersentences.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.ordersentences.domain.model.Verb
import com.example.ordersentences.domain.use_case.IncrementVerbMistakeCountUseCase
import com.example.ordersentences.domain.use_case.LoadVerbUseCase
import com.example.ordersentences.domain.use_case.UploadVerbsToDBUseCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import kotlin.random.Random

class OrderSentenceDatabaseTest {
    private lateinit var db: OrderSentenceDatabase
    private lateinit var dao: VerbDao

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, OrderSentenceDatabase::class.java).build()
        dao = db.dao
    }
    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun test() = runBlocking {
        UploadVerbsToDBUseCase(dao).invoke()

        for (i in 0 .. 50) {
            val verb = LoadVerbUseCase(dao).invoke()
            if (Random.nextBoolean()) {
                IncrementVerbMistakeCountUseCase(dao).invoke(verb)
            }
            printTable()
        }

        assert(true)
    }

    private fun printTable() {
        val verbs: List<Verb> = dao.getVerbs()
        println("useCount / mistakeCount / baseForm")
        for (verb in verbs) {
            println("${verb.useCount}\t/\t${verb.mistakeCount}\t/\t${verb.baseForm}")
        }
    }
}