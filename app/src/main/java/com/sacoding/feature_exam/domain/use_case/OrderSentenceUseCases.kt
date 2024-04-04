package com.sacoding.feature_exam.domain.use_case

data class OrderSentenceUseCases(
    val getLessenUseCase: GetLessenUseCase,
    val incrementVerbMistakeCountUseCase: IncrementVerbMistakeCountUseCase,
    val isNotVerbsInDatabaseUseCase: IsNotVerbsInDatabaseUseCase,
    val uploadVerbsToDBUseCase: UploadVerbsToDBUseCase,
)