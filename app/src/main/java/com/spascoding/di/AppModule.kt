package com.spascoding.di

import android.content.Context
import com.spascoding.feature_exam.data.repository.SentencesRepositoryImpl
import com.spascoding.feature_exam.data.repository.SharedPreferencesRepositoryImpl
import com.spascoding.feature_exam.domain.repository.SentencesRepository
import com.spascoding.feature_exam.domain.repository.SharedPreferencesRepository
import com.spascoding.feature_exam.domain.use_case.ExamUseCases
import com.spascoding.feature_exam.domain.use_case.GetExamUseCase
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
    fun provideInitialDataRepository(): SentencesRepository {
        return SentencesRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideExamUseCases(getExamUseCase: GetExamUseCase): ExamUseCases {
        return ExamUseCases(getExamUseCase)
    }

    @Provides
    @Singleton
    fun provideSharedPreferencesRepository(@ApplicationContext context: Context): SharedPreferencesRepository {
        return SharedPreferencesRepositoryImpl(context)
    }

}