package com.example.weather.ui.config

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.weather.MainActivity
import com.example.weather.R
import com.example.weather.databinding.FragmentConfigBinding
import com.example.weather.domain.utils.ConfigConstants
import com.example.weather.ui.config.adapters.AdapterConfig
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConfigFragment : Fragment() {

    private lateinit var binding: FragmentConfigBinding
    private var localConfig: LocalConfigSave? = null
    private var adapterTemp: AdapterConfig? = null
    private var adapterTime: AdapterConfig? = null
    private var adapterPrecipitation: AdapterConfig? = null
    private var adapterWind: AdapterConfig? = null
    private var adapterPressure: AdapterConfig? = null
    private var adapterLang: AdapterConfig? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConfigBinding.inflate(LayoutInflater.from(context), container, false)

        localConfig = LocalConfigSave(this.context)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()

        val spinners = listOf(
            binding.spConfigTemp,
            binding.spConfigTime,
            binding.spConfigPrecipitation,
            binding.spConfigWind,
            binding.spConfigPressure,
            binding.spConfigLanguage,
        )

        spinners.forEachIndexed { index, spinner ->
            selected(spinner)
        }

        binding.btnSaveConfig.setOnClickListener {
            findNavController().navigate(R.id.nav_home)
        }
    }

    private fun initAdapter() {
        adapterTemp =
            AdapterConfig(this.context, resources.getStringArray(R.array.config_temp_array))
        adapterTime = AdapterConfig(this.context, ConfigConstants().spinTime)
        adapterPrecipitation = AdapterConfig(this.context, ConfigConstants().spinPrecipitation)
        adapterWind = AdapterConfig(this.context, ConfigConstants().spinSpeed)
        adapterPressure = AdapterConfig(this.context, ConfigConstants().spinPressure)
        adapterLang = AdapterConfig(this.context, ConfigConstants().spinLanguage)
        binding.apply {
            spConfigTemp.adapter = adapterTemp
            spConfigTime.adapter = adapterTime
            spConfigPrecipitation.adapter = adapterPrecipitation
            spConfigWind.adapter = adapterWind
            spConfigPressure.adapter = adapterPressure
            spConfigLanguage.adapter = adapterLang
        }
    }

    private fun selected(spinnerAdapter: Spinner) {
        spinnerAdapter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var array: Array<String>? = null
                var key: String? = null
                when (parent) {
                    binding.spConfigTemp -> {
                        key = "temp"
                        array = resources.getStringArray(R.array.config_temp_array)
                    }

                    binding.spConfigTime -> {
                        key = "time"
                        array = resources.getStringArray(R.array.config_time_array)
                    }

                    binding.spConfigPrecipitation -> {
                        key = "precipitation"
                        array = resources.getStringArray(R.array.config_precipitation_array)
                    }

                    binding.spConfigWind -> {
                        key = "wind"
                        array = resources.getStringArray(R.array.config_wind_array)
                    }

                    binding.spConfigPressure -> {
                        key = "pres"
                        array = resources.getStringArray(R.array.config_pres_array)
                    }

                    binding.spConfigLanguage -> {
                        key = "lang"
                        array = resources.getStringArray(R.array.config_lang_array)
                    }
                }
                localConfig?.saveConf(key, array?.get(position))
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
}