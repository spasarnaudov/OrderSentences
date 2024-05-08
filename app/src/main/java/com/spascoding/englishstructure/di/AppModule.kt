package com.spascoding.englishstructure.di

import android.content.Context
import android.widget.Toast
import androidx.room.Room.databaseBuilder
import com.spascoding.englishstructure.feature_exam.data.local.EnglishStructureDao
import com.spascoding.englishstructure.feature_exam.data.local.EnglishStructureDatabase
import com.spascoding.englishstructure.feature_exam.data.repository.ConfigAppRepositoryImpl
import com.spascoding.englishstructure.feature_exam.data.repository.ExamPatternRepositoryImpl
import com.spascoding.englishstructure.feature_exam.data.repository.FirebaseRepositoryImpl
import com.spascoding.englishstructure.feature_exam.data.repository.SharedPreferencesRepositoryImpl
import com.spascoding.englishstructure.feature_exam.data.repository.utils.isConfigAppInstalled
import com.spascoding.englishstructure.feature_exam.domain.repository.ConfigRepository
import com.spascoding.englishstructure.feature_exam.domain.repository.ExamPatternRepository
import com.spascoding.englishstructure.feature_exam.domain.repository.SharedPreferencesRepository
import com.spascoding.englishstructure.feature_exam.domain.use_case.CommonUseCases
import com.spascoding.englishstructure.feature_exam.domain.use_case.GetExamPatternsUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.TenseUseCases
import com.spascoding.englishstructure.feature_exam.domain.use_case.TopicsUseCases
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetSentenceUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetSentencesUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetTensesAccuracyInfoUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetTopicsAccuracyInfoUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetTopicsUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetUsedSentencesByTenseAndTopicUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.ImportNotExistedSentencesUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.UpdateSentenceUseCase
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
    fun provideCommonUseCases(
        getExamPatternsUseCase: GetExamPatternsUseCase,
        importNotExistedSentencesUseCase: ImportNotExistedSentencesUseCase,
        updateSentenceUseCase: UpdateSentenceUseCase,
        getSentenceUseCase: GetSentenceUseCase,
    ): CommonUseCases {
        return CommonUseCases(
            getExamPatternsUseCase,
            importNotExistedSentencesUseCase,
            updateSentenceUseCase,
            getSentenceUseCase,
        )
    }

    @Provides
    @Singleton
    fun provideTenseUseCases(
        getTensesAccuracyInfoUseCase: GetTensesAccuracyInfoUseCase,
    ): TenseUseCases {
        return TenseUseCases(
            getTensesAccuracyInfoUseCase,
        )
    }

    @Provides
    @Singleton
    fun provideTopicsUseCases(
        getSentencesUseCase: GetSentencesUseCase,
        getTopicsUseCase: GetTopicsUseCase,
        getUsedSentencesByTenseAndTopicUseCase: GetUsedSentencesByTenseAndTopicUseCase,
        getTopicsAccuracyInfoUseCase: GetTopicsAccuracyInfoUseCase,
    ): TopicsUseCases {
        return TopicsUseCases(
            getSentencesUseCase,
            getTopicsUseCase,
            getUsedSentencesByTenseAndTopicUseCase,
            getTopicsAccuracyInfoUseCase,
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

    @Provides
    @Singleton
    fun provideConfigRepository(@ApplicationContext context: Context): ConfigRepository {

        return if (isConfigAppInstalled(context)) {
            Toast.makeText(context, "Config app is used", Toast.LENGTH_LONG).show()
            ConfigAppRepositoryImpl(context)
        } else {
            FirebaseRepositoryImpl()
        }
    }

}