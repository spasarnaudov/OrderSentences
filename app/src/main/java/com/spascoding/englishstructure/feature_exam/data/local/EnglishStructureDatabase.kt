package com.spascoding.englishstructure.feature_exam.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.spascoding.englishstructure.feature_exam.domain.model.sentence.entity.Sentence

@Database(
    entities = [Sentence::class],
    version = 1,
)
abstract class EnglishStructureDatabase: RoomDatabase() {
    abstract val dao: EnglishStructureDao
}