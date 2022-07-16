package com.viona.omo.data.response

import com.google.gson.annotations.SerializedName
import com.viona.omo.data.entity.driver.login.LoginDriverResponseData
import com.viona.omo.data.response.base.BaseResponse

data class LoginDriverResponse(
    @SerializedName("status")
    override var status: Boolean = false,

    @SerializedName("message")
    override var message: String? = null,


    @SerializedName("data")
    val data: LoginDriverResponseData

): BaseResponse