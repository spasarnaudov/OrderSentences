package com.example.ordersentences.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.example.ordersentences.domain.model.Verb

@Dao
interface VerbDao {

    @Upsert
    suspend fun upsertVerb(verb: Verb)

    @Insert
    suspend fun insertVerbAll(vararg verbs: Verb)

    @Delete
    suspend fun deleteVerb(verb: Verb)

    @Query("SELECT COUNT(*) FROM verbs")
    suspend fun countRows(): Int

    @Query("SELECT * FROM verbs WHERE mistakeCount = 0 ORDER BY useCount ASC LIMIT 1")
    fun getNeverMistakeVerb(): Verb?

    @Query("SELECT * FROM verbs WHERE mistakeCount > 0 AND useCount > mistakeCount ORDER BY mistakeCount DESC LIMIT 1")
    fun getSometimesMistakeVerb(): Verb?

    @Query("SELECT * FROM verbs WHERE mistakeCount > 0 AND useCount = mistakeCount ORDER BY mistakeCount DESC LIMIT 1")
    fun getAlwaysMistakeVerb(): Verb?

    @Query("SELECT * FROM verbs ORDER BY useCount ASC, mistakeCount DESC LIMIT 1")
    fun getVerb(): Verb

    @Query("SELECT * FROM verbs ORDER BY useCount ASC, mistakeCount DESC ")
    suspend fun getVerbs(): List<Verb>

    @Transaction
    suspend fun getVerbAndIncrementUsageCount(): Verb {
        val verb = getVerb()
        val verbWithIncrementedUseCount = verb.copy(
            useCount = verb.useCount + 1
        )
        upsertVerb(verbWithIncrementedUseCount)
        return verbWithIncrementedUseCount
    }

}