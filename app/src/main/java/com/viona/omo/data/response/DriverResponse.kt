package com.viona.omo.data.response

import com.google.gson.annotations.SerializedName
import com.viona.omo.data.entity.driver.getdriver.DriverResponseData
import com.viona.omo.data.response.base.BaseResponse

data class DriverResponse(
    @SerializedName("status")
    override var status: Boolean = false,

    @SerializedName("message")
    override var message: String? = null,

    @SerializedName("data")
    val data: DriverResponseData
) : BaseResponse