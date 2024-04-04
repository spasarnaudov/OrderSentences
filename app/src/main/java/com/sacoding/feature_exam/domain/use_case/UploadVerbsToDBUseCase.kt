package com.sacoding.feature_exam.domain.use_case

import com.sacoding.feature_exam.domain.model.Verb
import com.sacoding.feature_exam.domain.repository.VerbRepository

class UploadVerbsToDBUseCase(
    private val repository: VerbRepository
) {

    suspend operator fun invoke(verbs: List<Verb>) {
        repository.insertVerbs(verbs)
    }

}