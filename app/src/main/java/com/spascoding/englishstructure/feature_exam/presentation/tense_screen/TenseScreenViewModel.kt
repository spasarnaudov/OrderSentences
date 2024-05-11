package com.spascoding.englishstructure.feature_exam.presentation.tense_screen

import androidx.lifecycle.ViewModel
import com.spascoding.englishstructure.feature_exam.domain.model.TenseInfo
import com.spascoding.englishstructure.feature_exam.domain.use_case.TenseUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class TenseScreenViewModel @Inject constructor(
    private val tenseUseCases: TenseUseCases,
) : ViewModel() {

    fun getTenseInfoFlow(): Flow<List<TenseInfo>> {
        return tenseUseCases.getTenseInfoUseCase.invoke()
    }

}