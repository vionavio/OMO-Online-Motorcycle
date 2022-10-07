package com.viona.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.viona.core.extensions.asFlowStateEvent
import com.viona.core.extensions.convertEventToSubscriber
import com.viona.core.state.MutableStateEventManager
import com.viona.core.state.StateEvent
import com.viona.core.state.StateEventManager
import com.viona.core.state.StateEventSubscriber
import com.viona.locationapi.LocationWebServices
import com.viona.locationapi.Mapper
import com.viona.locationapi.StateLocationList
import com.viona.locationapi.entity.LocationData
import kotlinx.coroutines.launch

class SearchLocationViewModel(
    private val webServices: LocationWebServices
) : ViewModel() {

    private val _locationListLive: MutableLiveData<StateLocationList> = MutableLiveData(StateEvent.Idle())
    val locationListLive: LiveData<StateLocationList>
        get() = _locationListLive

    private val _locationStateManager: MutableStateEventManager<List<LocationData>> = MutableStateEventManager()
    private val locationStateManager: StateEventManager<List<LocationData>>
        get() = _locationStateManager

    fun getLocations(name: String) = locationStateManager.createScope(viewModelScope).launch {
        val coordinateString = "-6.2842147,106.8447178"
        webServices.searchLocation(name, coordinateString).asFlowStateEvent {
            Mapper.mapLocationResponseToData(it)
        }.collect(_locationStateManager)
    }

    fun subscribeLocationStateManager(subscriber: StateEventSubscriber<List<LocationData>>) {
        convertEventToSubscriber(locationStateManager, subscriber)
    }
}