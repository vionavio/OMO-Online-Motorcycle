package com.viona.locationapi

import com.google.android.gms.maps.model.LatLng
import com.viona.locationapi.entity.LocationData
import com.viona.locationapi.response.LocationResponse
import com.viona.utils.orNol

object Mapper {

    fun mapLocationResponseToData(locationResponse: LocationResponse?): List<LocationData> {
        val mapperData: (LocationResponse.Data?) -> LocationData = {
            val name = it?.name.orEmpty()
            val address = "${it?.address?.distric}, ${it?.address?.country}, ${it?.address?.city}"
            val latLng = LatLng(it?.coordinate?.latitude.orNol(), it?.coordinate?.longitude.orNol())
            LocationData(name, address, latLng)
        }

        return locationResponse?.data?.map(mapperData).orEmpty()
    }
}