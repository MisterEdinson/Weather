package com.example.weather.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.data.web.model.yandex.YandexModel
import com.example.weather.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo:Repository) : ViewModel() {

    val weatherLive: MutableLiveData<YandexModel> = MutableLiveData()
    var drawerLayoutState: MutableLiveData<Boolean> = MutableLiveData()
    init {
        getWeather()
        drawerLayoutState.value = false
    }
    fun getWeather(){
        viewModelScope.launch {
            val response = repo.getWeather()
            weatherLive.value = response
        }
    }
}