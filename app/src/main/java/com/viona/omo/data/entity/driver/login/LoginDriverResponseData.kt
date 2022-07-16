package com.viona.omo.data.entity.driver.login

import com.google.gson.annotations.SerializedName

data class LoginDriverResponseData(
    @SerializedName("token")
    val token: String? = null
)