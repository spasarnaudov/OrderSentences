package com.spascoding.englishstructureconfig.presentation

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.remoteConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ConfigViewModel @Inject constructor(
    context: Context
) : ViewModel() {

    private val preferences: SharedPreferences = context.getSharedPreferences("EnglishStructureConfigAppPrefs", Context.MODE_PRIVATE)

    private val _state = mutableStateOf(ConfigState())
    val state: State<ConfigState> = _state

    init {
        syncPreferences()
    }

    fun syncFirebase() {
        val remoteConfig = Firebase.remoteConfig
        remoteConfig.fetchAndActivate().addOnCompleteListener { task ->
            if (preferences.edit().clear().commit()) {
                val map: MutableMap<String, String> = mutableMapOf()
                remoteConfig.all.forEach { entry ->
                    preferences.edit().putString(entry.key, entry.value.asString()).commit()
                    map[entry.key] = entry.value.asString()
                }
                _state.value = state.value.copy(
                    config = map,
                )
            }
        }
    }

    fun syncPreferences() {
        val map: MutableMap<String, String> = mutableMapOf()
        preferences.all.forEach { entry ->
            map[entry.key] = entry.value.toString()
        }
        _state.value = state.value.copy(
            config = map,
        )
    }

    fun setConfig(key: String, value: String) {
        preferences.edit().putString(key, value).commit()
        state.value.config[key] = value
        _state.value = state.value.copy(
            config = state.value.config,
        )
    }

}