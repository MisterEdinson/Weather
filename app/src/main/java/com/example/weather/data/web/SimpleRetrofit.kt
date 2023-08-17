package com.example.weather.data.web

import com.example.weather.data.web.model.yandex.YandexModel
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleRetrofit {
    @GET("forecast")
    suspend fun getWeatherYandex(
        @Query("lat") geoLat: String,
        @Query("lon") geoLon: String,
        @Query("lang") confLang: String,
        @Query("limit") confLimit: String,
        @Query("hours") confHour: String,
        @Query("extra") confExtra: String,
    ): YandexModel

}