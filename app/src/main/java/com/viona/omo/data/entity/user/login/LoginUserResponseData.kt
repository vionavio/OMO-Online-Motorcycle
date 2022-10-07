package com.viona.omo.data.entity.user.login

import com.google.gson.annotations.SerializedName

data class LoginUserResponseData(
    @SerializedName("token")
    val token: String? = null
)