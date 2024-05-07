package com.spascoding

import android.app.Application
import android.util.Log
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.remoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings
import com.spascoding.englishstructure.R
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EnglishStructureApplication: Application() {

    val TAG = "EnglishStructureApplication"

    override fun onCreate() {
        super.onCreate()
        setupFirebaseRemoteConfig()
    }

    private fun setupFirebaseRemoteConfig() {
        val remoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600 // Fetch every hour for production build
        }
        remoteConfig.setConfigSettingsAsync(configSettings)

        // Set default values. R.xml.remote_config_defaults should be defined similarly as in the Java example.
        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)

        // Fetch and activate the values
        remoteConfig.fetchAndActivate().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val updated = task.result
                // Log or handle the successful fetching and activation of remote configs
                Log.d(TAG, "Remote config values were updated: $updated")
            } else {
                // Log or handle the failure to fetch and activate
                Log.e(TAG, "Failed to fetch and activate remote config")
            }
            printParameters(remoteConfig)
        }
    }

    private fun printParameters(remoteConfig: FirebaseRemoteConfig) {
        Log.d(TAG, "Config params updated: ${remoteConfig.getLong("UnlockTensAccuracy")}")
        Log.d(TAG, "Config params updated: ${remoteConfig.getLong("UnlockTensSentenceCount")}")
        Log.d(TAG, "Config params updated: ${remoteConfig.getLong("UnlockTopicAccuracy")}")
        Log.d(TAG, "Config params updated: ${remoteConfig.getLong("UnlockTopicSentenceCount")}")
    }

}