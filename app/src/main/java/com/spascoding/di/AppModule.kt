package com.spascoding.di

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.spascoding.feature_exam.data.local.EnglishStructureDao
import com.spascoding.feature_exam.data.local.EnglishStructureDatabase
import com.spascoding.feature_exam.data.repository.ExamPatternRepositoryImpl
import com.spascoding.feature_exam.data.repository.SharedPreferencesRepositoryImpl
import com.spascoding.feature_exam.domain.repository.ExamPatternRepository
import com.spascoding.feature_exam.domain.repository.SharedPreferencesRepository
import com.spascoding.feature_exam.domain.use_case.ExamUseCases
import com.spascoding.feature_exam.domain.use_case.GetExamPatternsUseCase
import com.spascoding.feature_exam.domain.use_case.database.GetExamNamesUseCase
import com.spascoding.feature_exam.domain.use_case.database.GetSentenceUseCase
import com.spascoding.feature_exam.domain.use_case.database.GetSentencesUseCase
import com.spascoding.feature_exam.domain.use_case.database.ImportNotExistedSentencesUseCase
import com.spascoding.feature_exam.domain.use_case.database.UpdateSentenceUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideInitialDataRepository(): ExamPatternRepository {
        return ExamPatternRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideExamUseCases(
        getExamPatternsUseCase: GetExamPatternsUseCase,
        getExamNamesUseCase: GetExamNamesUseCase,
        getSentencesUseCase: GetSentencesUseCase,
        getSentenceUseCase: GetSentenceUseCase,
        updateSentenceUseCase: UpdateSentenceUseCase,
        upsertSentencesToDatabaseUseCase: ImportNotExistedSentencesUseCase,
    ): ExamUseCases {
        return ExamUseCases(
            getExamPatternsUseCase,
            getExamNamesUseCase,
            getSentencesUseCase,
            getSentenceUseCase,
            updateSentenceUseCase,
            upsertSentencesToDatabaseUseCase,
        )
    }

    @Provides
    @Singleton
    fun provideSharedPreferencesRepository(@ApplicationContext context: Context): SharedPreferencesRepository {
        return SharedPreferencesRepositoryImpl(context)
    }

    @Provides
    @Singleton
    fun provideEnglishStructureDatabase(@ApplicationContext context: Context): EnglishStructureDatabase {
        return databaseBuilder(
            context,
            EnglishStructureDatabase::class.java, "english-structure-db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideEnglishStructureDao(database: EnglishStructureDatabase): EnglishStructureDao {
        return database.dao
    }

}