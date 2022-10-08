package com.viona.omo.maps

import android.location.Location
import com.viona.utils.listener.ActivityListener

interface MainActivityListener : ActivityListener {
    fun onLocationResult(data: Location)
}