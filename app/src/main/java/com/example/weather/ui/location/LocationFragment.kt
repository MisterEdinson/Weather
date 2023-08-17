package com.example.weather.ui.location

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weather.R
import com.example.weather.databinding.ActivityMainBinding
import com.example.weather.databinding.FragmentLocationBinding
import dagger.hilt.android.qualifiers.ApplicationContext
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

class LocationFragment : Fragment() {

    private lateinit var binding: FragmentLocationBinding
    private lateinit var mapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLocationBinding.inflate(LayoutInflater.from(this.context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Configuration.getInstance().load(this.context, PreferenceManager.getDefaultSharedPreferences(this.context))
        binding.map.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE)
        binding.map.controller.setCenter(GeoPoint(55.664187, 37.598672))
        binding.map.controller.setZoom(10.0)
    }
}