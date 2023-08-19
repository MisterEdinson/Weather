package com.example.weather.ui.location

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.weather.R
import com.example.weather.databinding.FragmentLocationBinding
import com.example.weather.domain.utils.Constains
import com.example.weather.ui.config.LocalConfigSave
import com.example.weather.ui.home.HomeViewModel
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class LocationFragment : Fragment() {

    private val viewModel: HomeViewModel by activityViewModels()
    private lateinit var binding: FragmentLocationBinding
    private lateinit var mapView: MapView
    private lateinit var marker: Marker
    private var localConfig: LocalConfigSave? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLocationBinding.inflate(LayoutInflater.from(this.context), container, false)
        localConfig = LocalConfigSave(this.context)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapView = binding.map
        Configuration.getInstance().load(this.context, PreferenceManager.getDefaultSharedPreferences(this.context))
        mapView.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE)
        mapView.controller.setZoom(10.0)
        mapView.controller.setCenter(GeoPoint(Constains.GEO_LAT.toDouble(), Constains.GEO_LON.toDouble()))

        var initialPosition = GeoPoint(Constains.GEO_LAT.toDouble(), Constains.GEO_LON.toDouble())
        marker = Marker(mapView)
        marker.position = initialPosition
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        mapView.overlays.add(marker)
        marker.isDraggable = true

        marker.setOnMarkerDragListener(object : Marker.OnMarkerDragListener {
            override fun onMarkerDrag(marker: Marker) {}
            override fun onMarkerDragEnd(marker: Marker) {
                initialPosition = GeoPoint(marker.position.altitude, marker.position.longitude)
                localConfig?.saveConf("altitude", marker.position.altitude.toString())
                localConfig?.saveConf("longitude", marker.position.longitude.toString())
                Toast.makeText(context, "Saved location", Toast.LENGTH_SHORT).show()
            }
            override fun onMarkerDragStart(marker: Marker) {}
        })

        binding.imgBtnBarLocFrag.setOnClickListener {
            viewModel.drawerLayoutState.value = true
        }

        binding.imgBtnCloseLocFrag.setOnClickListener {
            findNavController().navigate(R.id.nav_home)
        }
    }
}