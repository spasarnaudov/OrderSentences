package com.spascoding.englishstructure.di

import android.content.Context
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.spascoding.englishstructure.feature_exam.data.local.EnglishStructureDao
import com.spascoding.englishstructure.feature_exam.data.local.EnglishStructureDatabase
import com.spascoding.englishstructure.feature_exam.data.repository.ConfigAppRepositoryImpl
import com.spascoding.englishstructure.feature_exam.data.repository.ExamPatternRepositoryImpl
import com.spascoding.englishstructure.feature_exam.data.repository.FirebaseRepositoryImpl
import com.spascoding.englishstructure.feature_exam.data.repository.SharedPreferencesRepositoryImpl
import com.spascoding.englishstructure.feature_exam.data.repository.utils.SentenceSyncWorker
import com.spascoding.englishstructure.feature_exam.data.repository.utils.isConfigAppInstalled
import com.spascoding.englishstructure.feature_exam.domain.repository.ConfigRepository
import com.spascoding.englishstructure.feature_exam.domain.repository.ExamPatternRepository
import com.spascoding.englishstructure.feature_exam.domain.repository.SharedPreferencesRepository
import com.spascoding.englishstructure.feature_exam.domain.use_case.CommonUseCases
import com.spascoding.englishstructure.feature_exam.domain.use_case.GetExamPatternsUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.TenseUseCases
import com.spascoding.englishstructure.feature_exam.domain.use_case.TopicsUseCases
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetTenseInfoUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetSentenceUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetTopicSentencesUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetTopicInfoUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetTopicsUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.GetRecentSentencesUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.ImportNotExistedSentencesUseCase
import com.spascoding.englishstructure.feature_exam.domain.use_case.database.RemoveExistedSentencesUseCase
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
        removeExistedSentencesUseCase: RemoveExistedSentencesUseCase,
        importNotExistedSentencesUseCase: ImportNotExistedSentencesUseCase,
        updateSentenceUseCase: UpdateSentenceUseCase,
        getSentenceUseCase: GetSentenceUseCase,
    ): CommonUseCases {
        return CommonUseCases(
            getExamPatternsUseCase,
            removeExistedSentencesUseCase,
            importNotExistedSentencesUseCase,
            updateSentenceUseCase,
            getSentenceUseCase,
        )
    }

    @Provides
    @Singleton
    fun provideTenseUseCases(
        getTenseInfoUseCase: GetTenseInfoUseCase,
    ): TenseUseCases {
        return TenseUseCases(
            getTenseInfoUseCase,
        )
    }

    @Provides
    @Singleton
    fun provideTopicsUseCases(
        getTopicSentencesUseCase: GetTopicSentencesUseCase,
        getTopicsUseCase: GetTopicsUseCase,
        getUsedSentencesByTenseAndTopicUseCase: GetRecentSentencesUseCase,
        getTopicInfoUseCase: GetTopicInfoUseCase,
    ): TopicsUseCases {
        return TopicsUseCases(
            getTopicSentencesUseCase,
            getTopicsUseCase,
            getUsedSentencesByTenseAndTopicUseCase,
            getTopicInfoUseCase,
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
        )
            .addCallback(object : RoomDatabase.Callback() {
                override fun onOpen(db: SupportSQLiteDatabase) {
                    super.onOpen(db)
                    SentenceSyncWorker.sync(context)
                }
            })
            .build()
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
            ConfigAppRepositoryImpl(context)
        } else {
            FirebaseRepositoryImpl()
        }
    }

}