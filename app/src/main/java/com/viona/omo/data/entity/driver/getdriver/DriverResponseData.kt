package com.viona.omo.data.entity.driver.getdriver

import com.google.gson.annotations.SerializedName

data class DriverResponseData(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("username")
    val username: String? = null,

    @SerializedName("password")
    val password: String? = null,

    @SerializedName("vehicleType")
    val vehicleType: String? = null,

    @SerializedName("vehicleRegistNumber")
    val vehicleRegisterNumber: String? = null
)