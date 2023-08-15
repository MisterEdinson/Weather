package com.example.weather.data.web.model.yandex

import com.google.gson.annotations.SerializedName

data class Fact(

	@field:SerializedName("accum_prec")
	val accumPrec: AccumPrec? = null,

	@field:SerializedName("icon")
	val icon: String? = null,

	@field:SerializedName("source")
	val source: String? = null,

	@field:SerializedName("wind_gust")
	val windGust: Any? = null,

	@field:SerializedName("is_thunder")
	val isThunder: Boolean? = null,

	@field:SerializedName("uv_index")
	val uvIndex: Int? = null,

	@field:SerializedName("prec_type")
	val precType: Int? = null,

	@field:SerializedName("pressure_pa")
	val pressurePa: Int? = null,

	@field:SerializedName("humidity")
	val humidity: Int? = null,

	@field:SerializedName("season")
	val season: String? = null,

	@field:SerializedName("wind_speed")
	val windSpeed: Int? = null,

	@field:SerializedName("soil_temp")
	val soilTemp: Int? = null,

	@field:SerializedName("obs_time")
	val obsTime: Int? = null,

	@field:SerializedName("polar")
	val polar: Boolean? = null,

	@field:SerializedName("temp")
	val temp: Int? = null,

	@field:SerializedName("pressure_mm")
	val pressureMm: Int? = null,

	@field:SerializedName("cloudness")
	val cloudness: Float? = null,

	@field:SerializedName("wind_dir")
	val windDir: String? = null,

	@field:SerializedName("feels_like")
	val feelsLike: Int? = null,

	@field:SerializedName("uptime")
	val uptime: Int? = null,

	@field:SerializedName("condition")
	val condition: String? = null,

	@field:SerializedName("prec_strength")
	val precStrength: Float? = null,

	@field:SerializedName("soil_moisture")
	val soilMoisture: Any? = null,

	@field:SerializedName("daytime")
	val daytime: String? = null,

	@field:SerializedName("prec_prob")
	val precProb: Int? = null
)