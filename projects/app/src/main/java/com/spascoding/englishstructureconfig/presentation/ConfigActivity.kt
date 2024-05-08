package com.spascoding.englishstructureconfig.presentation

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.spascoding.englishstructureconfig.domain.repository.GetValueType
import com.spascoding.englishstructureconfig.domain.repository.ValueType
import com.spascoding.englishstructureconfig.presentation.theme.EnglishStructureConfigTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConfigActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EnglishStructureConfigTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConfigList()
                }
            }
        }
    }
}

@Composable
fun ConfigList(
    viewModel: ConfigViewModel = hiltViewModel()
) {
    val showDialog = remember { mutableStateOf(false) }
    val rememberParameter = remember { mutableStateOf("") }
    val rememberValue = remember { mutableStateOf("") }

    if (showDialog.value)
        CustomDialog(
            parameter = rememberParameter.value,
            value = rememberValue.value,
            setShowDialog = {
                showDialog.value = it
            }
        ) {
            viewModel.setConfig(rememberParameter.value, it)
        }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier.padding(vertical = 8.dp),
            onClick = {
                viewModel.syncFirebase()
            }) {
            Text(text = "Load from Firebase")
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            viewModel.state.value.config.forEach { (parameter, value) ->
                item {
                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(),
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                showDialog.value = true
                                rememberParameter.value = parameter
                                rememberValue.value = value
                            }
                            .wrapContentHeight()
                            .padding(start = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            modifier = Modifier.weight(1f),
                        ) {
                            Text(
                                text = parameter,
                                fontWeight = FontWeight.Bold,
                            )
                            Text(
                                text = value,
                            )
                        }
                        Icon(
                            modifier = Modifier.padding(16.dp),
                            imageVector = Icons.Default.Edit,
                            contentDescription = ""
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun CustomDialog(
    parameter: String,
    value: String,
    setShowDialog: (Boolean) -> Unit,
    setValue: (String) -> Unit,
) {
    val txtField = remember { mutableStateOf(value) }

    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Surface {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = parameter,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(20.dp))

                val valueType = GetValueType(txtField.value).get()
                when (valueType) {
                    ValueType.STRING -> {
                        TextField(
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = { Text(text = "Enter value") },
                            value = txtField.value,
                            onValueChange = {
                                txtField.value = it.take(10)
                            },
                        )
                    }
                    ValueType.INT -> {
                        TextField(
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = { Text(text = "Enter value") },
                            value = txtField.value,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            onValueChange = {
                                txtField.value = it.take(10)
                            },
                        )
                    }
                    ValueType.BOOLEAN -> {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = txtField.value == "true",
                                onClick = { txtField.value = "true" }
                            )
                            Text("true")
                            RadioButton(
                                selected = txtField.value == "false",
                                onClick = { txtField.value = "false" }
                            )
                            Text("false")
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        if (txtField.value.isEmpty()) {
                            return@Button
                        }
                        setValue(txtField.value)
                        setShowDialog(false)
                    },
                ) {
                    Text(text = "Done")
                }
            }
        }
    }
}