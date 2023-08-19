package com.example.weather.ui.location

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.weather.databinding.FragmentLocationBinding
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class LocationFragment : Fragment() {

    private lateinit var binding: FragmentLocationBinding
    private lateinit var mapView: MapView
    private lateinit var marker: Marker

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLocationBinding.inflate(LayoutInflater.from(this.context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapView: MapView = binding.map
        Configuration.getInstance().load(this.context, PreferenceManager.getDefaultSharedPreferences(this.context))
        mapView.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE)
        mapView.controller.setCenter(GeoPoint(50.2757, 57.2072))
        mapView.controller.setZoom(10.0)

        var initialPosition = GeoPoint(50.2757, 57.2072)
        marker = Marker(mapView)
        marker.position = initialPosition
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        mapView.overlays.add(marker)
        marker.isDraggable = true

        marker.setOnMarkerDragListener(object : Marker.OnMarkerDragListener {
            override fun onMarkerDrag(marker: Marker) {}
            override fun onMarkerDragEnd(marker: Marker) {
                initialPosition = GeoPoint(marker.position.altitude, marker.position.longitude)
                Toast.makeText(context, marker.position.longitude.toString(), Toast.LENGTH_SHORT).show()
            }
            override fun onMarkerDragStart(marker: Marker) {}
        })
    }
}