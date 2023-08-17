package com.example.weather.ui.config

import android.content.Context
import javax.inject.Inject

class LocalConfigSave @Inject constructor(context: Context?) {

    private var saveShare = SharedPrefSaveData(context)
    fun saveConf(key: String?, desc: String?) {
        saveShare.save(key, desc)
        saveShare.save("def", "false")
    }

    fun defaultConfig(): Boolean {
        return saveShare.read("def") != null
    }
}