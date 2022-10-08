package com.viona.omo.maps

import android.location.Location
import com.viona.core.state.StateEventManager

interface HomeRepository {
    val locationResult: StateEventManager<Location>

    suspend fun getLocation()
}