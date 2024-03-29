package com.example.ordersentences.domain.use_case

data class OrderSentenceUseCases(
    val getAllVerbsUseCase: GetAllVerbsUseCase,
    val getObjectUseCase: GetObjectUseCase,
    val getSubjectUseCase: GetSubjectUseCase,
    val getVerbUseCase: GetVerbUseCase,
    val incrementVerbMistakeCountUseCase: IncrementVerbMistakeCountUseCase,
    val isNotVerbsInDatabaseUseCase: IsNotVerbsInDatabaseUseCase,
    val uploadVerbsToDBUseCase: UploadVerbsToDBUseCase,
)