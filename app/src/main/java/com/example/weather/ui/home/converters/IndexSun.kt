package com.example.weather.ui.home.converters

class IndexSun {
    fun indexConverted(index: Int?): String{
        return when (index) {
            0, 1, 2 -> "низкий уровень"
            3, 4, 5 -> "умеренный уровень"
            6, 7 -> "высокий уровень"
            8, 9, 10 -> "очень высокий уровень"
            11, 12, 13, 14, 15 -> "экстримальный уровень"
            else -> {""}
        }
    }
}