package com.example.weather.domain

import com.example.weather.data.web.SimpleRetrofit
import com.example.weather.data.web.model.yandex.YandexModel
import com.example.weather.domain.utils.Constains.Companion.CONF_EXTRA
import com.example.weather.domain.utils.Constains.Companion.CONF_HOUR
import com.example.weather.domain.utils.Constains.Companion.CONF_LANG
import com.example.weather.domain.utils.Constains.Companion.CONF_LIMIT
import com.example.weather.domain.utils.Constains.Companion.GEO_LAT
import com.example.weather.domain.utils.Constains.Companion.GEO_LON
import javax.inject.Inject

class Repository @Inject constructor(private val retrofit: SimpleRetrofit) {
    suspend fun getWeather(
        lat: String,
        long: String,
        lang: String,
        limit: String,
        hour: String,
        extra: String): YandexModel{
        return retrofit.getWeatherYandex(lat, long, lang, limit, hour, extra)
    }
}