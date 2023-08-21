package com.example.weather.ui.home.converters

class IndexSun {
    fun indexConverted(index: Int?): String{
        return when (index) {
            0, 1, 2 -> "низкий"
            3, 4, 5 -> "умеренный"
            6, 7 -> "высокий"
            8, 9, 10 -> "очень высокий"
            11, 12, 13, 14, 15 -> "экстримальный"
            else -> {""}
        }
    }
}