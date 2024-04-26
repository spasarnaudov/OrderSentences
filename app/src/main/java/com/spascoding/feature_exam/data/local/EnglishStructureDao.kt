package com.spascoding.feature_exam.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.spascoding.feature_exam.domain.model.sentence.entity.Sentence

@Dao
interface EnglishStructureDao {
    @Update
    suspend fun updateSentence(sentence: Sentence)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun importNotExistedSentences(sentences: List<Sentence>)

    @Query("SELECT DISTINCT examName FROM sentences WHERE tens=:examTens")
    suspend fun getExamNames(examTens: Int): List<String>

    @Query("SELECT * FROM sentences WHERE tens=:examTens AND examName=:examName ORDER BY useCount ASC, mistakeCount DESC LIMIT 1")
    suspend fun getSentence(examTens: Int, examName: String): Sentence

    @Query("SELECT * FROM sentences WHERE tens=:examTens AND examName=:examName ORDER BY useCount ASC, mistakeCount DESC")
    suspend fun getSentences(examTens: Int, examName: String): List<Sentence>
}