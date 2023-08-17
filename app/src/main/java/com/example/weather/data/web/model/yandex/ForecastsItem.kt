package com.example.weather.data.web.model.yandex

import com.google.gson.annotations.SerializedName

data class ForecastsItem(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("rise_begin")
	val riseBegin: String? = null,

	@field:SerializedName("sunrise")
	val sunrise: String? = null,

	@field:SerializedName("hours")
	val hours: List<HoursItem?>? = null,

	@field:SerializedName("biomet")
	val biomet: Biomet? = null,

	@field:SerializedName("week")
	val week: Int? = null,

	@field:SerializedName("moon_text")
	val moonText: String? = null,

	@field:SerializedName("date_ts")
	val dateTs: Int? = null,

	@field:SerializedName("sunset")
	val sunset: String? = null,

	@field:SerializedName("parts")
	val parts: Parts? = null,

	@field:SerializedName("set_end")
	val setEnd: String? = null,

	@field:SerializedName("moon_code")
	val moonCode: Int? = null
)