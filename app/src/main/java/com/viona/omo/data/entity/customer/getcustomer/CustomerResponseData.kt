package com.viona.omo.data.entity.customer.getcustomer

import com.google.gson.annotations.SerializedName

data class CustomerResponseData(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("username")
    val username: String? = null,

    @SerializedName("password")
    val password: String? = null
)