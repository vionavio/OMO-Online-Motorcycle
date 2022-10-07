package com.viona.omo.login.data.response.user

import com.google.gson.annotations.SerializedName
import com.viona.omo.login.data.entity.user.login.LoginUserResponseData
import com.viona.omo.login.data.response.base.BaseResponse


data class LoginUserResponse(
    @SerializedName("status")
    override var status: Boolean = false,

    @SerializedName("message")
    override var message: String? = null,

    @SerializedName("data")
    val data: LoginUserResponseData

) : BaseResponse