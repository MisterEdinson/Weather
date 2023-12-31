package com.example.weather.data.web.model.yandex

import com.google.gson.annotations.SerializedName

data class Night(

	@field:SerializedName("icon")
	val icon: String? = null,

	@field:SerializedName("temp_max")
	val tempMax: Int? = null,

	@field:SerializedName("wind_gust")
	val windGust: Any? = null,

	@field:SerializedName("fresh_snow_mm")
	val freshSnowMm: Int? = null,

	@field:SerializedName("temp_min")
	val tempMin: Int? = null,

	@field:SerializedName("temp_avg")
	val tempAvg: Int? = null,

	@field:SerializedName("uv_index")
	val uvIndex: Int? = null,

	@field:SerializedName("prec_type")
	val precType: Int? = null,

	@field:SerializedName("pressure_pa")
	val pressurePa: Int? = null,

	@field:SerializedName("humidity")
	val humidity: Int? = null,

	@field:SerializedName("wind_speed")
	val windSpeed: Any? = null,

	@field:SerializedName("soil_temp")
	val soilTemp: Int? = null,

	@field:SerializedName("prec_mm")
	val precMm: Int? = null,

	@field:SerializedName("polar")
	val polar: Boolean? = null,

	@field:SerializedName("pressure_mm")
	val pressureMm: Int? = null,

	@field:SerializedName("cloudness")
	val cloudness: Int? = null,

	@field:SerializedName("prec_period")
	val precPeriod: Int? = null,

	@field:SerializedName("wind_dir")
	val windDir: String? = null,

	@field:SerializedName("feels_like")
	val feelsLike: Int? = null,

	@field:SerializedName("condition")
	val condition: String? = null,

	@field:SerializedName("_source")
	val source: String? = null,

	@field:SerializedName("prec_strength")
	val precStrength: Int? = null,

	@field:SerializedName("soil_moisture")
	val soilMoisture: Any? = null,

	@field:SerializedName("daytime")
	val daytime: String? = null,

	@field:SerializedName("prec_prob")
	val precProb: Int? = null
)