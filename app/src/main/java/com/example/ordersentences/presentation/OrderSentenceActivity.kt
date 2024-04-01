package com.example.ordersentences.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ordersentences.data.data_source.OrderSentenceDatabase
import com.example.ordersentences.data.repository.VerbRepositoryImpl
import com.example.ordersentences.domain.OrderSentenceEvent
import com.example.ordersentences.domain.model.GameState
import com.example.ordersentences.domain.use_case.GetAllVerbsUseCase
import com.example.ordersentences.domain.use_case.GetLessenUseCase
import com.example.ordersentences.domain.use_case.GetObjectUseCase
import com.example.ordersentences.domain.use_case.GetSubjectUseCase
import com.example.ordersentences.domain.use_case.GetVerbUseCase
import com.example.ordersentences.domain.use_case.IncrementVerbMistakeCountUseCase
import com.example.ordersentences.domain.use_case.IsNotVerbsInDatabaseUseCase
import com.example.ordersentences.domain.use_case.OrderSentenceUseCases
import com.example.ordersentences.domain.use_case.UploadVerbsToDBUseCase
import com.example.ordersentences.presentation.theme.OrderSentencesTheme
import com.example.ordersentences.presentation.ui.components.InputScreen
import com.example.ordersentences.presentation.ui.components.ResultScreen

class OrderSentenceActivity : ComponentActivity() {

    private val viewModel by viewModels<OrderSentenceViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    val repository = VerbRepositoryImpl(OrderSentenceDatabase.getDatabase(applicationContext).dao)
                    val useCases = OrderSentenceUseCases(
                        GetAllVerbsUseCase(repository = repository),
                        GetLessenUseCase(repository = repository),
                        GetObjectUseCase(repository = repository),
                        GetSubjectUseCase(repository = repository),
                        GetVerbUseCase(repository = repository),
                        IncrementVerbMistakeCountUseCase(repository = repository),
                        IsNotVerbsInDatabaseUseCase(repository = repository),
                        UploadVerbsToDBUseCase(repository = repository),
                    )
                    return OrderSentenceViewModel(useCases) as T
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
                    when (viewModel.getGameState()) {
                        GameState.FINISHED -> {
                            ResultScreen(viewModel)
                        }
                        GameState.STARTED -> {
                            InputScreen(viewModel)
                        }
                    }
                }
            }
        }
    }

}