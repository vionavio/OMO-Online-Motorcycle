package com.viona.omo.data.response

import com.google.gson.annotations.SerializedName
import com.viona.omo.data.response.base.BaseResponse

data class RegisterCustomerResponse(
    
    @SerializedName("status")
    override var status: Boolean = false,

    @SerializedName("message")
    override var message: String? = null,


    @SerializedName("data")
    val data: Boolean = false

): BaseResponse