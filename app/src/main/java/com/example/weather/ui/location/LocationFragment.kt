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
    private var initialPosition: GeoPoint? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentLocationBinding.inflate(LayoutInflater.from(this.context), container, false)
        localConfig = LocalConfigSave(this.context)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        centerScreen()
        markerScreen()

        marker.setOnMarkerDragListener(object : Marker.OnMarkerDragListener {
            override fun onMarkerDrag(marker: Marker) {}
            override fun onMarkerDragEnd(marker: Marker) {
                saveGeo()
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

    private fun centerScreen() {
        val latitude: Double
        val longitude: Double

        val sharedGeo = localConfig?.readGeo("lat", "long")

        if (sharedGeo?.get(0) != -1.0 && sharedGeo?.get(1) != -1.0) {
            latitude = sharedGeo!![0]
            longitude = sharedGeo[1]
        } else {
            latitude = Constains.GEO_LAT.toDouble()
            longitude = Constains.GEO_LON.toDouble()
        }

        mapView = binding.map
        Configuration.getInstance()
            .load(this.context, PreferenceManager.getDefaultSharedPreferences(this.context))
        mapView.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE)
        mapView.controller.setZoom(10.0)

        mapView.controller.setCenter(
            GeoPoint(
                latitude,
                longitude
            )
        )
        initialPosition = GeoPoint(latitude, longitude)
    }

    private fun markerScreen() {
        marker = Marker(mapView)
        marker.position = initialPosition
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        mapView.overlays.add(marker)
        marker.isDraggable = true
    }

    private fun saveGeo() {
        localConfig?.saveGeo("lat", marker.position.latitude)
        localConfig?.saveGeo("long", marker.position.longitude)
        Toast.makeText(context, "Saved location", Toast.LENGTH_SHORT).show()
    }
}