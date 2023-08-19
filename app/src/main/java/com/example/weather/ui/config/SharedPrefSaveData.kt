package com.example.weather.ui.config

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class SharedPrefSaveData @Inject constructor(private val context: Context?) {

    private val sharedPreferences: SharedPreferences by lazy {
        context!!.getSharedPreferences("SavedConfig", Context.MODE_PRIVATE)
    }

    fun save(key: String?, value: String?) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun read(key: String? = null, value: String? = null): String? {
        return sharedPreferences.getString(key, value)
    }

    fun saveGeo(key: String?, value: Double?) {
        sharedPreferences.edit().putString(key, value.toString()).apply()
    }
}