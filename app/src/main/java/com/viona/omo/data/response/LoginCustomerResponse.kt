package com.viona.omo.data.response

import com.google.gson.annotations.SerializedName
import com.viona.omo.data.entity.customer.login.LoginCustomerResponseData
import com.viona.omo.data.response.base.BaseResponse

data class LoginCustomerResponse(

    @SerializedName("status")
    override var status: Boolean = false,

    @SerializedName("message")
    override var message: String? = null,


    @SerializedName("data")
    val data: LoginCustomerResponseData
): BaseResponse