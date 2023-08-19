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

    fun saveGeo(geoKey: String, geo: Double) {
        saveShare.saveGeo(geoKey, geo)
    }

    fun readGeo(latitude: String, longitude: String): Array<Double> {
        val mass: Array<Double> = arrayOf(-1.0, -1.0)
        val lat = saveShare.read(latitude)
        val lon = saveShare.read(longitude)
        if (lat != null && lon != null) {
            mass[0] = lat.toDouble()
            mass[1] = lon.toDouble()
        }
        return mass
    }
}