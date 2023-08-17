package com.example.weather.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.weather.R
import com.example.weather.databinding.FragmentHomeBinding
import com.example.weather.ui.home.converters.Condition
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.weatherLive.observe(viewLifecycleOwner) {
            binding.tvHeaderLoacation.text = getString(
                R.string.location_show,
                it.geoObject?.locality?.name,
                it.geoObject?.country?.name
            )

            binding.mainBanner.tvNightDayTemp.text = getString(
                R.string.temp_naught_day,
                it.forecasts?.get(0)?.parts?.night?.tempMax,
                it.forecasts?.get(0)?.parts?.day?.tempMax
            )
            binding.mainBanner.tvActyalTemp.text = getString(R.string.temp_show, it.fact?.temp)
            binding.mainBanner.tvVectorWind.text =
                getString(R.string.vector_show, it.fact?.windDir).uppercase()
            binding.mainBanner.tvSpeedWind.text = getString(R.string.speed_show, it.fact?.windSpeed)
            binding.mainBanner.tvHumidity.text =
                getString(R.string.humidity_show, it.fact?.humidity)
            binding.mainBanner.tvActyalWeather.text = Condition().converted(it.fact?.condition)
        }

        binding.imgBtnBar.setOnClickListener {
            viewModel.drawerLayoutState.value = true
        }
    }
}