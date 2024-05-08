package com.spascoding.englishstructure.feature_exam.data.repository.utils

import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log
import org.json.JSONObject

private const val TAG = "ConfigApp"
private const val CONFIG_APP_PACKAGE = "com.spascoding.englishstructureconfig"

fun readConfigAppData(context: Context): String? {
    val uri = Uri.parse("content://com.spascoding.englishstructureconfig.domain.repository.ConfigProvider")
    val cursor = context.contentResolver.query(uri, null, null, null, null)

    cursor?.moveToFirst()
    val json = cursor?.getString(cursor.run { getColumnIndex("json") })
    cursor?.close()

    Log.d(TAG, "Received JSON: $json")
    return json
}

fun isConfigAppInstalled(context: Context): Boolean {
    return try {
        val packageManager = context.packageManager
        packageManager.getPackageInfo(CONFIG_APP_PACKAGE, 0)
        true
    } catch (e: PackageManager.NameNotFoundException) {
        false
    }
}

fun getValue(context: Context, key: String): String {
    val json = readConfigAppData(context) ?: return ""
    val resultMap = jsonToMap(json)
    return resultMap[key].toString()
}

private fun jsonToMap(jsonData: String): Map<String, Any?> {
    val map = mutableMapOf<String, Any?>()
    val jsonObject = JSONObject(jsonData)
    val keys = jsonObject.keys()

    while (keys.hasNext()) {
        val key = keys.next()
        map[key] = jsonObject.get(key)
    }

    return map
}