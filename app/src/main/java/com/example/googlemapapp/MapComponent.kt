package com.example.googlemapapp

import android.content.Intent
import android.os.Bundle
import android.util.ArrayMap
import android.util.Log
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker

/**
 * desc:
 * author: zouhecan {hc.zou@ctrip.com}
 * date: 2020/4/22
 */
class MapComponent : SupportMapFragment(), GoogleApiClient.ConnectionCallbacks,
    GoogleApiClient.OnConnectionFailedListener,
    GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMapClickListener,
    GoogleMap.OnMapLongClickListener, GoogleMap.OnMarkerClickListener {

    private val logTag = MapComponent::class.java.canonicalName

    override fun onConnected(p0: Bundle?) {
        Log.d(logTag, "onConnected")
    }

    override fun onConnectionSuspended(p0: Int) {
        Log.d(logTag, "onConnectionSuspended")
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        Log.d(logTag, "ConnectionResult:$p0")
    }

    override fun onInfoWindowClick(p0: Marker?) {
        Log.d(logTag, "onInfoWindowClick")
    }

    override fun onMapClick(p0: LatLng?) {
        Log.d(logTag, "onMapClick=[longitude=${p0?.longitude}, latitude=${p0?.latitude}]")
    }

    override fun onMapLongClick(p0: LatLng?) {
        Log.d(logTag, "onMapLongClick=[longitude=${p0?.longitude}, latitude=${p0?.latitude}]")
    }

    override fun onMarkerClick(p0: Marker?): Boolean {
        Log.d(logTag, "onMarkerClick")
        val urls = ArrayList(
            mutableListOf(
                "https://help.github.com/cn/github/using-git/resolving-merge-conflicts-after-a-git-rebase",
                "https://juejin.im/entry/5ae9706d51882567327809d0"
            )
        )
        context?.startActivity(Intent(context, WebViewActivity::class.java).apply {
            putStringArrayListExtra("URLS", urls)
        })
        return true
    }
}