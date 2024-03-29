package com.example.ordersentences.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.ordersentences.data.data_source.OrderSentenceDatabase
import com.example.ordersentences.data.data_source.VerbDao
import org.junit.After
import org.junit.Before

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

//    @Test
//    fun test() = runBlocking {
//        UploadVerbsToDBUseCase(dao).invoke()
//
//        for (i in 0 .. 50) {
//            val verb = LoadVerbUseCase(dao).invoke()
//            if (Random.nextBoolean()) {
//                IncrementVerbMistakeCountUseCase(dao).invoke(verb)
//            }
//            printTable()
//        }
//
//        assert(true)
//    }
//
//    private fun printTable() {
//        val verbs: List<Verb> = dao.getVerbs()
//        println("useCount / mistakeCount / baseForm")
//        for (verb in verbs) {
//            println("${verb.useCount}\t/\t${verb.mistakeCount}\t/\t${verb.baseForm}")
//        }
//    }
}