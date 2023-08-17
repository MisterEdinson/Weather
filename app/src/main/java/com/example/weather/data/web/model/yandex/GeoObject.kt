package com.example.weather.data.web.model.yandex

import com.google.gson.annotations.SerializedName

data class GeoObject(

	@field:SerializedName("country")
	val country: Country? = null,

	@field:SerializedName("province")
	val province: Province? = null,

	@field:SerializedName("district")
	val district: Any? = null,

	@field:SerializedName("locality")
	val locality: Locality? = null
)