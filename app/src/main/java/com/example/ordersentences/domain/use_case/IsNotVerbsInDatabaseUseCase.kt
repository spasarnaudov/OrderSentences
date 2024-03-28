package com.example.ordersentences.domain.use_case

import com.example.ordersentences.data.VerbDao

class IsNotVerbsInDatabaseUseCase(
    private val dao: VerbDao
) {
    suspend operator fun invoke(): Boolean {
        return dao.countRows() == 0
    }
}