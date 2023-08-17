package com.example.weather.data.web.model.yandex

import com.google.gson.annotations.SerializedName

data class Yesterday(

	@field:SerializedName("temp")
	val temp: Int? = null
)