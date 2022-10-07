package com.viona.omo.login.data.response.user

import com.google.gson.annotations.SerializedName
import com.viona.omo.login.data.entity.user.getUser.UserResponseData
import com.viona.omo.login.data.response.base.BaseResponse


data class UserResponse(
    @SerializedName("status")
    override var status: Boolean = false,

    @SerializedName("message")
    override var message: String? = null,

    @SerializedName("data")
    val data: UserResponseData

) : BaseResponse