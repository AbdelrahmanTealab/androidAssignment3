package com.example.abdelrahmantealab_mapd711_assignment3

import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.*



class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val cityName = intent.extras?.getString("city")
    }

    override fun onMapReady(googleMap: GoogleMap) {
        //get city name and specify location and coords
        mMap = googleMap

        var cityName = intent.extras?.getString("city") + " ONTARIO"
        cityName = cityName.replace("\\s".toRegex(),"+")
        println(cityName)

        val geocoder = Geocoder(this, Locale.getDefault())
        val cityLocation = geocoder.getFromLocationName(cityName, 1)
        val cityLat = cityLocation[0].latitude
        val cityLong = cityLocation[0].longitude
        val cityCoords = LatLng(cityLat, cityLong)

        //move the camera and add markers to restaurants
        mMap.addMarker(MarkerOptions().position(cityCoords).title("Marker in " + cityName))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cityCoords, 10F))

        //dictionary or map, to store pizza restaurant name and its coords in array as value
        val scarboroughPizzas:Map<String,Array<Double>>


    }
}



