package com.example.weather.ui.home.converters

class Condition {
    fun converted(text:String?): String?{
        var result: String? = null
        when(text){
            "clear" -> result = "Ясно"
            "partly-cloudy" -> result = "малооблачно"
            "cloudy" -> result = "облачно с прояснениями"
            "overcast" -> result = "пасмурно"
            "light-rain" -> result = "небольшой дождь"
            "rain" -> result = "дождь"
            "heavy-rain" -> result = "сильный дождь"
            "showers" -> result = "ливень"
            "wet-snow" -> result = "дождь со снегом"
            "light-snow" -> result = "небольшой снег"
            "snow" -> result = "снег"
            "snow-showers" -> result = "снегопад"
            "hail" -> result = "град"
            "thunderstorm" -> result = "гроза"
            "thunderstorm-with-rain" -> result = "дождь с грозой"
            "thunderstorm-with-hail" -> result = "гроза с градом"
        }
        return result
    }
}