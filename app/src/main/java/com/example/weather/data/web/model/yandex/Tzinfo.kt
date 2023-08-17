package com.example.weather.data.web.model.yandex

import com.google.gson.annotations.SerializedName

data class Tzinfo(

	@field:SerializedName("dst")
	val dst: Boolean? = null,

	@field:SerializedName("offset")
	val offset: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("abbr")
	val abbr: String? = null
)