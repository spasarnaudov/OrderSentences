package com.sacoding.feature_order_sentence.domain.use_case

data class OrderSentenceUseCases(
    val getLessenUseCase: GetLessenUseCase,
    val incrementVerbMistakeCountUseCase: IncrementVerbMistakeCountUseCase,
    val isNotVerbsInDatabaseUseCase: IsNotVerbsInDatabaseUseCase,
    val uploadVerbsToDBUseCase: UploadVerbsToDBUseCase,
)