package com.example.weather.data.web.model.yandex

import com.google.gson.annotations.SerializedName

data class Parts(

	@field:SerializedName("night")
	val night: Night? = null,

	@field:SerializedName("day_short")
	val dayShort: DayShort? = null,

	@field:SerializedName("evening")
	val evening: Evening? = null,

	@field:SerializedName("day")
	val day: Day? = null,

	@field:SerializedName("night_short")
	val nightShort: NightShort? = null,

	@field:SerializedName("morning")
	val morning: Morning? = null
)