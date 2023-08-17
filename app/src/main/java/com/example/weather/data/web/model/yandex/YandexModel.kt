package com.example.weather.data.web.model.yandex

import com.google.gson.annotations.SerializedName

data class YandexModel(

	@field:SerializedName("yesterday")
	val yesterday: Yesterday? = null,

	@field:SerializedName("now_dt")
	val nowDt: String? = null,

	@field:SerializedName("geo_object")
	val geoObject: GeoObject? = null,

	@field:SerializedName("fact")
	val fact: Fact? = null,

	@field:SerializedName("now")
	val now: Int? = null,

	@field:SerializedName("info")
	val info: Info? = null,

	@field:SerializedName("forecasts")
	val forecasts: List<ForecastsItem?>? = null
)