package com.example.weather.data.web.model.yandex

import com.google.gson.annotations.SerializedName

data class Country(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)