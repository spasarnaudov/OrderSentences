package com.spascoding

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.work.Configuration
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
import com.google.firebase.remoteconfig.remoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings
import com.spascoding.englishstructure.R
import com.spascoding.englishstructure.feature_exam.data.repository.utils.SentenceSyncWorker
import com.spascoding.englishstructure.feature_exam.data.repository.utils.isConfigAppInstalled
import com.spascoding.englishstructure.feature_exam.data.repository.utils.readConfigAppData
import com.spascoding.englishstructure.feature_exam.domain.use_case.DatabaseSyncUseCases
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


@HiltAndroidApp
class EnglishStructureApplication: Application(), Configuration.Provider {

    val TAG = "EnglishStructureApplication"

    @Inject
    lateinit var workerFactory: SentenceSyncWorkerFactory
    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()

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

class SentenceSyncWorkerFactory @Inject constructor(private val databaseSyncUseCases: DatabaseSyncUseCases): WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker = SentenceSyncWorker(
        context = appContext,
        workerParams = workerParameters,
        databaseSyncUseCases = databaseSyncUseCases
    )

}