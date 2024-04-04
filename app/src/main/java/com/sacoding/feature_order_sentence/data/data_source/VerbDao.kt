package com.sacoding.feature_order_sentence.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.sacoding.feature_order_sentence.domain.model.Verb

@Dao
interface VerbDao {

    @Upsert
    suspend fun upsertVerb(verb: Verb)

    @Insert
    suspend fun insertVerbs(vararg verbs: Verb)

    @Query("SELECT COUNT(*) FROM verbs")
    suspend fun countRows(): Int

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