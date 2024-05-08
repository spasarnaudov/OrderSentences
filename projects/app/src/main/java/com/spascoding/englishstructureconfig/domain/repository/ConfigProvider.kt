package com.spascoding.englishstructureconfig.domain.repository

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri
import org.json.JSONObject

class ConfigProvider : ContentProvider() {
    override fun onCreate(): Boolean {
        return true
    }

    override fun query(
        uri: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor {
        val json = fetchJsonData()
        val matrixCursor = MatrixCursor(arrayOf("json"))
        matrixCursor.addRow(arrayOf(json))
        return matrixCursor
    }

    override fun getType(p0: Uri): String? {
        TODO("Not yet implemented")
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        throw UnsupportedOperationException("Not supported")
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        throw UnsupportedOperationException("Not supported")
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        throw UnsupportedOperationException("Not supported")
    }

    private fun fetchJsonData(): String {
        val prefs = context?.getSharedPreferences("EnglishStructureConfigAppPrefs", Context.MODE_PRIVATE)
        val allEntries = prefs?.all
        val jsonObject = JSONObject()
        if (allEntries != null) {
            for ((key, value) in allEntries) {
                jsonObject.put(key, value)
            }
        }
        return jsonObject.toString()
    }
}