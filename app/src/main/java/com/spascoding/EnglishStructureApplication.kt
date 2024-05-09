package com.spascoding

import android.app.Application
import android.util.Log
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
import com.google.firebase.remoteconfig.remoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings
import com.spascoding.englishstructure.R
import com.spascoding.englishstructure.feature_exam.data.repository.utils.isConfigAppInstalled
import com.spascoding.englishstructure.feature_exam.data.repository.utils.readConfigAppData
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EnglishStructureApplication: Application() {

    val TAG = "EnglishStructureApplication"

    override fun onCreate() {
        super.onCreate()

        if (isConfigAppInstalled(this)) {
            readConfigAppData(this)
            Toast.makeText(this, "Local configuration app is used", Toast.LENGTH_LONG).show()
        } else {
            setupFirebaseRemoteConfig()
        }
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
            printParameters(remoteConfig.all)
        }
    }

    private fun printParameters(map: Map<String, FirebaseRemoteConfigValue>) {
        map.forEach { entry ->
            Log.d(TAG, "${entry.key}: ${entry.value.asString()}.")
        }
    }
}