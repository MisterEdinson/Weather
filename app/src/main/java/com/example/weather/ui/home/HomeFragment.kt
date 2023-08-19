package com.example.weather.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.weather.R
import com.example.weather.databinding.FragmentHomeBinding
import com.example.weather.ui.home.adapter.HoursAdapter
import com.example.weather.ui.home.converters.Condition
import com.example.weather.ui.home.converters.TimeConvertedUnix
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by activityViewModels()
    private var adapter: HoursAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        viewModel.weatherLive.observe(viewLifecycleOwner) {
            //val forecast = it.forecasts?.getJSONObject("forecast")
            //adapter?.list?.submitList(forecast)

            it.forecasts?.forEach{
                adapter?.list?.submitList(it?.hours)
            }

//            val lineChart: LineChart = binding.lineChart
//            val entries = ArrayList<Entry>()
//            entries.add(Entry(1f, 5f))
//            entries.add(Entry(2f, 8f))
//            entries.add(Entry(3f, 60f))
//            entries.add(Entry(4f, 4f))
//            entries.add(Entry(5f, 2f))
//
//            val dataSet = LineDataSet(entries, "Label") // Замените "Label" на ваше название
//
//            // Настройка стиля набора данных
//            dataSet.color = Color.RED
//            dataSet.valueTextColor = Color.BLACK
//
//            val lineData = LineData(dataSet)
//
//            // Настройка описания графика
//            val description = Description()
//            description.text = "My Chart"
//            lineChart.description = description
//
//            lineChart.data = lineData
//            lineChart.invalidate()


            binding.apply {
                tvHeaderLoacation.text = getString(
                    R.string.location_show,
                    it.geoObject?.locality?.name,
                    it.geoObject?.country?.name
                )

                mainBanner.tvNightDayTemp.text = getString(
                    R.string.temp_naught_day,
                    it.forecasts?.get(0)?.parts?.night?.tempMax,
                    it.forecasts?.get(0)?.parts?.day?.tempMax
                )

                mainBanner.apply {
                    tvActyalTemp.text = getString(R.string.temp_show, it.fact?.temp)
                    tvVectorWind.text = getString(R.string.vector_show, it.fact?.windDir).uppercase()
                    tvSpeedWind.text = getString(R.string.speed_show, it.fact?.windSpeed)
                    tvHumidity.text = getString(R.string.humidity_show, it.fact?.humidity)
                    tvActyalWeather.text = Condition().converted(it.fact?.condition)

                    val tz = (it.info?.tzinfo?.offset ?: 0) + (it.fact?.uptime ?: 0)
                    tvTimeHome.text = TimeConvertedUnix().time(tz)
                    tvDateHome.text = TimeConvertedUnix().converted(tz)
                }
            }
        }

        binding.imgBtnBar.setOnClickListener {
            viewModel.drawerLayoutState.value = true
        }

        binding.imgBtnLocation.setOnClickListener {
            findNavController().navigate(R.id.nav_location)
        }
    }

    private fun initAdapter() {
        adapter = HoursAdapter()
        binding.rvHours.adapter = adapter
    }
}
