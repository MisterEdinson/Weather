package com.example.weather.ui.home.converters

import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone

class TimeConvertedUnix {
    fun converted(unixTime: Int?): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        dateFormat.timeZone = TimeZone.getTimeZone("UTC")
        val date = Date((unixTime?.toLong() ?: 1) * 1000)
        return dateFormat.format(date)
    }

    fun time(unixTime: Int?): String{
        val dateFormat = SimpleDateFormat("HH:mm")
        dateFormat.timeZone = TimeZone.getTimeZone("UTC")
        val date = Date((unixTime?.toLong() ?: 1) * 1000)
        return dateFormat.format(date)
    }
}