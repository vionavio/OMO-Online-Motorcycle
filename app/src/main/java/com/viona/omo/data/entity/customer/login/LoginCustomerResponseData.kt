package com.viona.omo.data.entity.customer.login

import com.google.gson.annotations.SerializedName

data class LoginCustomerResponseData(
    @SerializedName("token")
    val token: String? = null
)