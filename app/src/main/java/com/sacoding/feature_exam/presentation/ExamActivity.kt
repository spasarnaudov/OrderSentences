package com.sacoding.feature_exam.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sacoding.feature_exam.data.data_source.OrderSentenceDatabase
import com.sacoding.feature_exam.data.repository.VerbRepositoryImpl
import com.sacoding.feature_exam.domain.use_case.GetExamUseCase
import com.sacoding.feature_exam.domain.use_case.IncrementVerbMistakeCountUseCase
import com.sacoding.feature_exam.domain.use_case.IsNotVerbsInDatabaseUseCase
import com.sacoding.feature_exam.domain.use_case.ExamUseCases
import com.sacoding.feature_exam.domain.use_case.UploadVerbsToDBUseCase
import com.sacoding.feature_exam.presentation.theme.OrderSentencesTheme
import com.sacoding.feature_lessens_list.presentation.components.Navigation

class ExamActivity : ComponentActivity() {

    private val viewModel by viewModels<ExamViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    val repository = VerbRepositoryImpl(OrderSentenceDatabase.getDatabase(applicationContext).dao)
                    val useCases = ExamUseCases(
                        GetExamUseCase(repository = repository),
                        IncrementVerbMistakeCountUseCase(repository = repository),
                        IsNotVerbsInDatabaseUseCase(repository = repository),
                        UploadVerbsToDBUseCase(repository = repository),
                    )
                    return ExamViewModel(useCases) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrderSentencesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(viewModel)
                }
            }
        }
    }

}