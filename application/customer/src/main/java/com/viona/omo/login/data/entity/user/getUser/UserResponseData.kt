package com.viona.omo.login.data.entity.user.getUser

import com.google.gson.annotations.SerializedName


data class UserResponseData(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("username")
    val username: String? = null,

    @SerializedName("password")
    val password: String? = null,

    @SerializedName("role")
    val role: String? = null
)