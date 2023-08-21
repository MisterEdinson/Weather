package com.example.weather.data.web.model.yandex

import com.google.gson.annotations.SerializedName

data class Biomet(

	@field:SerializedName("condition")
	val condition: String? = null,

	@field:SerializedName("index")
	val index: Int? = null
)