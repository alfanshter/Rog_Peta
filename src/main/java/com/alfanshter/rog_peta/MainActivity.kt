package com.alfanshter.rog_peta

import android.app.Activity
import android.os.Bundle
import com.alfanshter.aplikasiiska.Model.AmbilData
import com.google.android.libraries.maps.CameraUpdateFactory
import com.google.android.libraries.maps.GoogleMap
import com.google.android.libraries.maps.MapView
import com.google.android.libraries.maps.model.*
import com.google.firebase.database.*

class MainActivity : Activity(){
    companion object {
        private val MAPVIEW_BUNDLE_KEY = "MapViewBundleKey"
        private val markerIconSize = 90
    }

    var mMapView: MapView? = null
    private var map: GoogleMap? = null
    lateinit var databaseReference : DatabaseReference
    internal var marker: Marker? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mapViewBundle: Bundle? = savedInstanceState?.getBundle(MAPVIEW_BUNDLE_KEY)
        mMapView = findViewById(R.id.mapView) as MapView
        mMapView?.onCreate(mapViewBundle)

        mMapView!!.getMapAsync {
             googlemap ->
            map = googlemap


            databaseReference =
                FirebaseDatabase.getInstance().reference
            databaseReference.addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onDataChange(p0: DataSnapshot) {
                    map!!.clear()
                    for (child in p0.children){
                        var data =child.getValue(AmbilData::class.java)
                        var latitude = data!!.latitude.toString()
                        var longitude = data.longitude.toString()
                        var tinggi = data.tinggi.toString()
                        var status = data.status.toString()
                        var warna = data.warna.toString()
                        var markerposisi: LatLng? = LatLng(latitude.toDouble(), longitude.toDouble())

                        val markerIcon =
                            BitmapUtils.resizeMapIcons(this@MainActivity, R.drawable.marker, markerIconSize, markerIconSize)
                        marker = map?.addMarker(
                            MarkerOptions().position(markerposisi!!).icon(
                                BitmapDescriptorFactory.defaultMarker(warna.toFloat())
                            ).title("Lokasi : ${latitude+","+longitude}").snippet("Ketinggian air : $tinggi" +
                                    " status = $status"  )
                        )
//                        map?.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(-7.947432, 112.616824),14f))
                        val cameraPosition =
                            CameraPosition.Builder().target(LatLng(-7.947432, 112.616824)).zoom(14f).build()
                        map!!.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
                      }


                }

            })
        }
            }


    override fun onResume() {
        super.onResume()
        mMapView?.onResume()
    }

    override fun onStart() {
        super.onStart()
        mMapView?.onStart()
    }

    override fun onStop() {
        super.onStop()
        mMapView?.onStop()
    }

    override fun onPause() {
        mMapView?.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        mMapView?.onDestroy()
        super.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mMapView?.onLowMemory()
    }


}
