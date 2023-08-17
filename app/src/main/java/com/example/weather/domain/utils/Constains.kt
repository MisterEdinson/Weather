package com.example.weather.domain.utils

class Constains {
    companion object {
        const val URL_YANDEX = "https://api.weather.yandex.ru/v2/"
        const val TOKEN_YANDEX = "d945af63-61f9-4fac-891d-2279e97765d1"

        const val GEO_LAT = "50.2757" //широта
        const val GEO_LON = "57.2072"  //долгота
        const val CONF_LANG = "ru_RU" //язык ответа
        const val CONF_LIMIT = "1" //срок прогноза
        const val CONF_HOUR = "true"  // наличие почасового прогноза
        const val CONF_EXTRA = "true"  // подробный прогноз осадков
    }
}