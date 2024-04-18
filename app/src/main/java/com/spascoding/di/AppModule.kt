package com.spascoding.di

import com.spascoding.feature_exam.data.repository.SentencesRepositoryImpl
import com.spascoding.feature_exam.domain.repository.SentencesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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

}