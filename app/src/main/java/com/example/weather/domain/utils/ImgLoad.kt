package com.example.weather.domain.utils

import android.widget.ImageView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.weather.R

fun ImageView.loadImage(imgUrl: String) {
    val imageLoader = ImageLoader.Builder(this.context)
        .componentRegistry { add(SvgDecoder(this@loadImage.context)) }
        .build()

    val request = ImageRequest.Builder(this.context)
        .error(R.drawable.sunny)
        .data(imgUrl)
        .target(this)
        .build()
    imageLoader.enqueue(request)
}