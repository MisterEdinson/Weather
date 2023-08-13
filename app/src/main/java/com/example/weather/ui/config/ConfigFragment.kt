package com.example.weather.ui.config

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.weather.R
import com.example.weather.databinding.FragmentConfigBinding
import com.example.weather.ui.config.adapters.AdapterLangConfig
import com.example.weather.ui.config.adapters.AdapterPrecipitationConfig
import com.example.weather.ui.config.adapters.AdapterPressureConfig
import com.example.weather.ui.config.adapters.AdapterTempConfig
import com.example.weather.ui.config.adapters.AdapterTimeConfig
import com.example.weather.ui.config.adapters.AdapterWindConfig
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.NonDisposableHandle.parent
@AndroidEntryPoint
class ConfigFragment : Fragment() {

    private lateinit var binding: FragmentConfigBinding
    private var adapterTemp: AdapterTempConfig? = null
    private var adapterTime: AdapterTimeConfig? = null
    private var adapterPrecipitation: AdapterPrecipitationConfig? = null
    private var adapterWind: AdapterWindConfig? = null
    private var adapterPressure: AdapterPressureConfig? = null
    private var adapterLang: AdapterLangConfig? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConfigBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        binding.btnSaveConfig.setOnClickListener{
            findNavController().navigate(R.id.action_configFragment_to_homeFragment)
        }
    }

    private fun initAdapter(){
        adapterTemp = AdapterTempConfig(this.context)
        binding.spConfigTemp.adapter = adapterTemp

        adapterTime = AdapterTimeConfig(this.context)
        binding.spConfigTime.adapter = adapterTime

        adapterPrecipitation = AdapterPrecipitationConfig(this.context)
        binding.spConfigPrecipitation.adapter = adapterPrecipitation

        adapterWind = AdapterWindConfig(this.context)
        binding.spConfigWind.adapter = adapterWind

        adapterPressure = AdapterPressureConfig(this.context)
        binding.spConfigPressure.adapter = adapterPressure

        adapterLang = AdapterLangConfig(this.context)
        binding.spConfigLanguage.adapter = adapterLang
    }
}