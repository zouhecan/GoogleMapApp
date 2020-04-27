package com.example.googlemapapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.ViewGroup
import com.google.android.gms.maps.*

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*
import kotlinx.android.synthetic.main.activity_webview.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private val logTag = MapsActivity::class.java.canonicalName
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as MapComponent
        mapFragment.getMapAsync(this)
        Handler().postDelayed(Runnable {
            val urls = ArrayList(
                mutableListOf(
                    "https://help.github.com/cn/github/using-git/resolving-merge-conflicts-after-a-git-rebase",
                    "https://juejin.im/entry/5ae9706d51882567327809d0",
                    "https://zhuanlan.zhihu.com/p/32536915"
                )
            )
//            Log.d("zouhecan", "startWebViewActivity")
            startActivity(Intent(this, WebViewActivity::class.java).apply {
                putStringArrayListExtra("URLS", urls)
            })
        }, 2000)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        Log.d(logTag, "onMapReady")
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}
