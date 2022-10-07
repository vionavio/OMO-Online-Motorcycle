package com.viona.omo.data.response.user

import com.google.gson.annotations.SerializedName
import com.viona.omo.data.entity.user.getUser.UserResponseData
import com.viona.omo.data.response.base.BaseResponse


data class UserResponse(
    @SerializedName("status")
    override var status: Boolean = false,

    @SerializedName("message")
    override var message: String? = null,

    @SerializedName("data")
    val data: UserResponseData

) : BaseResponse