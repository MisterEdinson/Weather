package com.example.weather.di

import com.example.weather.data.web.SimpleRetrofit
import com.example.weather.domain.utils.Constains.Companion.TOKEN_YANDEX
import com.example.weather.domain.utils.Constains.Companion.URL_YANDEX
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun baseUrl() = URL_YANDEX
    @Provides
    fun logging() = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    @Provides
    fun okHttpClient() = OkHttpClient.Builder().addInterceptor {
        val request = it.request()
            .newBuilder()
            .addHeader("X-Yandex-API-Key", TOKEN_YANDEX).build()
        it.proceed(request)
    }.addInterceptor(logging()).build()

    @Provides
    fun gson(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideRetrofit(): SimpleRetrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl())
            .addConverterFactory(gson())
            .client(okHttpClient())
            .build()
            .create(SimpleRetrofit::class.java)
}