package com.spascoding.englishstructureconfig.presentation

data class ConfigState(
    val config: MutableMap<String, String> = mutableMapOf()
)