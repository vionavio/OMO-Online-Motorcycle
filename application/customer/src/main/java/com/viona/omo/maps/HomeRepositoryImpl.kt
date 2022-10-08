package com.viona.omo.maps

import android.location.Location
import com.viona.core.LocationManager
import com.viona.core.extensions.mapStateEvent
import com.viona.core.state.MutableStateEventManager
import com.viona.core.state.StateEventManager

class HomeRepositoryImpl(
    private val locationManager: LocationManager
) : HomeRepository {

    private val _locationResult = MutableStateEventManager<Location>()
    override val locationResult: StateEventManager<Location>
        get() = _locationResult

    override suspend fun getLocation() {
        locationManager.getLocationFlow()
            .mapStateEvent()
            .collect(_locationResult)
    }
}