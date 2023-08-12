package com.example.weather.data.web.model.yandex

import com.google.gson.annotations.SerializedName

data class Info(

	@field:SerializedName("nr")
	val nr: Boolean? = null,

	@field:SerializedName("ns")
	val ns: Boolean? = null,

	@field:SerializedName("f")
	val f: Boolean? = null,

	@field:SerializedName("def_pressure_mm")
	val defPressureMm: Int? = null,

	@field:SerializedName("_h")
	val h: Boolean? = null,

	@field:SerializedName("lon")
	val lon: Any? = null,

	@field:SerializedName("zoom")
	val zoom: Int? = null,

	@field:SerializedName("nsr")
	val nsr: Boolean? = null,

	@field:SerializedName("n")
	val n: Boolean? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("tzinfo")
	val tzinfo: Tzinfo? = null,

	@field:SerializedName("p")
	val p: Boolean? = null,

	@field:SerializedName("geoid")
	val geoid: Int? = null,

	@field:SerializedName("def_pressure_pa")
	val defPressurePa: Int? = null,

	@field:SerializedName("lat")
	val lat: Any? = null,

	@field:SerializedName("slug")
	val slug: String? = null
)